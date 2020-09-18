package org.una.dto;




import java.util.List;



public class AuthenticationResponse {

    private String jwt;
    private UsuarioDTO usuario;
    private List<PermisoOtorgadoDTO> permisos;

    public void setJwt(String token) {
        jwt = token;
    }

    public String getJwt() {
        return jwt;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public List<PermisoOtorgadoDTO> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<PermisoOtorgadoDTO> permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "jwt='" + jwt + '\'' +
                ", usuario=" + usuario +
                ", permisos=" + permisos +
                '}';
    }
}


