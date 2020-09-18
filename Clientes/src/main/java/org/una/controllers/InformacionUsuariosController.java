package org.una.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;
import org.una.dto.UsuarioDTO;
import org.una.dto.UsuarioDTO;
import org.una.services.IUsuarioService;
import org.una.services.UsuarioServiceImplementation;
import org.una.util.FlowController;

import java.util.ArrayList;
import java.util.List;

public class InformacionUsuariosController extends Controller {
    public TabPane tabpane;
    public Button cancelarBton;
    public Button bton_guardar;
    public Button limpiarBton;
    public TextField txt_buscar;
    public Button bton_buscar;
    public Button bton_borrar;
    public Label lbl_nombre;
    public Label lbl_fecha_modificacion;
    public Label lbl_fecha_registro;
    public ComboBox combo_categorias;
    public Label lbl_cedula;
    public Button atrasbutton;
    IUsuarioService usuarioService = new UsuarioServiceImplementation();
    public UsuarioDTO usuarioSeleccionado ;


    private void setupTableView() {

    }

    private void setupTableViewColumn() {

    }

    public void cancelarBtonAction(ActionEvent actionEvent) {
    }

    public void guardarBtonAction(ActionEvent actionEvent) {
    }

    public void limpiarBtonAction(ActionEvent actionEvent) {
    }

    public void buscarBtonAction(ActionEvent actionEvent) {
        if(!combo_categorias.getSelectionModel().isEmpty()){
            String seleccion = (String) combo_categorias.getValue();
            String palabraBuscada = txt_buscar.getText();
            List<UsuarioDTO> result = new ArrayList<>();

            if(seleccion.equals("ID")){
                usuarioService.cargarUsuarios();
                UsuarioDTO resultado = usuarioService.findById(Long.parseLong(palabraBuscada));
                usuarioSeleccionado = resultado;
                cargarInfoUsuario(resultado);

            }else if(seleccion.equals("Nombre")){
                result = usuarioService.finByNombre(palabraBuscada);

            }else if(seleccion.equals("Estado")){
                if(palabraBuscada.equals("1")){
                    result = usuarioService.findByEstado(true);
                }else if(result.equals("0")){
                    result = usuarioService.findByEstado(false);
                }
            }
            if(!result.isEmpty()){


            }
        }
    }
    public void cargarPermisosOtorgados(){

    }
    public void cargarContrasena(){


    }
    public void tabClicked(MouseEvent mouseEvent) {
        if(tabpane.getSelectionModel().getSelectedIndex()==0){
            cargarInfoUsuario(usuarioSeleccionado);


        }else if(tabpane.getSelectionModel().getSelectedIndex()==1){


        }else if(tabpane.getSelectionModel().getSelectedIndex()==2){

        }
    }
    void cargarInfoUsuario(UsuarioDTO user){
        lbl_nombre.setText(user.getNombre());

        lbl_fecha_modificacion.setText(user.getFechaModificacion().toString());
        lbl_fecha_registro.setText(user.getFechaRegistro().toString());
        lbl_cedula.setText(user.getCedula());


    }
    void cargarComboBox(){

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "ID",
                        "Nombre",
                        "Estado"
                );
        combo_categorias.setItems(options);
    }

    public void autorizarBtonAction(Event event) {
    }

    public void contranaBtonAction(Event event) {
    }

    @Override
    public void initialize() {
        cargarComboBox();
    }

    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }
}
