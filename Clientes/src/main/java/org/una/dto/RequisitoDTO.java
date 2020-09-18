package org.una.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class RequisitoDTO {

    private Long id;
    private String descripcion;
    private boolean estado;
    private Date fechaRegistro;
    private VariacionDTO variaciones;
    private List<RequisitoPresentadoDTO> requisitosPresentados = new ArrayList<>();
}

