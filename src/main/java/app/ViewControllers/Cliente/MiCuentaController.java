package app.ViewControllers.Cliente;

import Util.EntityManager;
import app.ViewControllers.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MiCuentaController extends ViewController {

    @FXML
    public Button button_buscar;

    @FXML
    public Button button_cotizar;

    @FXML
    public Button button_cuenta;

    @FXML
    public Button button_facturas;


    private EntityManager em;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        em = new EntityManager();


        button_buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Usuario/Buscar.fxml", event);
            }
        });

        button_facturas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Usuario/Factura.fxml", event);
            }
        });

        button_cotizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Usuario/Cotizar.fxml", event);
            }
        });
    }


}
