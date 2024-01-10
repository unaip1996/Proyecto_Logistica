package app.ViewControllers.Admin.Direccion;

import Entities.Usuarios.Cliente;
import Entities.operaciones.Direccion;
import app.ViewControllers.Admin.GenericListController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
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

    public static Direccion selectedItem;


    @FXML
    public TableColumn<Direccion, String> text;

    @FXML
    public TableColumn<Direccion, String> usuario;
    @FXML
    public TableColumn<Direccion, Boolean> actions;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.columns_width_auto = false;
        text.setCellValueFactory(new PropertyValueFactory<Direccion, String>("text"));
        usuario.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Direccion, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Direccion, String> param) {
                String nick;

                Cliente cliente = param.getValue().getCliente();
                nick = cliente == null ? null : cliente.getNick();

                return new SimpleStringProperty(nick);
            }
        });

        this.create_screen_path = "src/main/resources/Admin/Direccion/Create.fxml";
        this.edit_screen_path = "src/main/resources/Admin/Direccion/Edit.fxml";
        this.classname = Direccion.class;

        super.initialize(url, resourceBundle);
    }


    /**
     * Celda de edición de cada fila
     */
    public class EditCell extends TableCell<Direccion, Boolean> {
        Button cellButton = new Button("Editar");


        public EditCell(){

            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    int selectedIndex = getTableRow().getIndex();
                    ListController.selectedItem = (Direccion) datos.getItems().get(selectedIndex);

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
        actions.setCellFactory(
                new Callback<TableColumn<Direccion, Boolean>, TableCell<Direccion, Boolean>>() {

                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditCell();
                    }

                });
        actions.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Direccion, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });
    }
}
