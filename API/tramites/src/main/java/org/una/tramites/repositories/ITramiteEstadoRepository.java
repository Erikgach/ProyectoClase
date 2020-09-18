package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.TramiteEstado;
import org.una.tramites.entities.Transaccion;

public interface ITramiteEstadoRepository  extends JpaRepository<TramiteEstado, Long> {

}
