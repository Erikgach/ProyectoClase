package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.ParametroGeneral;
import org.una.tramites.repositories.IParametroGeneralRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ParametrosGeneralesServiceImplementation implements  IParametroGeneralService {


    @Autowired
    private IParametroGeneralRepository paramGenRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroGeneral>> findAll() {
        return Optional.ofNullable(paramGenRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ParametroGeneral> findById(Long id) {
        return paramGenRepository.findById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroGeneral>> findByNombre(String nombre) {
        return Optional.ofNullable(paramGenRepository.findByNombre(nombre));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroGeneral>> findByValor(String valor) {
        return Optional.ofNullable(paramGenRepository.findByValor(valor));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroGeneral>> findByDescripcion(String descripcion) {
        return Optional.ofNullable(paramGenRepository.findByDescripcion(descripcion));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ParametroGeneral>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return Optional.ofNullable(paramGenRepository.findByFechaRegistroBetween(startDate,endDate));
    }

    @Override
    @Transactional
    public ParametroGeneral create(ParametroGeneral pg) {
        return paramGenRepository.save(pg);
    }

    @Override
    @Transactional
    public Optional<ParametroGeneral> update(ParametroGeneral pg, Long id) {
        if (paramGenRepository.findById(id).isPresent()) {
            return Optional.ofNullable(paramGenRepository.save(pg));
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        paramGenRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void deleteAll() {
        paramGenRepository.deleteAll();

    }

}