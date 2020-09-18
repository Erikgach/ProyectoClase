package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AutorizacionUsuariosController {

    public BorderPane bdp_autorizaciones;
    public VBox vbx_titulo;
    public Label lbl_titulo;
    public TabPane tab_autorizaciones;
    public Tab ven_infomacion;
    public AnchorPane acp_informacion;
    public Tab ven_autorizaciones;
    public AnchorPane acp_autorizaciones;
    public TextField txt_consulta;
    public Button btn_buscar;
    public Button btn_borrar;
    public Label lbl_usuario;
    public Label lbl_cedula;
    public Label txt_usuario;
    public Label txt_cedula;
    public TableView tabl_autorizaciones;
    public TableColumn col_check;
    public TableColumn col_id;
    public TableColumn col_codigo;
    public TableColumn col_nombre;
    public Button btn_cancelar;
    public Button btn_limpiar;
    public Button btn_guardar;
    public Tab ven_contrasena;
    public AnchorPane acp_contrasena;
    public Button btn_borrarC;
    public Button btn_buscarC;
    public TextField txt_consultaC;
    public TableView tbl_infousuarios;
    public TableColumn col_idC;
    public TableColumn col_nombreCompleto;
    public TableColumn col_cedula;
    public TableColumn col_estado;
    public Button btn_solicitarcambioC;
    public Button btn_cancelarC;
    public Button atrasbutton;

    public void btn_cancelarCAction(ActionEvent actionEvent) {
    }

    public void btn_solicitarcambioCAction(ActionEvent actionEvent) {
    }

    public void btn_buscarCAction(ActionEvent actionEvent) // nota cuando el metodo lleva una C a la par es de la ventana de contraseña
    {

    }


    public void btn_borrarCAction(ActionEvent actionEvent) {
    }

    public void ven_contrasenaAction(Event event) { //para pasar la ventana del tab
    }


    public void btn_guardarAction(ActionEvent actionEvent) {
    }

    public void btn_limpiarAction(ActionEvent actionEvent) {
    }

    public void btn_cancelarAction(ActionEvent actionEvent) {
    }

    public void btn_borrarAction(ActionEvent actionEvent) {
    }

    public void btn_buscarAction(ActionEvent actionEvent) {
    }

    public void ven_autorizacionesAction(Event event) {
    }

    public void ven_infomacionAction(Event event) {
    }
}
