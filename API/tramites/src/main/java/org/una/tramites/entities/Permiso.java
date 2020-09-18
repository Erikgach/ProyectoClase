package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "permisos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permiso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 100)
    private String codigo;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column
    private boolean estado;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permiso")
    private List<PermisoOtorgado> permisosOtorgados= new ArrayList<>();

    public void setCodigo(String codigo) {
        codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }
}
