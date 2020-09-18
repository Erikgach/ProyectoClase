package org.una.tramites.services;

import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Departamento;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    public Optional<List<Departamento>> findByEstado(Boolean estado);
    public Optional<List<Departamento>>  findAll();
    public Departamento create(Departamento departamento);
    public Optional<Departamento> update(Departamento departamento, Long id);
    public void delete(Long id) ;





}
