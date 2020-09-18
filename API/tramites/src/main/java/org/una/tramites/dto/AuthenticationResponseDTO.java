package org.una.tramites.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationResponseDTO {

    private String jwt;
    private UsuarioDTO usuario;
    private List<PermisoOtorgadoDTO> permisos;

    public void setJwt(String token) {
        jwt = token;
    }
}


