package org.una.services;


import org.apache.http.ParseException;
import org.una.dto.AuthenticationResponse;
import org.una.dto.PermisoOtorgadoDTO;
import org.una.util.AppContext;
import org.una.util.JsonOperation;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PermisoOtorgadoServiceImplementation implements IPermisoOtorgadoService {
    List<PermisoOtorgadoDTO> permisos ;

    @Override
    public List<PermisoOtorgadoDTO> cargarPermisosUsuariiId() {
        List<PermisoOtorgadoDTO> permisosDTOS = null;
        AuthenticationResponse authentication = authentication = (AuthenticationResponse) AppContext.getInstance().get("autenticacion");
        if(authentication == null) System.out.println("aunteticion es NULL");
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("Authorization", "Bearer " + authentication.getJwt())
                    .uri(URI.create("http://localhost:8099/permisosOtorgados/usuario/"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonOperation jsonOperation = new JsonOperation();
            permisosDTOS = jsonOperation.convertirJsonToPermisos(response.body());

        } catch (IOException | ParseException | InterruptedException ex) {
            // handle exception
        }
        AppContext.getInstance().set("permisosOtorgados", permisosDTOS);
        permisos = permisosDTOS;
        return  permisos;


    }
}
