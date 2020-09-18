package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.Departamento;
import org.una.tramites.entities.PermisoOtorgado;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPermisoOtorgadoRepository extends JpaRepository<PermisoOtorgado, Long> {
    public Optional<PermisoOtorgado> findById(Long usuarioId);

    public List<PermisoOtorgado> findByUsuarioId(Long usuarioId);

    public List<PermisoOtorgado> findByPermisoId(Long permisoId);

    public List<PermisoOtorgado> findByUsuarioIdAndEstado(Long usuarioId, boolean estado);

    public List<PermisoOtorgado> findByPermisoIdAndEstado(Long permisoId, boolean estado);

    public List<PermisoOtorgado> findByFechaRegistroBetween(Date startDate, Date endDate);


}
