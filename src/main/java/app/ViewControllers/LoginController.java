package app.ViewControllers;

import Entities.Usuarios.Cliente;
import Util.EntityManager;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    private Stage stage;

    @FXML
    public Button button_login;

    @FXML
    public TextField nickname;

    @FXML
    public PasswordField password;

    private EntityManager em;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        em = new EntityManager();
        button_login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {


                String nick = nickname.getText();
                String pass = password.getText();

                String[] fields = {nick, pass };



                    if (login()){
                        button_login.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                goToWindow("src/main/resources/Usuario/Buscar.fxml", event);
                            }
                        });
                    }
                    else if (nickname.getText().isEmpty() && password.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese sus datos de usuario ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o Contrasena incorrectos");
                    }

            }
        });

    }

    private boolean login() {
        boolean exists = false;

        String nick = nickname.getText();
        String pass = password.getText();

        String[] parameters = {nick, pass};
        Cliente cliente;
        cliente = (Cliente) em.selectOne(Cliente.class, "WHERE nick = ?1 AND password = ?2", parameters);

        exists = cliente != null;

        return exists;

    }

    public void goToWindow(String path, Event event) {
        try {
            URL url = new File(path).toURI().toURL();
            Parent loader = FXMLLoader.load(url);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
