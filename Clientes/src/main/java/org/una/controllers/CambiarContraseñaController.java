package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.una.util.FlowController;

public class CambiarContraseñaController {
    public AnchorPane acp_cambiocontraseña;
    public Label lbl_titulo;
    public Button btn_abrir;
    public Label lbl_contrasenaactual;
    public TextField txt_contrasenaactual;
    public Label lbl_nuevacontraseña;
    public TextField txt_nuevacontraseña;
    public Label lbl_confirmarcontraseña;
    public TextField txt_confirmarContraseña;
    public Button btn_cambiarcontraseña;
    public Button atrasbutton;

    public void btn_cambiarcontraseñaAction(ActionEvent actionEvent) {
    }

    public void btn_abrirAction(ActionEvent actionEvent) {
    }
    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }
}
