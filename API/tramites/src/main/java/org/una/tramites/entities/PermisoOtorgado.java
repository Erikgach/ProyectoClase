package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "permisos_otorgados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PermisoOtorgado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean estado;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name="permisos_id")
    private Permiso permiso;

    @ManyToOne
    @JoinColumn(name="usuarios_id")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisoOtorgado")
    private List<Transaccion> transacciones = new ArrayList<>();

    public void setPermiso(Permiso permiso) {
        permiso = permiso;
    }

    public void setUsuario(Usuario usuario) {
        usuario = usuario;
    }
}
