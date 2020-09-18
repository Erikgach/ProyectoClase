package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.TramiteTipo;


public interface ITramiteTipoService {

    public Optional<List<TramiteTipo>> findAll();

    public Optional<TramiteTipo> findById(Long id);

    public Optional<TramiteTipo> findByDescripcion(String descripcion);

    public Optional<TramiteTipo> findByFechaRegistroBetween(Date startDate, Date endDate);

    public void delete(Long id);

    public void deleteAll();

}