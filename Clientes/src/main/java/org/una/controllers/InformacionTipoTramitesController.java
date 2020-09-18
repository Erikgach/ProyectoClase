package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.una.util.FlowController;

public class InformacionTipoTramitesController {


    public Button btn_agregar;
    public Button btn_cerrar;
    public TableView tbl_infotipostramites;
    public TableColumn col_id;
    public TableColumn col_descripcion;
    public TableColumn col_estado;
    public TableColumn col_fecregistro;
    public TableColumn col_fecmodificacion;
    public Button btn_borrar;
    public Button btn_buscar;
    public TextField txt_consultar;
    public Label lbl_titulo;
    public Button btn_modificar;
    public Button btn_eliminar;
    public Label lbl_descripcion;
    public Label lbl_estado;
    public Label lbl_fecregistro;
    public Label lbl_fecmodificacion;
    public TextField txt_descripcion;
    public TextField txt_estado;
    public TextField txt_fecregistro;
    public TextField txt_fecmodificacion;
    public Button atrasbutton;

    public void btn_agregarAction(ActionEvent actionEvent) {
    }

    public void btn_cerrarAction(ActionEvent actionEvent) {
    }

    public void btn_borrarAction(ActionEvent actionEvent) {
    }

    public void btn_buscarAction(ActionEvent actionEvent) {
    }

    public void btn_modificarAction(ActionEvent actionEvent) {
    }

    public void btn_eliminarAction(ActionEvent actionEvent) {
    }

    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }
}
