package org.una.tramites.services;

import org.una.tramites.entities.Permiso;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPermisoService {
    public Optional<Permiso> findById(Long id);

    public Optional<List<Permiso>> findByEstado(boolean estado);

    public Optional<List<Permiso>> findByFechaRegistroBetween(Date startDate, Date endDate);

    public Permiso create(Permiso permiso);

    public Optional<Permiso> update(Permiso permiso, Long id);

    public void delete(Long id);

    public void deleteAll();

    Optional<Permiso> findByCodigo(String codigo);

    Long countByEstado(boolean b);
}
