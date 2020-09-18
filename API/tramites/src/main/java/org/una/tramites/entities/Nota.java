package org.una.tramites.entities;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "notas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="tramites_registrados_id")
    private TramiteRegistrado tramiteRegistrado;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "tipo")
    private boolean tipo;

    @Column(length = 50, name = "titulo")
    private String titulo;

    @Column(name="contenido")
    private String contenido;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

}