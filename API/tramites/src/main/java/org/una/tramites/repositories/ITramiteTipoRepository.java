package org.una.tramites.repositories;
import org.una.tramites.entities.TramiteTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface ITramiteTipoRepository extends JpaRepository<TramiteTipo, Long>{

    public Optional<TramiteTipo> findById(Long id);

    public List<TramiteTipo> findByFechaRegistroBetween(Date startDate, Date endDate);

    public List<TramiteTipo> findByDescripcion(String descripcion);

}