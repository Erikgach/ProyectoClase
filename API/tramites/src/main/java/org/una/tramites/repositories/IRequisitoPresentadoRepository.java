package org.una.tramites.repositories;

import org.una.tramites.entities.RequisitoPresentado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IRequisitoPresentadoRepository extends JpaRepository<RequisitoPresentado, Long>{

    public Optional<RequisitoPresentado> findById(Long id);

    public List<RequisitoPresentado> findByFechaRegistroBetween(Date startDate, Date endDate);
}