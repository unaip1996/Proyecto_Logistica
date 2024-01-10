package app.ViewControllers.Admin.Puerto;

import Entities.operaciones.Puerto;
import app.ViewControllers.Admin.GenericListController;
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

    public static Puerto selectedItem;



    @FXML
    public TableColumn<Puerto, String> nombre;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.columns_width_auto=false;

        nombre.setCellValueFactory(new PropertyValueFactory<Puerto, String>("nombre"));

        this.create_screen_path = "src/main/resources/Admin/Puerto/Create.fxml";
        this.edit_screen_path = "src/main/resources/Admin/Puerto/Edit.fxml";
        this.classname = Puerto.class;

        super.initialize(url, resourceBundle);
    }


    /**
     * Celda de edición de cada fila
     */
    public class EditCell extends TableCell<Puerto, Boolean> {
        Button cellButton = new Button("Editar");


        public EditCell(){

            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    int selectedIndex = getTableRow().getIndex();
                    ListController.selectedItem = (Puerto) datos.getItems().get(selectedIndex);

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
                new Callback<TableColumn<Puerto, Boolean>, TableCell<Puerto, Boolean>>() {

                    @Override
                    public TableCell call(TableColumn p) {
                        return new EditCell();
                    }

                });
        actions.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Puerto, Boolean>,
                        ObservableValue<Boolean>>() {

                    @Override
                    public ObservableValue<Boolean> call(TableColumn.CellDataFeatures p) {
                        return new SimpleBooleanProperty(p.getValue() != null);
                    }
                });
    }
}
