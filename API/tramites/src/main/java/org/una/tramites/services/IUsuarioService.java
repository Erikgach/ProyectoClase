package org.una.tramites.services;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.una.tramites.dto.AuthenticationRequest;
import org.una.tramites.entities.Usuario;

import javax.management.remote.JMXAuthenticator;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public Optional<List<Usuario>> findAll();

    public Optional<Usuario> findById(Long id);

    public Optional<List<Usuario>> findByCedulaAproximate(String cedula);

    public Optional<List<Usuario>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

    public Usuario create(Usuario usuario);


    public Optional<Usuario> update(Usuario usuario, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<Usuario> login(Usuario usuario);

    public Optional<Usuario> findJefesByDepartamento(Long id);

    public Optional<List<Usuario>> findUsersByDepartamentoId(Long id);

    Optional<Usuario> findByCedula(String cedula);

    String login(AuthenticationRequest authenticationRequest);
}
