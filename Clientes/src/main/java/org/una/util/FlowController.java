/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.util;


import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.una.App;
import org.una.controllers.Controller;


public class FlowController  {

    private static FlowController INSTANCE = null;
    private static Stage mainStage;
	
    private static ResourceBundle idioma;
    private static HashMap<String, FXMLLoader> loaders = new HashMap<>();
	private static HashMap<String, Stage> stages= new HashMap<>();

    private FlowController() {
    }
    
    public Stage getStage(){
        return mainStage;
    }
    public void cambioPantalla(String pantalla){
        if(mainStage ==null){
            System.out.println("main stage is null");

        }else{

            if(getLoader(pantalla).getRoot() == null){
                System.out.println("get loader is null");
            }
            getScene().setRoot(getLoader(pantalla).getRoot());
        }
        

        
    }
    public void borrarPantalla( String nombre){
        loaders.remove(nombre);
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (FlowController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FlowController();
                }
            }
        }
    }

    public static FlowController getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void InitializeFlow(Stage stage, ResourceBundle idioma) {
        getInstance();
        FlowController.mainStage = stage;
        FlowController.idioma = idioma;
    }

    public FXMLLoader getLoader(String name) {
        FXMLLoader loader = loaders.get(name);
        if (loader == null) {
            synchronized (FlowController.class) {
                if (loader == null) {
                    try {
                        loader = new FXMLLoader(App.class.getResource("view/" + name + ".fxml"), FlowController.idioma);
                        loader.load();
                        loaders.put(name, loader);
                    } catch (Exception ex) {
                        loader = null;
                        java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Creando loader [" + name + "].", ex);
                    }
                }
            }
        }
        return loader;
    }
public Scene getScene(){
    return FlowController.mainStage.getScene();
}
    public void goMain() {
        try {
            FlowController.mainStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("view/principal.fxml"), FlowController.idioma)));
            FlowController.mainStage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Error inicializando la vista base.", ex);
        }
    }

    public void goView(String viewName) {
        goView(viewName, "Center", null);
    }

    public void goView(String viewName, String accion) {
        goView(viewName, "Center", accion);
    }

    public void goView(String viewName, String location, String accion) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setAccion(accion);
        controller.initialize();
        Stage stage = controller.getStage();
        if (stage == null) {
            stage = this.mainStage;
            controller.setStage(stage);
        }
        switch (location) {
            case "Center":
                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).getChildren().clear();
                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).getChildren().add(loader.getRoot());
                break;
            case "Top":
                break;
            case "Bottom":
                break;
            case "Right":
                break;
            case "Left":
                break;
            default:
                break;
        }
    }

    public void goViewInStage(String viewName, Stage stage) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setStage(stage);
        stage.getScene().setRoot(loader.getRoot());
    }

    public void goViewInWindow(String viewName) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.initialize();
        Stage stage = new Stage();
        stage.getIcons().add(new Image("unaplanilla2/resources/Agregar-48.png"));
        stage.setTitle("UNA PLANILLA");
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        controller.setStage(stage);
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

	
	public Stage getStage(String nombre){
		return stages.get(nombre);
	}
    public void goViewInWindowModal(String viewName, Boolean resizable) {
        FXMLLoader loader = getLoader(viewName);
        Stage stage = stages.get(viewName);
		if(stage==null){
			stage=new Stage();
			stage.setResizable(resizable);
			stage.initStyle(StageStyle.UNDECORATED);
			Parent root = loader.getRoot();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(mainStage);
			stage.centerOnScreen();
			stages.put(viewName, stage);
		}
       // stage.getIcons().add(new Image("unaplanilla2/resources/Agregar-48.png"));
        //stage.setTitle("UNA PLANILLA");
        
        
        stage.showAndWait();
		

    }

    public Controller getController(String viewName) {
        return getLoader(viewName).getController();
    }

    public static void setIdioma(ResourceBundle idioma) {
        FlowController.idioma = idioma;
    }
    
    public void initialize() {
        this.loaders.clear();
    }

    public void salir() {
        this.mainStage.close();
    }

}
