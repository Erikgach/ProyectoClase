package org.una.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import org.una.App;
import org.una.dto.AuthenticationRequest;

import org.apache.http.ParseException;
import org.una.dto.AuthenticationResponse;
import org.una.services.IUsuarioService;
import org.una.services.UsuarioServiceImplementation;
import org.una.util.FlowController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class LoginController extends Controller {

    IUsuarioService usuarioService = new UsuarioServiceImplementation();
    public Button loginButton;
    public TextField usuarioText;
    public TextField contrasenaText;
    public VBox root;
    public String token;
    public ImageView img_municipalidad;



    String URL = "http://localhost:8099/usuarios/";


    @FXML
    private void validarUsuario() throws Exception {

        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setCedula(usuarioText.getText());
        authenticationRequest.setPassword(contrasenaText.getText());
        int code = usuarioService.login(authenticationRequest);
        if(verificarAutenticacion(code))  FlowController.getInstance().cambioPantalla("principal");

    }

    private boolean verificarAutenticacion(int code){
        if(code == 200 ) return true;
        else if(code == 500){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Trámites Municipales");
            alert.setTitle("Información");
            alert.setContentText("Credenciales Incorrectos");
            alert.showAndWait();
            return false;
        }
        return false;
    }


    @Override
    public void initialize() {

    }

}





