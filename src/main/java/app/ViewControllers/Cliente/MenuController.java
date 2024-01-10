package app.ViewControllers.Cliente;

import app.ViewControllers.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends ViewController {



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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


       button_logout.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               goToWindow("src/main/resources/Log_in.fxml", event);
           }

       });

       button_cotizar.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               goToWindow("src/main/resources/Cliente/Usuario/Cotizar.fxml", event);
           }
       });

        button_facturas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Cliente/Usuario/Factura.fxml", event);
            }
        });

        button_cuenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Cliente/Usuario/MiCuenta.fxml", event);
            }
        });
    }

}


