package app.ViewControllers.Admin.Usuario;

import Entities.Usuarios.Cliente;
import app.EntityManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateController implements Initializable {

    private Stage stage;
    @FXML
    public Button back_button;
    @FXML
    public Button save_button;

    @FXML
    public TextField nick_input;
    @FXML
    public PasswordField password_input;
    @FXML
    public TextField telefono_input;
    @FXML
    public TextField mail_input;

    @FXML
    public Label error_label;

    private EntityManager em;

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
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                back(event);
            }
        });
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String nick = nick_input.getText();
                String password = password_input.getText();
                String mail = mail_input.getText();
                String telefono = telefono_input.getText();

                String[] fields = {nick, password, mail, telefono};

                if (validateFields(fields)) {
                    if (userExists()) {
                        error_label.setText("Nick o email existentes");
                    } else {
                        Cliente cliente = new Cliente(nick, password, mail, telefono);

                        em.save(cliente);

                        back(event);
                    }
                } else {
                    error_label.setText("Por favor, rellena los campos obligatorios");
                }
            }
        });

    }

    private boolean userExists() {
        boolean exists = false;

        String nick = nick_input.getText();
        String mail = mail_input.getText();

        String[] parameters = {nick, mail};
        Cliente cliente = (Cliente)em.selectOne(Cliente.class, "WHERE nick = ?0 OR mail = ?1", parameters);

        exists = cliente != null;

        return exists;
    }

    private boolean validateFields(String[] fields) {
        boolean valid = true;

        for (int i = 0; i < fields.length && valid; i++) {
            valid = !fields[i].isEmpty();
        }

        return valid;
    }

    private void back(ActionEvent event) {
        try {
            URL url = new File("src/main/resources/Admin/Usuario/List.fxml").toURI().toURL();
            Parent loader = FXMLLoader.load(url);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
