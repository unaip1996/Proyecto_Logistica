package app.ViewControllers.Admin.Usuario;

import Entities.Usuarios.Usuario;
import app.EntityManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public CheckBox es_admin;

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
                String type_user = es_admin.isSelected() ? "1" : "0";

                String[] fields = {nick, password, mail, telefono};

                save_button.setDisable(true);

                if (validateFields(fields)) {
                    if (userExists()) {
                        error_label.setText("Nick o email existentes");
                    } else {
//                        Usuario usuario = new Usuario(nick, password, mail, telefono);
//
//                        em.save(usuario);

                        em.executeNativeQuery("INSERT INTO Usuario(nick, password, mail, telefono, tipo) VALUES(?1,?2,?3,?4,?5)", new String[]{nick, password, mail, telefono, type_user});

                        back(event);
                    }
                } else {
                    error_label.setText("Por favor, rellena los campos obligatorios");
                }



                save_button.setDisable(false);
            }
        });
    }

    private boolean userExists() {
        boolean exists = false;

        String nick = nick_input.getText();
        String mail = mail_input.getText();

        String[] parameters = {nick, mail};
        Usuario usuario = (Usuario)em.selectOne(Usuario.class, "WHERE nick = ?1 OR mail = ?2", parameters);

        exists = usuario != null;

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