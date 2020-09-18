package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.una.tramites.entities.TramiteRegistrado;

import java.util.List;
import java.util.Optional;

public interface ITramiteRegistradoRepository extends JpaRepository<TramiteRegistrado, Long> {
    @Query("SELECT t FROM TramiteRegistrado t LEFT JOIN t.cliente d WHERE t.cliente.id =:id")
    public List<TramiteRegistrado> findByClientesId(Long id);
    public Optional<TramiteRegistrado> findById(Long id);
}
