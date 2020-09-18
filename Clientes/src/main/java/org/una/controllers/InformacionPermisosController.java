package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.una.util.FlowController;

public class InformacionPermisosController {


    public AnchorPane acp_permisos;
    public Label lbl_fecmodificacion;
    public Label lbl_fecregistro;
    public TextField txt_estado;
    public Label lbl_estado;
    public TextField txt_fecmodificacion;
    public TextField txt_fecregistro;
    public TextField txt_descripcion;
    public Label lbl_descripcion;
    public Button btn_eliminar;
    public Button btn_modificar;
    public Label lbl_titulo;
    public TextField txt_consultar;
    public Button btn_buscar;
    public Button btn_borrar;
    public TableView tbl_infopermisos;
    public TableColumn col_id;
    public TableColumn col_codigo;
    public TableColumn col_descripcion;
    public TableColumn col_estado;
    public TableColumn col_fecregistro;
    public TableColumn col_fecmodificacion;
    public Button btn_cerrar;
    public Button btn_agregar;
    public Label lbl_codigo;
    public TextField txt_codigo;
    public Button atrasbutton;

    public void btn_modificarAction(ActionEvent actionEvent) {
    }

    public void btn_eliminarAction(ActionEvent actionEvent) {
    }

    public void btn_borrarAction(ActionEvent actionEvent) {
    }

    public void btn_agregarAction(ActionEvent actionEvent) {
    }

    public void btn_cerrarAction(ActionEvent actionEvent) {
    }

    public void btn_buscarAction(ActionEvent actionEvent) {
    }
    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }
}
