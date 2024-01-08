package app.ViewControllers.Admin.Usuario;

import Entities.Usuarios.Usuario;
import app.EntityManager;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public AnchorPane center;

    @FXML
    public TableView<Usuario> datos;
    @FXML
    public TableColumn<Usuario, String> nick;
    @FXML
    public TableColumn<Usuario, String> numberphone;
    @FXML
    public TableColumn<Usuario, String> mail;
    
    @FXML
    public TableColumn<Usuario, String> type_user;
    @FXML
    public TableColumn<Usuario, Boolean> actions;
    @FXML
    public Button newUsuario;


    // add your data here from any source
    private ObservableList<Usuario> usuarios;

    public void exit(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usuarios = FXCollections.observableArrayList();

        nick.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nick"));
        numberphone.setCellValueFactory(new PropertyValueFactory<Usuario, String>("numberphone"));
        mail.setCellValueFactory(new PropertyValueFactory<Usuario, String>("mail"));

        type_user.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Usuario, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Usuario, String> p) {
                        int type = p.getValue().getType_user();
                        return new ReadOnlyStringWrapper(type == 1 ? "Administrador" : "Cliente");
                    }
                }
        );

        actions.setSortable(false);
        actions.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Usuario, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Usuario, Boolean> p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });

        actions.setCellFactory(
                new Callback<TableColumn<Usuario, Boolean>, TableCell<Usuario, Boolean>>() {

                    @Override
                    public TableCell<Usuario, Boolean> call(TableColumn<Usuario, Boolean> p) {
                        return new EditCell();
                    }

                });

        newUsuario.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Node node;
                    URL url = new File("src/main/resources/Admin/Usuario/create.fxml").toURI().toURL();
                    Parent loader = FXMLLoader.load(url);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(loader);
                    stage.setScene(scene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        datos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        EntityManager em = new EntityManager();

        List<Object> userList = em.select(Usuario.class, "");

        for(Object user : userList) {
            usuarios.add((Usuario) user);
        }

        datos.setItems(usuarios);
    }

    private class EditCell extends TableCell<Usuario, Boolean> {
        Button cellButton = new Button("Editar");
//        Button cellButton = new Button("Editar").setGraphic(FontAwesome.Glyph.PENCIL);


        EditCell(){

            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    int selectedIndex = getTableRow().getIndex();
                    Usuario usuario = (Usuario) datos.getItems().get(selectedIndex);

                    System.out.println(usuario.getNick());
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }
}
