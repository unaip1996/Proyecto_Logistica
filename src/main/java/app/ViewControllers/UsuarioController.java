package app.ViewControllers;

import Entities.Usuarios.Cliente;
import Entities.Usuarios.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {

    @FXML
    public TableView<Object> datos;
    @FXML
    public TableColumn<Usuario, String> nick;
    @FXML
    public TableColumn<Usuario, String> numberphone;
    @FXML
    public TableColumn<Usuario, String> mail;
    @FXML
    public TableColumn<Usuario, Integer> type_user;


    // add your data here from any source
    private ObservableList<Object> usuarios = FXCollections.observableArrayList(
            new Cliente("", "", "", ""));

    public void exit(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        EntityManager em = new EntityManager();
//        ObservableList<Object> resultset = FXCollections.observableArrayList(em.select(Usuario.class, ""));

        datos.setItems(usuarios);
    }

}
