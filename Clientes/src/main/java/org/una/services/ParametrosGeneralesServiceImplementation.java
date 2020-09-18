package org.una.services;

import com.google.gson.Gson;
import org.apache.http.ParseException;
import org.una.dto.AuthenticationResponse;
import org.una.dto.ParametroGeneralDTO;
import org.una.util.AppContext;
import org.una.util.JsonOperation;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ParametrosGeneralesServiceImplementation implements  IParametroGeneralService {

    List<ParametroGeneralDTO> parametros ;
    AuthenticationResponse authentication = authentication = (AuthenticationResponse) AppContext.getInstance().get("autenticacion");

    @Override
    public List<ParametroGeneralDTO> cargarParametros() {
        List<ParametroGeneralDTO> parametrosDTOS = null;


        if(authentication == null) System.out.println("aunteticion es NULL");
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("Authorization", "Bearer " + authentication.getJwt())
                    .uri(URI.create("http://localhost:8099/parametros_generales/"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonOperation jsonOperation = new JsonOperation();
            parametrosDTOS = jsonOperation.convertirJsonToParametros(response.body());

        } catch (IOException | ParseException | InterruptedException ex) {
            // handle exception
        }
        AppContext.getInstance().set("parametros ", parametrosDTOS);
        parametros  = parametrosDTOS;
        return parametrosDTOS;
    }

    @Override
    public ParametroGeneralDTO findById(Long id) {


        for(ParametroGeneralDTO parametrogeneralDTO :parametros){

            if(parametrogeneralDTO.getId()==id){
                return parametrogeneralDTO;
            }
        }

        return null;

    }

    @Override
    public List<ParametroGeneralDTO> finByNombre(String nombre) {

        List<ParametroGeneralDTO> resul = new ArrayList<>();

        for(ParametroGeneralDTO parametrogeneralDTO : parametros){

            if(parametrogeneralDTO.getNombre().toUpperCase().contains(nombre.toUpperCase())){
                resul.add(parametrogeneralDTO);

            }
        }

        return resul;
    }

    @Override
    public List<ParametroGeneralDTO> finByValor(String valor) {
        return null;
    }

    @Override
    public List<ParametroGeneralDTO> finByDescripcion(String descripcion) {
        return null;
    }

    @Override
    public List<ParametroGeneralDTO> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return null;
    }


    @Override
    public int deleteById(Long id) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8099/parametros_generales/"+id))
                .header("Authorization", "Bearer " + authentication.getJwt())
                .header("content-type", "application/json")
                //.header("accept", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        int responseCode = response.statusCode();
        if(responseCode == 200)  parametros.remove(findById(id));
        System.out.println(responseCode);
        return responseCode;
    }


    @Override
    public List<ParametroGeneralDTO> getParametros() {
        return null;
    }

    @Override
    public List<ParametroGeneralDTO> getParametrosgenerales() {
        return parametros;
    }

    @Override
    public ParametroGeneralDTO update(ParametroGeneralDTO parametrogeneralDTO, long id) throws IOException, InterruptedException {
        Gson gson = new Gson();
        String idCadena = String.valueOf(id);
        String requestBody = gson.toJson(parametrogeneralDTO);
        System.out.println(requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8099/parametros_generales/"+idCadena))
                .header("Authorization", "Bearer " + authentication.getJwt())
                .header("content-type", "application/json")
                //.header("accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        ParametroGeneralDTO parametro = gson.fromJson(response.body(),ParametroGeneralDTO.class);
        System.out.println(response.statusCode());


        return parametro;
    }

    @Override
    public ParametroGeneralDTO create(ParametroGeneralDTO parametroDTO) throws IOException, InterruptedException {
        Gson gson = new Gson();
        String requestBody = gson.toJson(parametroDTO);
        System.out.println(requestBody);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8099/parametros_generales/"))
                .header("Authorization", "Bearer " + authentication.getJwt())
                .header("content-type", "application/json")
                //.header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        ParametroGeneralDTO parametro = gson.fromJson(response.body(),ParametroGeneralDTO.class);
        System.out.println(response.statusCode());


        return parametro;
    }

}
