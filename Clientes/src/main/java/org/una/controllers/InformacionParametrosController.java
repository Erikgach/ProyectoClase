package org.una.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.una.dto.DepartamentoDTO;
import org.una.dto.ParametroGeneralDTO;
import org.una.services.IParametroGeneralService;
import org.una.services.ParametrosGeneralesServiceImplementation;
import org.una.util.FlowController;

import java.io.IOException;
import java.util.List;

public class InformacionParametrosController extends Controller{


    public AnchorPane acp_parametros;
    public TextField txt_fecmodificacion;
    public TextField txt_fecregistro;
    public TextField txt_descripcion;
    public Label lbl_fecmodificacion;
    public Label lbl_fecregistro;
    public Label lbl_descripcion;
    public Button btn_eliminar;
    public Button btn_modificar;
    public Label lbl_titulo;
    public TextField txt_consultar;
    public Button btn_buscar;
    public Button btn_borrar;
    public TableView<ParametroGeneralDTO> tbl_infoparametros;
    public TableColumn<DepartamentoDTO, String> col_id;
    public TableColumn<DepartamentoDTO, String> col_nombre;
    public TableColumn<DepartamentoDTO, String>col_valor;
    public TableColumn<DepartamentoDTO, String> col_descripcion;
    public TableColumn<DepartamentoDTO, String> col_fecregistro;
    public TableColumn<DepartamentoDTO, String> col_fecmodificacion;
    public Button btn_cerrar;
    public Button btn_agregar;
    public Label lbl_nombre;
    public Label lbl_valor;
    public TextField txt_valor;
    public TextField txt_nombre;
    public Button atrasbutton;
    public ComboBox comboBox;
    IParametroGeneralService parametroGeneralService = new ParametrosGeneralesServiceImplementation();

    public void btn_eliminarAction(ActionEvent actionEvent) {
    }

    public void btn_modificarAction(ActionEvent actionEvent) {
    }

    public void btn_buscarAction(ActionEvent actionEvent) {
    }

    public void btn_borrarAction(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(!tbl_infoparametros.getSelectionModel().isEmpty()){
            int rowSelected = tbl_infoparametros.getSelectionModel().getSelectedIndex();
            Long idEliminar = tbl_infoparametros.getItems().get(rowSelected).getId();
            int code = parametroGeneralService.deleteById(idEliminar);
            if(!(code == 200)) System.out.println("Hubo errores durante la eliminacion");
            else {
                tbl_infoparametros.getItems().clear();
                tbl_infoparametros.setItems(parseListToObservable(parametroGeneralService.getParametros()));
            }


        }
    }

    public void btn_cerrarAction(ActionEvent actionEvent) {
    }

    public void btn_agregarAction(ActionEvent actionEvent) {
    }
    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }

    public ObservableList<ParametroGeneralDTO> parseListToObservable(List<ParametroGeneralDTO> lista) {

        ObservableList<ParametroGeneralDTO> parametroGeneralDTOS = FXCollections.observableArrayList();

        if ((lista != null)) {

            System.out.println("CARGANDO PARAMETROS");
            for (ParametroGeneralDTO parametroGeneralDTO : lista) {
                parametroGeneralDTOS.add(parametroGeneralDTO);
            }

        }

        return  parametroGeneralDTOS;
    }
    void cargarComboBox(){

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "ID",
                        "Nombre",
                        "Estado"
                );
        comboBox.setItems(options);
    }
    public void cargarParametros(){
        tbl_infoparametros.setItems(parseListToObservable(parametroGeneralService.cargarParametros()));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        //.setCellValueFactory(new PropertyValueFactory<>("estado"));
        col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        col_fecmodificacion.setCellValueFactory(new PropertyValueFactory<>("fechaModificacion"));
        col_fecregistro.setCellValueFactory(new PropertyValueFactory<>("fechaRegistro"));

    }

    @Override
    public void initialize() {

    }
}
