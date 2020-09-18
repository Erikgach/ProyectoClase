package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "departamentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Column(name = "nombre", length = 100)
    private String nombre;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Usuario> usuarios= new ArrayList<>();


    private static final long serialVersionUID = 1L;

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







}
