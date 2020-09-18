package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.Permiso;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPermisoRepository extends JpaRepository<Permiso, Long> {

    public Optional<Permiso> findById(Long id);

    public List<Permiso> findByEstado(boolean estado);

    public List<Permiso> findByFechaRegistroBetween(Date startDate, Date endDate);

    public  Permiso findByCodigo(String codigo);

    public Long countByEstado(boolean estado);

}
