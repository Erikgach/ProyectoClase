package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.PermisoOtorgado;
import org.una.tramites.repositories.IPermisoOtorgadoRepository;
import org.una.tramites.repositories.IPermisoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class PermisoOtorgadoServiceImplementation implements IPermisoOtorgadoService {

    @Autowired
    private IPermisoOtorgadoRepository permisoOtorgadoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<PermisoOtorgado> findById(Long usuarioId) {
        return permisoOtorgadoRepository.findById(usuarioId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgado>> findByUsuarioId(Long usuarioId) {
        return Optional.ofNullable(permisoOtorgadoRepository.findByUsuarioId(usuarioId));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgado>> findByPermisoId(Long permisoId) {
        return Optional.ofNullable(permisoOtorgadoRepository.findByPermisoId(permisoId));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgado>> findByUsuarioIdAndEstado(Long usuarioId, boolean estado) {
        return Optional.ofNullable(permisoOtorgadoRepository.findByUsuarioIdAndEstado(usuarioId,estado));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgado>> findByPermisoIdAndEstado(Long permisoId, boolean estado) {
        return Optional.ofNullable(permisoOtorgadoRepository.findByPermisoIdAndEstado(permisoId,estado));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgado>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return Optional.ofNullable(permisoOtorgadoRepository.findByFechaRegistroBetween(startDate,endDate));
    }

    @Override
    @Transactional
    public PermisoOtorgado create(PermisoOtorgado permisoOtorgado) {
       return permisoOtorgadoRepository.save(permisoOtorgado);
    }

    @Override
    @Transactional
    public Optional<PermisoOtorgado> update(PermisoOtorgado permisoOtorgado, Long id) {
        if(permisoOtorgadoRepository.findById(id).isPresent()){
            return Optional.ofNullable(permisoOtorgadoRepository.save(permisoOtorgado));
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        permisoOtorgadoRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void deleteAll() {
        permisoOtorgadoRepository.deleteAll();

    }
}
