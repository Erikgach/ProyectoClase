package org.una.tramites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.TramiteEstado;
import org.una.tramites.repositories.ITramiteEstadoRepository;

import java.util.List;
import java.util.Optional;
@Service
public class TramiteEstadoServiceImplementation implements ITramiteEstadoService{

    @Autowired
    private ITramiteEstadoRepository tramRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<TramiteEstado> findById(Long id) {
        return tramRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteEstado>> findAll() {
        return Optional.ofNullable(tramRepository.findAll());
    }

    @Override
    @Transactional
    public TramiteEstado create(TramiteEstado tramites) {
        return tramRepository.save(tramites);
    }

    @Override
    public Optional<TramiteEstado> update(TramiteEstado tramites, Long id) {
        if (tramRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tramRepository.save(tramites));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        tramRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tramRepository.deleteAll();
    }
}
