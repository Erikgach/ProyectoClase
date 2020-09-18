package org.una.tramites.dto;

import java.util.ArrayList;
import java.util.List;

public class TramiteCambioEstadoDTO {
    private List<UsuarioDTO> usuarios = new ArrayList<>();
    private List<TramiteRegistradoDTO> tramitesRegistrados = new ArrayList<>();
    private List<TramiteEstadoDTO> tramitesEstado = new ArrayList<>();
}
