package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.event.Event;
import org.una.util.FlowController;

public class DisenoTramitesController
{
    public BorderPane bdp_disenotramites;
    public TabPane tabp_disenotramites;
    public Tab ven_variaciones;
    public AnchorPane acp_variaciones;
    public Button btn_agregarV;
    public TableView tabl_variaciones;
    public TableColumn col_idV;
    public TableColumn col_variacionV;
    public TableColumn col_estadoV;
    public TableColumn col_grupoV;
    public TableColumn col_accionesV;
    public Button btn_cancelarV;
    public Button btn_guerdarV;
    public Tab ven_requisitos;
    public AnchorPane acp_requisitos;
    public TableView tabl_requisitos;
    public TableColumn col_idR;
    public TableColumn col_requisitoR;
    public TableColumn col_estadoR;
    public TableColumn col_accionesR;
    public Button btn_agregarR;
    public Button btn_cancelarRAction;
    public Button btn_guardarR;
    public VBox vbx_menu;
    public TextField txt_consulta;
    public Label lbl_titulo;
    public Button btn_buscar;
    public Button btn_borrar;
    public Button atrasbutton;


    public void btn_borrarAction(ActionEvent actionEvent) {
    }

    public void btn_buscarAction(ActionEvent actionEvent) {
    }


    public void btn_agregarVAction(ActionEvent actionEvent) {
    }

    public void btn_cancelarVAction(ActionEvent actionEvent) {
    }

    public void btn_guardarVAction(ActionEvent actionEvent) {
    }

    public void btn_agregarRAction(ActionEvent actionEvent) {
    }

    public void btn_guardarRAction(ActionEvent actionEvent) {
    }

    public void cancelarRAction(ActionEvent actionEvent) {
    }

    public void vent_requisitosAction(Event event){
    }

    public void ven_variacionesAction(Event event){

    }
    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }


}
