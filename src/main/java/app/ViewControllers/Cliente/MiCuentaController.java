package app.ViewControllers.Cliente;

import Util.EntityManager;
import app.ViewControllers.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

public class MiCuentaController extends ViewController {


    private EntityManager em;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        em = new EntityManager();

    }


}
