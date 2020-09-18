package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "requisitos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Requisito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="variaciones_id")
    private Variacion variacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column
    private boolean estado;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisito")
    private List<RequisitoPresentado> requisitoPresentados = new ArrayList<>();

    private static final long serialVersionUID = 1L;
}
