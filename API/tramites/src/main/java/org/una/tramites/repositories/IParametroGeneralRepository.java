package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.ParametroGeneral;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IParametroGeneralRepository extends JpaRepository<ParametroGeneral, Long> {

    public Optional<ParametroGeneral> findById(Long Id);

    public List<ParametroGeneral> findByNombre(String nombre);

    public List<ParametroGeneral> findByValor(String valor);

    public List<ParametroGeneral> findByDescripcion(String descripcion);

    public List<ParametroGeneral> findByFechaRegistroBetween(Date startDate, Date endDate);




}
