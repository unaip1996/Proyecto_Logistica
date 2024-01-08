package app.ViewControllers.Admin.Usuario;

import Entities.Usuarios.Usuario;
import app.ViewControllers.Admin.GenericListController;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController extends GenericListController {

    public static Usuario selectedItem;


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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nick.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nick"));
        numberphone.setCellValueFactory(new PropertyValueFactory<Usuario, String>("numberphone"));
        mail.setCellValueFactory(new PropertyValueFactory<Usuario, String>("mail"));

        type_user.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Usuario, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Usuario, String> p) {
                        int type = p.getValue().getType_user();
                        return new ReadOnlyStringWrapper(type == Usuario.ADMINTYPE ? "Administrador" : "Cliente");
                    }
                }
        );

        this.create_screen_path = "src/main/resources/Admin/Usuario/create.fxml";
        this.edit_screen_path = "src/main/resources/Admin/Usuario/edit.fxml";
        this.classname = Usuario.class;

        super.initialize(url, resourceBundle);
    }



    public class EditCell extends TableCell<Usuario, Boolean> {
        Button cellButton = new Button("Editar");


        public EditCell(){

            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    int selectedIndex = getTableRow().getIndex();
                    ListController.selectedItem = (Usuario) datos.getItems().get(selectedIndex);

                    goToWindow(edit_screen_path, t);
                }
            });
        }

        //Display button if the row is not empty
        @Override
        public void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }

    protected void paintEditButtons() {
        class EditCell extends TableCell<Object, Boolean> {
            Button cellButton = new Button("Editar");


            public EditCell(){

                cellButton.setOnAction(new EventHandler<ActionEvent>(){

                    @Override
                    public void handle(ActionEvent t) {
                        int selectedIndex = getTableRow().getIndex();
                        ListController.selectedItem = (Usuario) datos.getItems().get(selectedIndex);

                        goToWindow(edit_screen_path, t);
                    }
                });
            }

            //Display button if the row is not empty
            @Override
            public void updateItem(Boolean t, boolean empty) {
                super.updateItem(t, empty);
                if(!empty){
                    setGraphic(cellButton);
                }
            }
        }

        actions.setCellFactory(
                new Callback<TableColumn<Usuario, Boolean>, TableCell<Usuario, Boolean>>() {

                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditCell();
                    }

                });
        actions.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Usuario, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });
    }


}
