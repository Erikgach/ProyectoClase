package org.una.tramites.services;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.dto.AuthenticationRequest;
import org.una.tramites.entities.Permiso;
import org.una.tramites.repositories.IPermisoRepository;

import javax.management.remote.JMXAuthenticator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PermisoServiceImplementation  implements IPermisoService{


    @Autowired
    private IPermisoRepository permisoRepository;
   /* @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findAll() {
        return Optional.ofNullable(usuarioRepository.findAll());*/


    @Override  //averiguar si esta bien asi
    @Transactional(readOnly = true)
    public Optional<Permiso> findById(Long id) {
        return permisoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Permiso>> findByEstado(boolean estado) {
        return Optional.ofNullable(permisoRepository.findByEstado(estado));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Permiso>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return Optional.ofNullable(permisoRepository.findByFechaRegistroBetween(startDate, endDate));
    }

    @Override
    @Transactional
    public Permiso create(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    @Override
    @Transactional
    public Optional<Permiso> update(Permiso permiso, Long id) {
        if (permisoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(permisoRepository.save(permiso));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {
        permisoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        permisoRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Permiso> findByCodigo(String codigo) {
        return Optional.ofNullable(permisoRepository.findByCodigo(codigo));
    }

    @Override
    public Long countByEstado(boolean b) {
        return permisoRepository.countByEstado(b);
    }




}
