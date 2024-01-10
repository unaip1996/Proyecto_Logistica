package app.ViewControllers.Cliente;


import app.DBUtils;
import app.EntityManager;
import app.ViewControllers.ViewController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuscarController extends ViewController {


    @FXML
    public Button buscarpaquete;

    @FXML
    public Button button_logout;

    @FXML
    public Button button_buscar;

    @FXML
    public Button button_cotizar;

    @FXML
    public Button button_cuenta;

    @FXML
    public Button button_facturas;

    @FXML
    public TextField idpaquete;

    private EntityManager em;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       em = new EntityManager();


       button_logout.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               goToWindow("src/main/resources/Usuario/Log_in.fxml", event);
           }

       });

       button_cotizar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               goToWindow("src/main/resources/Usuario/Cotizar.fxml", event);
           }
       });

        button_facturas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Usuario/Factura.fxml", event);
            }
        });

        button_cuenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Usuario/MiCuenta.fxml", event);
            }
        });
    }

}


