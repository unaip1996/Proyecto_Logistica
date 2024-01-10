package app.ViewControllers.Admin.Factura;

import Entities.Usuarios.Cliente;
import Entities.operaciones.Factura;
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

    public static Factura selectedItem;


    @FXML
    public TableColumn<Factura, String> fecha;

    @FXML
    public TableColumn<Factura, String> usuario;
    @FXML
    public TableColumn<Factura, String> cantidad;
    @FXML
    public TableColumn<Factura, String> montoTotal;
    @FXML
    public TableColumn<Factura, Boolean> actions;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.columns_width_auto = false;
        fecha.setCellValueFactory(new PropertyValueFactory<Factura, String>("fecha"));
        cantidad.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Factura, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Factura, String> param) {

                return new SimpleStringProperty(param.getValue().getCantidad() + " €");
            }
        });
        montoTotal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Factura, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Factura, String> param) {

                return new SimpleStringProperty(param.getValue().getMontoTotal() + " €");
            }
        });
        usuario.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Factura, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Factura, String> param) {
                String nick;

                Cliente cliente = param.getValue().getCliente();
                nick = cliente == null ? null : cliente.getNick();

                return new SimpleStringProperty(nick);
            }
        });

        this.create_screen_path = "src/main/resources/Admin/Factura/Create.fxml";
        this.edit_screen_path = "src/main/resources/Admin/Factura/Edit.fxml";
        this.classname = Factura.class;

        super.initialize(url, resourceBundle);
    }


    /**
     * Celda de edición de cada fila
     */
    public class EditCell extends TableCell<Factura, Boolean> {
        Button cellButton = new Button("Editar");


        public EditCell(){

            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    int selectedIndex = getTableRow().getIndex();
                    ListController.selectedItem = (Factura) datos.getItems().get(selectedIndex);

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
                new Callback<TableColumn<Factura, Boolean>, TableCell<Factura, Boolean>>() {

                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditCell();
                    }

                });
        actions.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Factura, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });
    }
}
