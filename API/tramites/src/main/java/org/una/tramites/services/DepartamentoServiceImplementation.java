package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Departamento;
import org.una.tramites.repositories.IDepartamentoRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class DepartamentoServiceImplementation implements IDepartamentoService {

    @Autowired
    private IDepartamentoRepository departamentoRepository;


    @Override
    @Transactional(readOnly = true)
    public Optional<List<Departamento>> findByEstado(Boolean estado) {
        return Optional.ofNullable(departamentoRepository.findByEstado(estado));
    }

    @Override
    public Optional<List<Departamento>> findAll() {
        return Optional.ofNullable(departamentoRepository.findAll());
    }

    @Override
    public Departamento create(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Optional<Departamento> update(Departamento departamento, Long id) {
        if (departamentoRepository.findById(id).isPresent()) {
            departamento.preUpdate();
            return Optional.ofNullable(departamentoRepository.save(departamento));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        departamentoRepository.deleteById(id);
    }

}
