package org.una.tramites.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VariacionDTO {


    private Long id;
    private boolean grupo;
    private String descripcion;
    private boolean estado;
    private Date fechaRegistro;
    private TramiteTipoDTO tramites;
    private List<RequisitoDTO> requisitos = new ArrayList<>();
}
