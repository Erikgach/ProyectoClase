package org.una.tramites.services;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.ArchivoRelacionado;


public interface IArchivoRelacionadoService {

    public Optional<List<ArchivoRelacionado>> findAll();

    public Optional<ArchivoRelacionado> findById(Long id);

    public Optional<ArchivoRelacionado> findByTipo(boolean tipo);

    public Optional<ArchivoRelacionado> findByFechaRegistroBetween(Date startDate, Date endDate);

    public void delete(Long id);

    public void deleteAll();

}