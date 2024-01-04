package app.ViewControllers;

import app.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class BuscarController implements Initializable {

    @FXML
    private Button cerrar; //cerrar sesión
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "Login.fxml", "Iniciar Sesión",null);
            }
        });

    }

}
