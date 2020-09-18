package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.repositories.ITransaccionRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class TransaccionServiceImplementation implements ITransaccionService{
    @Autowired
    ITransaccionRepository transaccionRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByPermisoOtorgadoId(Long id) {
        return Optional.ofNullable(transaccionRepository.findByPermisoOtorgadoId(id));
    }

    @Override
    public Optional<Transaccion> findById(Long id) {
        return transaccionRepository.findById(id);
    }

    /*@Override
    public Optional<List<Transaccion>> findByUsuarioIdAndFechaRegistroBetween(Long usuarioId, Date startDate, Date endDate) {
        return Optional.ofNullable(transaccionRepository.findByUsuarioIdAndFechaRegistroBetween(usuarioId,startDate,endDate));
    }*/

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByPermisoIdAndFechaRegistroBetween(Long permisoId, Date startDate, Date endDate) {
        return Optional.ofNullable(transaccionRepository.findByPermisoOtorgadoIdAndFechaRegistroBetween(permisoId,startDate,endDate));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate) {
        return Optional.ofNullable(transaccionRepository.findByObjetoAndFechaRegistroBetween(objeto,startDate,endDate));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return Optional.ofNullable(transaccionRepository.findByFechaRegistroBetween(startDate,endDate));
    }

    @Override
    @Transactional
    public Transaccion create(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }
}
