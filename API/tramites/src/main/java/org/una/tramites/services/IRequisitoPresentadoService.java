package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.RequisitoPresentado;


public interface IRequisitoPresentadoService {

    public Optional<List<RequisitoPresentado>> findAll();

    public Optional<RequisitoPresentado> findById(Long id);

    public Optional<RequisitoPresentado> findByFechaRegistroBetween(Date startDate, Date endDate);

    public void delete(Long id);

    public void deleteAll();

}

