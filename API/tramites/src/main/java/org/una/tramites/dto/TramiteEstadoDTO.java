package org.una.tramites.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TramiteEstadoDTO {
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
