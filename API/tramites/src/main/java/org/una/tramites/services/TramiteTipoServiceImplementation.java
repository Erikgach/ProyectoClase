package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.repositories.ITramiteTipoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class TramiteTipoServiceImplementation implements ITramiteTipoService{

    @Autowired
    private ITramiteTipoRepository tramitetipoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<TramiteTipo> findById(Long id) {
        return tramitetipoRepository.findById(id);
    }

    @Override
    public Optional<TramiteTipo> findByDescripcion(String descripcion) {
        return Optional.empty();
    }

    @Override
    public Optional<TramiteTipo> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return Optional.empty();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipo>> findAll() {
        return Optional.ofNullable(tramitetipoRepository.findAll());
    }


    @Override
    public void delete(Long id) {
        tramitetipoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tramitetipoRepository.deleteAll();
    }
}