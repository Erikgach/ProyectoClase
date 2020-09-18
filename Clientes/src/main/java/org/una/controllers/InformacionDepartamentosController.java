package org.una.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.una.App;
import org.una.dto.DepartamentoDTO;
import org.una.services.DepartamentoServiceImplementation;
import org.una.services.IDepartamentoService;
import org.una.util.AppContext;
import org.una.util.FlowController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InformacionDepartamentosController extends Controller {


    public AnchorPane acp_infodepartamentos;
    public Label lbl_titulo;
    public TextField txt_consultar;
    public Button btn_buscar;
    public TableView<DepartamentoDTO> tbl_infodepartamentos;
    public TableColumn<DepartamentoDTO, String> col_id;
    public TableColumn<DepartamentoDTO, String> col_nombre;
    public TableColumn<DepartamentoDTO, String> col_estado;
    public TableColumn<DepartamentoDTO, String> col_operaciones;
    public Button btn_cerrar;
    public Button btn_agregar;
    public ComboBox combo_categorias;
    public Button bton_recargar;
    public Button atrasbutton;
    IDepartamentoService departamentoService = new DepartamentoServiceImplementation();
    public void btn_agregarAction(ActionEvent actionEvent) {
    }

    public void btn_buscarAction(ActionEvent actionEvent) {
      if(!combo_categorias.getSelectionModel().isEmpty()){
          String seleccion = (String) combo_categorias.getValue();
          String palabraBuscada = txt_consultar.getText();
          List<DepartamentoDTO> result = new ArrayList<>();

          if(seleccion.equals("ID")){
              DepartamentoDTO resultado = departamentoService.findById(Long.parseLong(palabraBuscada));
              result.add(resultado);
          }else if(seleccion.equals("Nombre")){
              result = departamentoService.finByNombre(palabraBuscada);
          }else if(seleccion.equals("Estado")){
              if(palabraBuscada.equals("1")){
                  result = departamentoService.findByEstado(true);
              }else if(result.equals("0")){
                  result = departamentoService.findByEstado(false);
              }
          }
          if(!result.isEmpty()){

              tbl_infodepartamentos.getItems().clear();
              tbl_infodepartamentos.setItems(parseListToObservable(result));
          }
      }


    }

    public void btn_borrarAction(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(!tbl_infodepartamentos.getSelectionModel().isEmpty()){
            int rowSelected = tbl_infodepartamentos.getSelectionModel().getSelectedIndex();
            Long idEliminar = tbl_infodepartamentos.getItems().get(rowSelected).getId();
            int code = departamentoService.deleteById(idEliminar);
            if(!(code == 200)) System.out.println("Hubo errores durante la eliminacion");
            else {
                tbl_infodepartamentos.getItems().clear();
                tbl_infodepartamentos.setItems(parseListToObservable(departamentoService.getDepartamentos()));
            }





        }
    }

    public void btn_cerrarAction(ActionEvent actionEvent) {
    }

    public ObservableList<DepartamentoDTO> parseListToObservable(List<DepartamentoDTO> lista) {

        ObservableList<DepartamentoDTO> departamentos = FXCollections.observableArrayList();

        if ((lista != null)) {

            System.out.println("CARGANDO DEPARTAMENTOS");
            for (DepartamentoDTO departamentoDTO : lista) {
                departamentoDTO.setOperaciones("   [ver]  [modificar]   ");
                departamentos.add(departamentoDTO);
            }

        }

        return departamentos;
    }




    public void cargarDepartamentos(){

            tbl_infodepartamentos.setItems(parseListToObservable(departamentoService.cargarDepartamentos()));
            col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
            col_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            col_operaciones.setCellValueFactory(new PropertyValueFactory<>("operaciones"));

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



    @Override
    public void initialize() {
        cargarDepartamentos();
        cargarComboBox();


    }

    void crearVentanaDetalles(){
        Parent root;
        try {
            root = FXMLLoader.load(App.class.getResource("view/DetallerDepartamentos.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Detalles departamento");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tbl_cliked(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            int rowSelected = tbl_infodepartamentos.getSelectionModel().getSelectedIndex();
            if(tbl_infodepartamentos.getSelectionModel().isSelected(rowSelected,col_operaciones)){
                Long idDepartamento = tbl_infodepartamentos.getItems().get(rowSelected).getId();

                AppContext.getInstance().set("departamentoSeleccionado", departamentoService.findById(idDepartamento));
                AppContext.getInstance().set("departamentoService", departamentoService);
               crearVentanaDetalles();


            }


        }

    }

    public void recargarButon(ActionEvent actionEvent) {
        tbl_infodepartamentos.getItems().clear();
        departamentoService.cargarDepartamentos();
        tbl_infodepartamentos.setItems(parseListToObservable(departamentoService.getDepartamentos()));

    }
    public void retroceder(ActionEvent actionEvent) {
        FlowController.getInstance().cambioPantalla("principal");
    }
}
