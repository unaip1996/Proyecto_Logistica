package app.ViewControllers.Admin.Usuario;

import Entities.Usuarios.Cliente;
import app.EntityManager;
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
    public TableView<Cliente> datos;
    @FXML
    public TableColumn<Cliente, String> nick;
    @FXML
    public TableColumn<Cliente, String> numberphone;
    @FXML
    public TableColumn<Cliente, String> mail;
    @FXML
    public TableColumn<Cliente, Boolean> actions;
    @FXML
    public Button newCliente;


    // add your data here from any source
    private ObservableList<Cliente> usuarios;

    public void exit(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usuarios = FXCollections.observableArrayList();

        nick.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nick"));
        numberphone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("numberphone"));
        mail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("mail"));

        actions.setSortable(false);
        actions.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Cliente, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Cliente, Boolean> p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });

        actions.setCellFactory(
                new Callback<TableColumn<Cliente, Boolean>, TableCell<Cliente, Boolean>>() {

                    @Override
                    public TableCell<Cliente, Boolean> call(TableColumn<Cliente, Boolean> p) {
                        return new EditCell();
                    }

                });

        newCliente.setOnAction(new EventHandler<ActionEvent>() {
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

        List<Object> userList = em.select(Cliente.class, "");

        for(Object user : userList) {
            usuarios.add((Cliente) user);
        }

        datos.setItems(usuarios);
    }

    private class EditCell extends TableCell<Cliente, Boolean> {
        Button cellButton = new Button("Editar");
//        Button cellButton = new Button("Editar").setGraphic(FontAwesome.Glyph.PENCIL);


        EditCell(){

            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    int selectedIndex = getTableRow().getIndex();
                    Cliente cliente = (Cliente) datos.getItems().get(selectedIndex);

                    System.out.println(cliente.getNick());
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
