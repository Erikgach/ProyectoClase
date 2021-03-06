package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.dto.AuthenticationRequest;
import org.una.tramites.entities.Usuario;
import org.una.tramites.jwt.JwtProvider;
import org.una.tramites.repositories.IUsuarioRepository;

//import javax.transaction.Transactional;

import javax.management.remote.JMXAuthenticator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServiceImplementation implements UserDetailsService, IUsuarioService {



    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findAll() {
        return Optional.ofNullable(usuarioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findByCedulaAproximate(String cedula) {
        return Optional.ofNullable(usuarioRepository.findByCedulaContaining(cedula));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        return Optional.ofNullable(usuarioRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto));
    }

    @Override
    @Transactional
    public Usuario create(Usuario usuario) {
        encriptarPassword(usuario);
        return usuarioRepository.save(usuario);
    }


    @Override
    @Transactional
    public Optional<Usuario> update(Usuario usuario, Long id) {
        if (usuarioRepository.findById(id).isPresent()) {

            return Optional.ofNullable(usuarioRepository.save(usuario));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuarioRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> login(Usuario usuario) {
        return Optional.ofNullable(usuarioRepository.findByCedulaAndPasswordEncriptado(usuario.getCedula(), usuario.getPasswordEncriptado()));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findJefesByDepartamento(Long id){
        return Optional.ofNullable(usuarioRepository.findJefeByDepartamento(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findUsersByDepartamentoId(Long id) {
        return Optional.ofNullable(usuarioRepository.findByDepartamentoId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findByCedula(String cedula) {
        return  Optional.ofNullable(usuarioRepository.findByCedula(cedula));
    }
    @Override
    public String login(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtProvider.generateToken(authenticationRequest);

    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = Optional.ofNullable(usuarioRepository.findByCedula(username));

        if (usuarioBuscado.isPresent()) {

            Usuario usuario = usuarioBuscado.get();

            List<GrantedAuthority> roles = new ArrayList<>();

            roles.add(new SimpleGrantedAuthority("ADMIN"));

            UserDetails userDetails = new User(usuario.getCedula(), usuario.getPasswordEncriptado(), roles);

            return userDetails;

        } else {

            return null;

        }
    }

    @Autowired

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private void encriptarPassword(Usuario usuario) {

        String password = usuario.getPasswordEncriptado();

        if (!password.isBlank()) {

            usuario.setPasswordEncriptado(bCryptPasswordEncoder.encode(password));
            System.out.println("aqui");

        }

    }

}
