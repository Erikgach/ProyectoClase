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
public class RequisitoDTO {

    private Long id;
    private String descripcion;
    private boolean estado;
    private Date fechaRegistro;
    private VariacionDTO variaciones;
    private List<RequisitoPresentadoDTO> requisitosPresentados = new ArrayList<>();
}

