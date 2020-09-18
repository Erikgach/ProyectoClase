package org.una.tramites.services;

import org.una.tramites.entities.ParametroGeneral;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IParametroGeneralService {

    public Optional<List<ParametroGeneral>> findAll();

    public Optional<ParametroGeneral> findById(Long id);

    public Optional<List<ParametroGeneral>> findByNombre(String nombre);

    public Optional<List<ParametroGeneral>> findByValor(String valor);

    public Optional<List<ParametroGeneral>> findByDescripcion(String descripcion);

    public Optional<List<ParametroGeneral>> findByFechaRegistroBetween(Date startDate, Date endDate);

    public ParametroGeneral create(ParametroGeneral pg);

    public Optional<ParametroGeneral> update(ParametroGeneral pg, Long id);

    public void delete(Long id) ;

    public void deleteAll();
}