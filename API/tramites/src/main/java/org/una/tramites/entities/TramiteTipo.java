package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tramites_tipos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TramiteTipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 100)
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

    @ManyToOne
    @JoinColumn(name="departamentos_id")
    private Departamento departamento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tramiteTipo")
    private List<Variacion> variaciones = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }

    private static final long serialVersionUID = 1L;


}