package org.una.tramites.repositories;

import org.una.tramites.entities.Requisito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IRequisitoRepository extends JpaRepository<Requisito, Long>{

    public Optional<Requisito> findById(Long id);

    public List<Requisito> findByDescripcion(String descripcion);

    public List<Requisito> findByFechaRegistroBetween(Date startDate, Date endDate);
}
