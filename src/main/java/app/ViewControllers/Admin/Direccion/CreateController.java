package app.ViewControllers.Admin.Direccion;

import Util.ViewUtils;
import app.EntityManager;
import app.ViewControllers.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateController extends ViewController {
    @FXML
    public Button back_button;
    @FXML
    public Button save_button;
    @FXML
    public Label error_label;

    @FXML
    public TextField calle_input;

    @FXML
    public TextField ciudad_input;

    @FXML
    public Spinner<Integer> cp_input;

    @FXML
    public TextField puerta_input;

    @FXML
    public TextField esc_input;

    @FXML
    public Spinner<Integer> numero_input;

    @FXML
    public TextField pais_input;

    @FXML
    public Spinner<Integer> piso_input;

    @FXML
    public TextField provincia_input;

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
    public void initialize(URL location, ResourceBundle resources) {

        em = new EntityManager();

        ViewUtils.initializeSpinner(numero_input, 50);
        ViewUtils.initializeSpinner(piso_input, 50);
        ViewUtils.initializeSpinner(cp_input, 50000);
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                back(event);
            }
        });
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String pais = pais_input.getText();
                String provincia = provincia_input.getText();
                String ciudad = ciudad_input.getText();
                String calle = calle_input.getText();
                int numero = numero_input.getValue();
                String esc = esc_input.getText();
                String puerta = puerta_input.getText();
                int piso = piso_input.getValue();
                int cp = cp_input.getValue();

                String[] fields = {pais, provincia, ciudad, calle, String.valueOf(numero), String.valueOf(cp)};

                save_button.setDisable(true);

                if (ViewUtils.validateFields(fields)) {
                    String[] parameters = new String[]{pais, provincia, ciudad, calle, String.valueOf(numero), String.valueOf(cp), String.valueOf(piso), puerta, esc};

                    em.executeNativeQuery("INSERT INTO Direccion(pais, provincia, ciudad, calle, numero, codigo_postal, piso, puerta, esc) VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9)", parameters);

                    back(event);
                } else {
                    error_label.setText("Por favor, rellena los campos obligatorios");
                }



                save_button.setDisable(false);
            }
        });
    }

    private void back(ActionEvent event) {
        goToWindow("src/main/resources/Admin/Direccion/List.fxml", event);
    }
}