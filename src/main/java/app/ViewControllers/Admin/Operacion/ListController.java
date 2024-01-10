package app.ViewControllers.Admin.Operacion;

import Entities.operaciones.Direccion;
import Entities.operaciones.Operacion;
import Entities.operaciones.Tarifa;
import app.ViewControllers.Admin.GenericListController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController extends GenericListController {

    public static Operacion selectedItem;
    

    @FXML
    public TableColumn<Operacion, String> cliente;

    @FXML
    public TableColumn<Operacion, String> direccion;

    @FXML
    public TableColumn<Operacion, String> entregado;

    @FXML
    public TableColumn<Operacion, String> tarifa;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.columns_width_auto=false;

        cliente.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Operacion, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Operacion, String> param) {
                Direccion direccion = param.getValue().getDireccion();
                String nick = direccion.getCliente() != null ? direccion.getCliente().getNick() : null;
                return new SimpleStringProperty(nick);
            }
        });
        tarifa.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Operacion, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Operacion, String> param) {
                Tarifa tarifa = param.getValue().getTarifa();
                return new SimpleStringProperty(tarifa.getNombre());
            }
        });
        direccion.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Operacion, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Operacion, String> param) {
                Direccion direccion = param.getValue().getDireccion();
                return new SimpleStringProperty(direccion.toString());
            }
        });

        this.create_screen_path = "src/main/resources/Admin/Operacion/Create.fxml";
        this.edit_screen_path = "src/main/resources/Admin/Operacion/Edit.fxml";
        this.classname = Operacion.class;

        super.initialize(url, resourceBundle);
    }


    /**
     * Celda de edición de cada fila
     */
    public class ActionsCell extends TableCell<Operacion, Boolean> {
        Button editButton = new Button("Editar");
//        Button statusButton = new Button("Ver estado");


        public ActionsCell(){

            editButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
//                    int selectedIndex = getTableRow().getIndex();
//                    ListController.selectedItem = (Operacion) datos.getItems().get(selectedIndex);
//
//                    goToWindow(edit_screen_path, t);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Aviso para el profesor");
                    alert.setHeaderText("La edición no está disponible aun para esta pantalla");
                    alert.show();
                }
            });
        }

        //Display button if the row is not empty
        @Override
        public void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(editButton);
            }
        }
    }

    protected void paintEditButtons() {
        actions.setCellFactory(
                new Callback<TableColumn<Operacion, Boolean>, TableCell<Operacion, Boolean>>() {

                    @Override
                    public TableCell call(TableColumn p) {
                        return new ActionsCell();
                    }

                });
        actions.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Operacion, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });
    }
}
