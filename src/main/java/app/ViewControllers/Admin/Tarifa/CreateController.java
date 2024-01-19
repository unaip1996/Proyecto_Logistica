package app.ViewControllers.Admin.Tarifa;

import Util.EntityManager;
import Util.ViewUtils;
import app.ViewControllers.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public TextField altura_input;

    @FXML
    public TextField anchura_input;

    @FXML
    public TextField diagonal_input;

    @FXML
    public TextField nombre_input;

    @FXML
    public TextField peso_input;

    @FXML
    public TextField precio_input;

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

        ViewUtils.setDecimalBehaviour(precio_input);
        ViewUtils.setDecimalBehaviour(altura_input);
        ViewUtils.setDecimalBehaviour(anchura_input);
        ViewUtils.setDecimalBehaviour(diagonal_input);
        ViewUtils.setDecimalBehaviour(peso_input);

        //Control para que solo puedan introducirse decimales

        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                back(event);
            }
        });
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String peso = peso_input.getText();
                String anchura = anchura_input.getText();
                String altura = altura_input.getText();
                String diagonal = diagonal_input.getText();
                String precio = precio_input.getText();
                String nombre = nombre_input.getText();

                String[] fields = {peso, anchura, altura, diagonal, precio, nombre};

                save_button.setDisable(true);

                if (ViewUtils.validateStringFields(fields)) {
                    String[] parameters = fields;

                    em.executeNativeQuery("INSERT INTO Tarifa(peso, anchura, altura, diagonal, precio, nombre) VALUES(?1,?2,?3,?4,?5,?6)", parameters);

                    back(event);
                } else {
                    error_label.setText("Por favor, rellena los campos obligatorios");
                }



                save_button.setDisable(false);
            }
        });
    }

    private void back(ActionEvent event) {
        goToWindow("src/main/resources/Admin/Tarifa/List.fxml", event);
    }
}