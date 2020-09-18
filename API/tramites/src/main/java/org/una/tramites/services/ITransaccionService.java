package org.una.tramites.services;

import org.una.tramites.entities.Departamento;
import org.una.tramites.entities.Transaccion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransaccionService {

    public Optional<List<Transaccion>> findByPermisoOtorgadoId(Long id);

    public Optional<Transaccion> findById(Long id);

   // public Optional<List<Transaccion>> findByUsuarioIdAndFechaRegistroBetween(Long usuarioId, Date startDate, Date endDate);

    public Optional<List<Transaccion>> findByPermisoIdAndFechaRegistroBetween(Long permisoId, Date startDate, Date endDate);

    public Optional<List<Transaccion>> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate);

    public Optional<List<Transaccion>> findByFechaRegistroBetween(Date startDate, Date endDate);

    public Transaccion create(Transaccion transaccion);
}
