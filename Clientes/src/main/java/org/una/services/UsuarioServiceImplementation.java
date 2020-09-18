package org.una.services;


import com.google.gson.Gson;
import org.apache.http.ParseException;
import org.una.dto.*;
import org.una.dto.UsuarioDTO;
import org.una.util.AppContext;
import org.una.util.JsonOperation;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImplementation implements IUsuarioService{
    List<UsuarioDTO> usuarios ;
    AuthenticationResponse authentication = authentication = (AuthenticationResponse) AppContext.getInstance().get("autenticacion");
    @Override
    public int login(AuthenticationRequest authenticationRequest) throws IOException, InterruptedException {
        Gson g = new Gson();

        String peticion = g.toJson(authenticationRequest);

        System.out.println(peticion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8099/usuarios/login"))
                .header("content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(peticion))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());



        AuthenticationResponse p = g.fromJson(response.body(), AuthenticationResponse.class);
        AppContext.getInstance().set("autenticacion", p);
        int responseCode = response.statusCode();
        return responseCode;

    }

    @Override
    public void cambiarContrasena(String id, String password) {

    }

    @Override
    public void getPermisosUsuario(String id) {

    }

    @Override
    public UsuarioDTO findById(Long id) {

        for(UsuarioDTO usuarioDTO : usuarios){

            if(usuarioDTO.getId()==id){
                return usuarioDTO;
            }
        }

        return null;
    }

    @Override
    public List<UsuarioDTO> findByEstado(Boolean estado) {
        return null;
    }

    @Override
    public List<UsuarioDTO> finByNombre(String nombre) {

        List<UsuarioDTO> resul = new ArrayList<>();

        for(UsuarioDTO usuarioDTO : usuarios){

            if(usuarioDTO.getNombre().toUpperCase().contains(nombre.toUpperCase())){
                resul.add(usuarioDTO);

            }
        }

        return resul;
    }

    @Override
    public void cargarUsuarios() {
        List<UsuarioDTO> usuarioDTOS = null;

        if(authentication == null) System.out.println("aunteticion es NULL");
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("Authorization", "Bearer " + authentication.getJwt())
                    .uri(URI.create("http://localhost:8099/usuarios"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonOperation jsonOperation = new JsonOperation();
            usuarioDTOS = jsonOperation.convertirJsonToUsuarios(response.body());

        } catch (IOException | ParseException | InterruptedException ex) {
            // handle exception
        }
        AppContext.getInstance().set("usuarios", usuarioDTOS);
        usuarios = usuarioDTOS;

    }


    @Override
    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    @Override
    public UsuarioDTO update(UsuarioDTO usuarioDTO, long id) throws IOException, InterruptedException {
        Gson gson = new Gson();
        String idCadena = String.valueOf(id);
        String requestBody = gson.toJson(usuarioDTO);
        System.out.println(requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8099/usuarios/"+idCadena))
                .header("Authorization", "Bearer " + authentication.getJwt())
                .header("content-type", "application/json")
                //.header("accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        UsuarioDTO usuario = gson.fromJson(response.body(), UsuarioDTO.class);
        System.out.println(response.statusCode());


        return usuario;
    }

    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) throws IOException, InterruptedException {
        return null;
    }
}
