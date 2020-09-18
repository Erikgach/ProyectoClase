package org.una.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.una.dto.DepartamentoDTO;
import org.una.dto.UsuarioDTO;
import org.una.services.IDepartamentoService;
import org.una.util.AppContext;
import org.una.util.FlowController;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class DetalleDepartamentosController extends Controller {


    public Label lbl_titulo;
    public Label lbl_id;
    public Label lbl_nombre;
    public Label lbl_estado;
    public Label lbl_fecregistro;
    public Button btn_cancelarVer;
    public Button btn_guardarVer;
    public DepartamentoDTO departamentoSeleccionado;
    public Label txt_modificacion;
    public Label txt_registro;
    public Label lbl_fecmodificacion;
    public Label txt_id;
    public Label txt_nombre;
    public Label txt_estado;
    public Tab tab_ver;

    public Tab tab_modificar;
    public RadioButton radioBtn_estado;
    public TabPane tabPane;
    public AnchorPane anchorPane;
    public Label txt_modificacionModificar;
    public Label txt_registoModificar;
    public TextField txt_nombreModificar;
    public TextField txt_idModificar;
    public Label lbl_fecmodificacion1;
    public RadioButton radioBtn_estadoModificar;
    public Button btn_guardarAgregacion;
    public Button btn_cancelarAgregacion;
    public Button btn_guardarModificacion;
    public Button btn_cancelarModificacion;
    public RadioButton radioBtob_agregar;
    public TextField txt_nombreAgregar;
    public Button atrasbutton;

    IDepartamentoService departamentoService ;


    public void btn_cancelarModificarAction(ActionEvent actionEvent) {

    }

    public void btn_guardarModificarAction(ActionEvent actionEvent) throws IOException, InterruptedException {
        DepartamentoDTO departamentoDTO = new DepartamentoDTO();
        departamentoDTO.setEstado(radioBtn_estadoModificar.isSelected());
        departamentoDTO.setNombre(txt_nombreModificar.getText());
        departamentoDTO.setId(departamentoSeleccionado.getId());
        departamentoDTO = departamentoService.update(departamentoDTO, departamentoSeleccionado.getId());

        System.out.println(departamentoDTO.toString());


    }
    String getStringDate(Date date) {

        try{
            DateFormat dateFormat = new SimpleDateFormat(
                    "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            dateFormat.parse("Tue Jul 13 00:00:00 CEST 2011");
            return dateFormat.format(date);
        }catch (ParseException exception){
            return "";
        }


    }
    void cargarDatosUsuariosVer() {

        txt_id.setText(String.valueOf(departamentoSeleccionado.getId()));
        txt_nombre.setText(departamentoSeleccionado.getNombre());
        txt_estado.setText(Boolean.toString(departamentoSeleccionado.isEstado()));

        txt_modificacion.setText(getStringDate(departamentoSeleccionado.getFechaModificacion()));
        txt_registro.setText(getStringDate(departamentoSeleccionado.getFechaRegistro()));
    }
    void cargarDatosUsuariosModificar(){

        txt_idModificar.setText(String.valueOf(departamentoSeleccionado.getId()));
        txt_idModificar.setDisable(true);
        txt_nombreModificar.setText(departamentoSeleccionado.getNombre());
        radioBtn_estadoModificar.setSelected(departamentoSeleccionado.isEstado());
        txt_registoModificar.setText(getStringDate(departamentoSeleccionado.getFechaRegistro()));
        txt_modificacionModificar.setText(getStringDate(departamentoSeleccionado.getFechaModificacion()));



    }
    @FXML
    protected  void initialize(URL Location, ResourceBundle resources){

    }
    @Override
    public void initialize() {
        departamentoSeleccionado = (DepartamentoDTO) AppContext.getInstance().get("departamentoSeleccionado");
        departamentoService = (IDepartamentoService) AppContext.getInstance().get("departamentoService");
        cargarDatosUsuariosVer();



    }

    public void tabClicked(MouseEvent mouseEvent) {
        if(tabPane.getSelectionModel().getSelectedIndex()==0){
            cargarDatosUsuariosVer();


        }else if(tabPane.getSelectionModel().getSelectedIndex()==1){
            cargarDatosUsuariosModificar();

        }else if(tabPane.getSelectionModel().getSelectedIndex()==2){

        }
    }

    public void btn_guardarAgregacionAction(ActionEvent actionEvent) throws IOException, InterruptedException {
        DepartamentoDTO departamentoDTO = new DepartamentoDTO();
        departamentoDTO.setEstado(radioBtob_agregar.isSelected());
        departamentoDTO.setNombre(txt_nombreAgregar.getText());
        departamentoDTO = departamentoService.create(departamentoDTO);

        System.out.println(departamentoDTO.toString());

    }
    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }
}
