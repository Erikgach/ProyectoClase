package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_completo", length = 100)
    private String nombreCompleto;
    @Column(name = "cedula", length = 100)
    private String cedula;
    @Column(name = "telefono",length = 10)
    private String telefono;
    @Column(name = "direccion",length = 100)
    private String direccion;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Column
    private boolean estado;
    @Column(name = "password_encriptado",length = 100)
    private String passwordEncriptado;
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<TramiteRegistrado> tramiteRegistrados= new ArrayList<>();
    private static final long serialVersionUID = 1L;*/
}
