package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tramites_cambios_estados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TramiteCambioEstado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name="tramites_registrados_id")
    private TramiteRegistrado tramiteRegistrado;

    @ManyToOne
    @JoinColumn(name="tramites_estados_id")
    private TramiteEstado tramiteEstado;

    @ManyToOne
    @JoinColumn(name="usuarios_id")
    private Usuario usuario;

    private static final long serialVersionUID = 1L;

}
