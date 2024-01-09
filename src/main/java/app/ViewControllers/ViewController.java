package app.ViewControllers;

import Util.EntityManager;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class ViewController implements Initializable {

    //Ventana
    protected Stage stage;

    //Gestor de BD
    protected EntityManager em;
    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {//Método al que se llama al abrir la ventana

    }

    /**
     * Este método puede ser usado para saltar de una ventana a otra en el mismo BorderPane
     *
     * @param path Ubicacion del fichero del FXML destino
     * @param event Evento FXML
     */
    public void goToWindow(String path, Event event) {
        try {
            URL url = new File(path).toURI().toURL();
            Parent loader = FXMLLoader.load(url);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void exit(){

    }
}
