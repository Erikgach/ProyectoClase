package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "variaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Variacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="tramites_tipos_id")
    private TramiteTipo tramiteTipo;

    @Column
    private boolean grupo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column
    private boolean estado;


    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "variacion")
    private List<Requisito> requisitos = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
    }

}