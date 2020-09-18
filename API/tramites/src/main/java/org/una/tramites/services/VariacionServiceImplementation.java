package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Variacion;
import org.una.tramites.repositories.IVariacionRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class VariacionServiceImplementation implements IVariacionService{

    @Autowired
    private IVariacionRepository variacionRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Variacion> findById(Long id) {
        return variacionRepository.findById(id);
    }

    @Override
    public Optional<Variacion> findByDescripcion(String descripcion) { return Optional.empty();
    }

    @Override
    public Optional<Variacion> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return Optional.empty();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<List<Variacion>> findAll() {
        return Optional.ofNullable(variacionRepository.findAll());
    }


    @Override
    public void delete(Long id) {
        variacionRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        variacionRepository.deleteAll();
    }
}