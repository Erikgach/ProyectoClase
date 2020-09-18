package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.una.util.FlowController;


import java.io.IOException;

public class PrincipalController extends  Controller {

    public Button cambiarButton;
    public AnchorPane root;
    public Pane pane_contenido;
    public Button bton_ver_menu;
    public Button bton_ocultar_menu;
    public VBox pane_menuP;
    public Button bton_departamentos;
    public MenuItem autoUsuarios;
    public MenuItem cambiasContrasena;
    public MenuItem detalleDepartamneto;
    public MenuItem detalleParametros;
    public MenuItem detallePermiso;
    public MenuItem detalledepartamentos;
    public MenuItem detalleRequisitos;
    public MenuItem detalleTipo;
    public MenuItem detalleUsuarios;
    public MenuItem diseñoTramites;
    public MenuItem detalleVariaciones;
    public MenuItem informacionDepartamento;
    public MenuItem informacionParametros;
    public MenuItem InformacionPermisos;
    public MenuItem informacionRequisitos;
    public MenuItem informacionTipo;
    public MenuItem informacionUsuarios;
    public MenuItem informacionVariaciones;
    public MenuItem tramitesRegistrados;
    public MenuItem detalleTramites1;
    public MenuItem diseñoTramites1;


    @FXML
    public void cambiarPantalla(ActionEvent actionEvent) throws IOException {


    }

    @Override
    public void initialize() {

    }

    public void btn_ocultarMenuAction(ActionEvent actionEvent) {
        pane_menuP.setVisible(false);
        bton_ver_menu.setVisible(true);
        bton_ocultar_menu.setVisible(false);

    }

    public void bton_verMunuAction(ActionEvent actionEvent) {
       pane_menuP.setVisible(true);
       bton_ocultar_menu.setVisible(true);
       bton_ver_menu.setVisible(false);


    }

    public void bton_departamentosAction(ActionEvent actionEvent) {
       FlowController.getInstance().cambioPantalla("InformacionDepartamentos");
    }

    public void auto_usuarios(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("AutorizacionUsuarios");
    }

    public void cambia_contrasena(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("CambiarContraseña");
    }
    public void detalle_departamento(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DetalleDepartamento");
    }
    public void detalle_parametro(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DetalleParametros");
    }
    public void detalle_permiso(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DetallePermisos");
    }
    public void detalle_requisito(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DetalleRequisitos");
    }
    public void detalle_tipo(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DetalleTipoTramites");
    }
    public void detalle_usuario(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DetalleUsusarios");
    }
    public void detalle_variaciones(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DetalleVariaciones");
    }
    public void detalle_tramites(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DetalleTramites");
    }
    public void diseno_tramite(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("DisenoTramite");
    }
    public void informacion_departamento(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("InformacionDepartamentos");
    }
    public void informacion_parametro(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("InformacionParametros");
    }
    public void informacion_permisos(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("InformacionPermisos");
    }
    public void informacion_requisito(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("InformacionRequisitos");
    }
    public void tipo_tramite(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("InformacionTipoTramite");
    }
    public void informacion_tramites(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("InformacionTipoTramite");
    }
    public void informacion_usuario(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("InformacionUsuarios");
    }
    public void informacion_variaciones(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("informacionVariaciones");
    }
    public void tramite_registrado(ActionEvent actionEvent){
        FlowController.getInstance().cambioPantalla("TramitesRegistrados");
    }





}
