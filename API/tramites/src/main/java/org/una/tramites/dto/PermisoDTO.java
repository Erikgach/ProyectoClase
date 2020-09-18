package org.una.tramites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PermisoDTO {
    private Long id;
    private String codigo;
    private String descripcion;
    private boolean estado;
    private Date fechaRegistro;
    private Date fechaModificacion;

}
