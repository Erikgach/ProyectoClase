package org.una.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TramiteTipoDTO {

    private Long id;
    private String descripcion;
    private boolean estado;
    private DepartamentoDTO departamento;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private List<VariacionDTO> variaciones = new ArrayList<>();

}
