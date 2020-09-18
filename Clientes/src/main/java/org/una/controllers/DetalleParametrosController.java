package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.una.util.FlowController;

public class DetalleParametrosController {


    public BorderPane bdp_detparametros;
    public HBox vbx_menu;
    public Button btn_agregar;
    public Button btn_modificar;
    public Button btn_ver;
    public AnchorPane acp_detparametros;
    public Label lbl_fecmodificacion;
    public Label lbl_id;
    public Label lbl_descripcion;
    public TextField txt_id;
    public TextField txt_nombre;
    public Label txt_fecregistro;
    public Button btn_cancelar;
    public Button btn_guardar;
    public Label lbl_titulo;
    public Label lbl_nombre;
    public Label lbl_valor;
    public Label lbl_fecregistro;
    public TextField txt_valor;
    public TextField txt_descripcion;
    public Label txt_fecmodificacion;
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
