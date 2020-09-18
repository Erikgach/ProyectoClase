package org.una.tramites.entities;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "archivos_relacionados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArchivoRelacionado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column
    private boolean estado;

    @Column
    private boolean tipo;

    @Column(name="ruta_archivo")
    private String ruta_archivo;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name="etiquetas")
    private String etiquetas;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @ManyToOne
    @JoinColumn(name="tramites_registrados_id")
    private TramiteRegistrado tramiteRegistrado;

}