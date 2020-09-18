package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.Departamento;
import org.una.tramites.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {

    public List<Departamento> findByEstado(boolean estado);


}
