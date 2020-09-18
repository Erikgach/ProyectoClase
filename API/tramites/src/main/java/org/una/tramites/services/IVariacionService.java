package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Variacion;


public interface IVariacionService {

    public Optional<List<Variacion>> findAll();

    public Optional<Variacion> findById(Long id);

    public Optional<Variacion> findByDescripcion(String descripcion);

    public Optional<Variacion> findByFechaRegistroBetween(Date startDate, Date endDate);

    public void delete(Long id);

    public void deleteAll();

}