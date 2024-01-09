package app.ViewControllers;

import Entities.Usuarios.Cliente;
import Util.EntityManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

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


                    if (login()) {
                        JOptionPane.showMessageDialog(null, "Inició Sesión");
                    } else if (nickname.getText().isEmpty() && password.getText().isEmpty()) {
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



}
