package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.tramites.entities.Departamento;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.entities.Usuario;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

    public List<Transaccion> findByPermisoOtorgadoId(Long id);

    public Optional<Transaccion> findById(Long id);
   //@Query("SELECT u FROM Transaccion")
   // public List<Transaccion> findByUsuarioIdAndFechaRegistroBetween(Long usuarioId, Date startDate, Date endDate);

    public List<Transaccion> findByPermisoOtorgadoIdAndFechaRegistroBetween(Long permisoId, Date startDate, Date endDate);

    public List<Transaccion> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate);

    public List<Transaccion> findByFechaRegistroBetween(Date startDate, Date endDate);



}
