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

public class DetalleRequisitosController {
    public BorderPane bdp_detrequisitos;
    public HBox vbx_menu;
    public Button btn_ver;
    public Button btn_modificar;
    public Button btn_agregar;
    public AnchorPane acp_detrequisitos;
    public Button btn_guardar;
    public Button btn_cancelar;
    public Label txt_fecregistro;
    public ComboBox cbx_estado;
    public TextField txt_descripcion;
    public TextField txt_id;
    public Label lbl_descripcion;
    public Label lbl_fecregistro;
    public Label lbl_estado;
    public Label lbl_id;
    public Label lbl_titulo;
    public Button atrasbutton;

    public void btn_verAction(ActionEvent actionEvent) {
    }

    public void btn_modificarAction(ActionEvent actionEvent) {
    }

    public void btn_agregarAction(ActionEvent actionEvent) {
    }

    public void btn_cancelarAction(ActionEvent actionEvent) {
    }

    public void btn_guardarAction(ActionEvent actionEvent) {
    }
    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }
}
