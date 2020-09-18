package org.una.tramites.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tramites_estados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TramiteEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "estados_sucesores", length = 50)
    private String estadosSucesores;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tramiteEstado")
    private List<TramiteCambioEstado> tramiteCambioEstados= new ArrayList<>();

    private static final long serialVersionUID = 1L;
}