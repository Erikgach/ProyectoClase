package org.una.tramites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDTO {
    private Long id;
    private String nombreCompleto;
    private String cedula;
    private String telefono;
    private String direccion;
    private boolean estado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private String passwordEncriptado;
    private List<TramiteRegistradoDTO> tramitesRegistrados = new ArrayList<>();
}
