package org.una.tramites.repositories;


import org.una.tramites.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.PermisoOtorgado;

import java.util.Date;
import java.util.List;
import java.util.Optional;



public interface INotaRepository extends JpaRepository<Nota, Long>{

   public Optional<Nota> findById(Long id);

   public List<Nota> findByTipo(boolean tipo);

   public List<Nota> findByFechaRegistroBetween(Date startDate, Date endDate);

}