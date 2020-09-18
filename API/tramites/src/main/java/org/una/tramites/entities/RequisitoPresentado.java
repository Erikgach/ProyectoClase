package org.una.tramites.entities;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "requisitos_presentados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequisitoPresentado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="tramites_registrados_id")
    private TramiteRegistrado tramiteRegistrado;

    @ManyToOne
    @JoinColumn(name="requisitos_id")
    private Requisito requisito;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    private static final long serialVersionUID = 1L;

}