package app.ViewControllers.Admin.Puerto;

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

public class EditController extends ViewController {
    @FXML
    public Button back_button;
    @FXML
    public Button save_button;
    @FXML
    public Label error_label;

    @FXML
    public TextField nombre_input;

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

        System.out.println(ListController.selectedItem.getNombre());
        nombre_input.setText(ListController.selectedItem.getNombre());


        em = new EntityManager();
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                back(event);
            }
        });
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String nombre = nombre_input.getText();
                String id = String.valueOf(ListController.selectedItem.getId());

                String[] fields = {nombre, id};

                save_button.setDisable(true);

                if (ViewUtils.validateStringFields(fields)) {
                    String[] parameters = fields;

                    em.executeNativeQuery("UPDATE Puerto SET nombre=?1 WHERE id = ?2", parameters);

                    back(event);
                } else {
                    error_label.setText("Por favor, rellena los campos obligatorios");
                }



                save_button.setDisable(false);
            }
        });
    }

    private void back(ActionEvent event) {
        goToWindow("src/main/resources/Admin/Puerto/List.fxml", event);
    }
}
