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

public class DetalleVariacionesController {


    public BorderPane bdp_detvariaciones;
    public HBox vbx_menu;
    public Button btn_agregar;
    public Button btn_modificar;
    public Button btn_ver;
    public AnchorPane acp_detvariaciones;
    public Label lbl_titulo;
    public Label lbl_id;
    public Label lbl_grupo;
    public Label lbl_estado;
    public Label lbl_fecregistro;
    public Label lbl_descripcion;
    public TextField txt_descripcion;
    public TextField txt_id;
    public ComboBox cbx_grupo;
    public Label txt_fecregistro;
    public Button btn_cancelar;
    public Button btn_guardar;
    public ComboBox cbx_estado;
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
