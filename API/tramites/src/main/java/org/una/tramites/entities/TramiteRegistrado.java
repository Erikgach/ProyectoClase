package org.una.tramites.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "tramites_registrados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class TramiteRegistrado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tramites_tipos")
    private String tramiteTipo;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "tramiteRegistrado")
    //private List<ArchivoRelacionado> archivoRelacionados  = new ArrayList<>();

   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "tramiteRegistrado")
   // private List<Nota> notas  = new ArrayList<>();

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "tramiteRegistrado")
  //  private List<RequisitoPresentado> requisitoPresentados  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tramiteRegistrado")
    private List<TramiteCambioEstado> tramiteCambioEstados= new ArrayList<>();

    private static final long serialVersionUID = 1L;
}
