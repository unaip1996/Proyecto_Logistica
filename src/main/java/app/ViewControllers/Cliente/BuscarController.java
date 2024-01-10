package app.ViewControllers.Cliente;

import Util.EntityManager;
import app.ViewControllers.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BuscarController extends ViewController {


    @FXML
    public Button buscarpaquete;

    @FXML
    public TextField idpaquete;

    private EntityManager em;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        em = new EntityManager();

    }

}


