package app.ViewControllers.Admin.Factura;

import Entities.Usuarios.Cliente;
import Util.EntityManager;
import Util.ViewUtils;
import app.ViewControllers.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class EditController extends ViewController {
    @FXML
    public Button back_button;
    @FXML
    public Button save_button;
    @FXML
    public Label error_label;

    @FXML
    public TextField cantidad_input;

    @FXML
    public DatePicker fecha;

    @FXML
    public TextField montoTotal_input;

    @FXML
    public ComboBox<Cliente> usuario;

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

        ViewUtils.setDecimalBehaviour(cantidad_input);
        ViewUtils.setDecimalBehaviour(montoTotal_input);

        List<Object> usuarios = em.select(Cliente.class, -1, " ORDER BY nick DESC", new String[0]);

        ObservableList comboboxItems = FXCollections.observableArrayList();

        if (!usuarios.isEmpty()) {
            comboboxItems.addAll(usuarios);
        }

        usuario.setItems(comboboxItems);
        usuario.setValue(ListController.selectedItem.getCliente());

        fecha.setValue(ViewUtils.dateToLocalDate(ListController.selectedItem.getFecha()));

        cantidad_input.setText(ListController.selectedItem.getCantidad());
        montoTotal_input.setText(String.valueOf(ListController.selectedItem.getMontoTotal()));
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                back(event);
            }
        });
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String cantidad = cantidad_input.getText();
                String montoTotal = montoTotal_input.getText();
                Cliente cliente = usuario.getValue();
                LocalDate selectedDate = fecha.getValue();
                String id = String.valueOf(ListController.selectedItem.getId());

                String[] fields = {cantidad, montoTotal};

                save_button.setDisable(true);

                if (ViewUtils.validateStringFields(fields) && cliente != null) {
                    String[] parameters = new String[]{cantidad, montoTotal, String.valueOf(cliente.getId()), selectedDate.toString(), id};

                    em.executeNativeQuery("UPDATE Factura SET numero=?1, monto_total=?2, usuario_id=?3, fecha=?4 WHERE id = ?5", parameters);

                    back(event);
                } else {
                    error_label.setText("Por favor, rellena los campos obligatorios");
                }



                save_button.setDisable(false);
            }
        });
    }

    private void back(ActionEvent event) {
        goToWindow("src/main/resources/Admin/Factura/List.fxml", event);
    }
}
