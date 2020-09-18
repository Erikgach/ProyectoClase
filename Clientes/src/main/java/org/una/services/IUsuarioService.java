package org.una.services;


import org.una.dto.AuthenticationRequest;
import org.una.dto.UsuarioDTO;
import org.una.dto.UsuarioDTO;
import org.una.dto.UsuarioDTO;

import java.io.IOException;
import java.util.List;

public interface IUsuarioService {

    int login(AuthenticationRequest authenticationRequest) throws IOException, InterruptedException;
    void cambiarContrasena(String id, String password);
    void getPermisosUsuario(String id);
    UsuarioDTO findById(Long id);
    List<UsuarioDTO> findByEstado(Boolean estado);
    List<UsuarioDTO> finByNombre(String nombre);
    void cargarUsuarios();
    List<UsuarioDTO> getUsuarios();
    UsuarioDTO update(UsuarioDTO usuarioDTO, long id) throws IOException, InterruptedException;
    UsuarioDTO create(UsuarioDTO usuarioDTO) throws IOException, InterruptedException;


}
