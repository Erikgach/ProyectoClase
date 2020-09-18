package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.una.util.FlowController;

public class DetalleUsuariosController {


    public BorderPane bdp_detusuarios;
    public HBox vbx_menu;
    public Button btn_ver;
    public Button btn_modificar;
    public Button btn_agregar;
    public AnchorPane acp_detusuarios;
    public Label txt_fecmodificacion;
    public TextField txt_cedula;
    public TextField txt_nombrecompleto;
    public Label lbl_fecregistro;
    public Label lbl_cedula;
    public Label lbl_nombrecompleto;
    public Label lbl_titulo;
    public Button btn_guardar;
    public Button btn_cancelar;
    public Label txt_fecregistro;
    public TextField txt_id;
    public Label lbl_estado;
    public Label lbl_id;
    public Label lbl_fecmodificacion;
    public Label lbl_esjefe;
    public ComboBox cbx_estado;
    public ComboBox cbx_esjefe;
    public Button atrasbutton;


    public void btn_agregarAction(ActionEvent actionEvent) {
    }


    public void btn_modificarAction(ActionEvent actionEvent) {
    }

    public void btn_verAction(ActionEvent actionEvent) {
    }


    public void btn_cancelarAction(ActionEvent actionEvent) {
    }

    public void btn_guardarAction(ActionEvent actionEvent) {
    }
    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }
}
