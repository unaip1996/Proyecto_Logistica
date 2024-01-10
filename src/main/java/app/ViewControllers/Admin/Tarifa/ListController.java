package app.ViewControllers.Admin.Tarifa;

import Entities.operaciones.Tarifa;
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

    public static Tarifa selectedItem;


    @FXML
    public TableColumn<Tarifa, String> dimensiones;

    @FXML
    public TableColumn<Tarifa, String> nombre;

    @FXML
    public TableColumn<Tarifa, String> peso;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.columns_width_auto=false;

        nombre.setCellValueFactory(new PropertyValueFactory<Tarifa, String>("nombre"));
        dimensiones.setCellValueFactory(new PropertyValueFactory<Tarifa, String>("dimensiones"));
        peso.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Tarifa, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Tarifa, String> param) {
                return new SimpleStringProperty(param.getValue().getPesoKg() + " Kg");
            }
        });

        this.create_screen_path = "src/main/resources/Admin/Tarifa/Create.fxml";
        this.edit_screen_path = "src/main/resources/Admin/Tarifa/Edit.fxml";
        this.classname = Tarifa.class;

        super.initialize(url, resourceBundle);
    }


    /**
     * Celda de edición de cada fila
     */
    public class EditCell extends TableCell<Tarifa, Boolean> {
        Button cellButton = new Button("Editar");


        public EditCell(){

            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    int selectedIndex = getTableRow().getIndex();
                    ListController.selectedItem = (Tarifa) datos.getItems().get(selectedIndex);

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
                new Callback<TableColumn<Tarifa, Boolean>, TableCell<Tarifa, Boolean>>() {

                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditCell();
                    }

                });
        actions.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Tarifa, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });
    }
}
