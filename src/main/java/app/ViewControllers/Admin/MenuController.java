package app.ViewControllers.Admin;

import app.ViewControllers.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends ViewController {
    

    @FXML
    public Button button_aeropuertos;

    @FXML
    public Button button_direcciones;

    @FXML
    public Button button_facturas;

    @FXML
    public Button button_logout;

    @FXML
    public Button button_operaciones;

    @FXML
    public Button button_puertos;

    @FXML
    public Button button_tarifas;

    @FXML
    public Button button_usuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


       button_logout.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               goToWindow("src/main/resources/Log_in.fxml", event);
           }

       });
        button_operaciones.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Admin/Operacion/List.fxml", event);
            }

        });
        button_facturas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Admin/Factura/List.fxml", event);
            }

        });
        button_usuarios.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Admin/Usuario/List.fxml", event);
            }

        });
        button_direcciones.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Admin/Direccion/List.fxml", event);
            }

        });
        button_aeropuertos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Admin/Aeropuerto/List.fxml", event);
            }

        });
        button_puertos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Admin/Puerto/List.fxml", event);
            }

        });
        button_tarifas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Admin/Tarifa/List.fxml", event);
            }

        });
    }

}


