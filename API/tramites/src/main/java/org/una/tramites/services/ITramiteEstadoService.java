package org.una.tramites.services;

import org.una.tramites.entities.TramiteEstado;

import java.util.List;
import java.util.Optional;

public interface ITramiteEstadoService {

    public Optional<TramiteEstado> findById(Long id);

    public Optional<List<TramiteEstado>> findAll();

    public TramiteEstado create(TramiteEstado tramites);

    public Optional<TramiteEstado> update(TramiteEstado tramites, Long id);

    public void delete(Long id);

    public void deleteAll();
}
