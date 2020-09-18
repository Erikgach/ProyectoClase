package org.una.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.ParseException;
import org.una.dto.AuthenticationResponse;
import org.una.dto.DepartamentoDTO;
import org.una.util.AppContext;
import org.una.util.JsonOperation;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DepartamentoServiceImplementation implements IDepartamentoService {

    List<DepartamentoDTO> departamentos ;
    AuthenticationResponse authentication = authentication = (AuthenticationResponse) AppContext.getInstance().get("autenticacion");

    @Override
    public List<DepartamentoDTO> cargarDepartamentos() {
        List<DepartamentoDTO> departamentoDTOS = null;


        if(authentication == null) System.out.println("aunteticion es NULL");
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("Authorization", "Bearer " + authentication.getJwt())
                    .uri(URI.create("http://localhost:8099/departamentos"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonOperation jsonOperation = new JsonOperation();
            departamentoDTOS = jsonOperation.convertirJsonToDepartamentos(response.body());

        } catch (IOException | ParseException | InterruptedException ex) {
            // handle exception
        }
        AppContext.getInstance().set("departamentos", departamentoDTOS);
        departamentos = departamentoDTOS;
        return departamentoDTOS;
    }

    @Override
    public DepartamentoDTO findById(Long id) {


       for(DepartamentoDTO departamentoDTO : departamentos){

           if(departamentoDTO.getId()==id){
               return departamentoDTO;
           }
       }

       return null;

    }

    @Override
    public List<DepartamentoDTO> findByEstado(Boolean estado) {
        List<DepartamentoDTO> departamentoDTOS = (List<DepartamentoDTO>) AppContext.getInstance().get("departamentos");
        List<DepartamentoDTO> resul = new ArrayList<>();


        for(DepartamentoDTO departamentoDTO : departamentoDTOS){

            if(departamentoDTO.isEstado() == estado){
                resul.add(departamentoDTO);

            }
        }

        return resul;
    }

    @Override
    public List<DepartamentoDTO> finByNombre(String nombre) {

        List<DepartamentoDTO> resul = new ArrayList<>();

        for(DepartamentoDTO departamentoDTO : departamentos){

            if(departamentoDTO.getNombre().toUpperCase().contains(nombre.toUpperCase())){
                resul.add(departamentoDTO);

            }
        }

        return resul;
    }

    @Override
    public int deleteById(Long id) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8099/departamentos/"+id))
                .header("Authorization", "Bearer " + authentication.getJwt())
                .header("content-type", "application/json")
                //.header("accept", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        int responseCode = response.statusCode();
        if(responseCode == 200)  departamentos.remove(findById(id));
        System.out.println(responseCode);
        return responseCode;
    }

    @Override
    public List<DepartamentoDTO> getDepartamentos() {
        return departamentos;
    }

    @Override
    public DepartamentoDTO update(DepartamentoDTO departamentoDTO, long id) throws IOException, InterruptedException {
        Gson gson = new Gson();
        String idCadena = String.valueOf(id);
        String requestBody = gson.toJson(departamentoDTO);
        System.out.println(requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8099/departamentos/"+idCadena))
                .header("Authorization", "Bearer " + authentication.getJwt())
                .header("content-type", "application/json")
                //.header("accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        DepartamentoDTO departamento = gson.fromJson(response.body(), DepartamentoDTO.class);
        System.out.println(response.statusCode());


        return departamento;
    }

    @Override
    public DepartamentoDTO create(DepartamentoDTO departamentoDTO) throws IOException, InterruptedException {
        Gson gson = new Gson();
        String requestBody = gson.toJson(departamentoDTO);
        System.out.println(requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8099/departamentos/"))
                .header("Authorization", "Bearer " + authentication.getJwt())
                .header("content-type", "application/json")
                //.header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        DepartamentoDTO departamento = gson.fromJson(response.body(), DepartamentoDTO.class);
        System.out.println(response.statusCode());


        return departamento;
    }


}



