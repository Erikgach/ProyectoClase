package org.una.tramites.repositories;


import org.una.tramites.entities.Variacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IVariacionRepository extends JpaRepository<Variacion, Long>{

    public Optional<Variacion> findById(Long id);

    public List<Variacion> findByFechaRegistroBetween(Date startDate, Date endDate);

    public List<Variacion> findByDescripcion(String descripcion);
}