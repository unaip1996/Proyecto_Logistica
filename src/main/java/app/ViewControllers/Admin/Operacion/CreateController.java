package app.ViewControllers.Admin.Operacion;

import Entities.Usuarios.Cliente;
import Entities.operaciones.Direccion;
import Entities.operaciones.Factura;
import Util.EntityManager;
import Util.ViewUtils;
import app.ViewControllers.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreateController extends ViewController {
    @FXML
    public Button back_button;
    @FXML
    public Button save_button;
    @FXML
    public Label error_label;

    @FXML
    public AnchorPane center;

    @FXML
    public ComboBox<Direccion> direccion_input;

    @FXML
    public ComboBox<Factura> factura_input;

    @FXML
    public ComboBox<Cliente> cliente_input;

    @FXML
    public TextField peso_input;

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

        ViewUtils.setDecimalBehaviour(peso_input);

        List<Object> usuarios = em.select(Cliente.class, -1, " ORDER BY nick DESC");

        ObservableList comboboxItems = FXCollections.observableArrayList();

        if (!usuarios.isEmpty()) {
            comboboxItems.addAll(usuarios);
        }

        cliente_input.setItems(comboboxItems);
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                back(event);
            }
        });
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Direccion direccion = direccion_input.getValue();
                Factura factura = factura_input.getValue();
                Cliente cliente = cliente_input.getValue();
                String peso_empaquetado = peso_input.getText();

                String[] fields = {peso_empaquetado};

                save_button.setDisable(true);
//
//                if (ViewUtils.validateFields(fields) && cliente != null) {
//                    String[] parameters = new String[]{cantidad, montoTotal, String.valueOf(cliente.getId()), selectedDate.toString()};
//
//                    em.executeNativeQuery("INSERT INTO Operacion(numero, monto_total, usuario_id, fecha) VALUES(?1,?2,?3,?4)", parameters);
//
//                    back(event);
//                } else {
//                    error_label.setText("Por favor, rellena los campos obligatorios");
//                }



                save_button.setDisable(false);
            }
        });
    }

    private void back(ActionEvent event) {
        goToWindow("src/main/resources/Admin/Operacion/List.fxml", event);
    }
}