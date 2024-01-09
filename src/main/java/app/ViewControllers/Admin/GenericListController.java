package app.ViewControllers.Admin;

import app.EntityManager;
import app.ViewControllers.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static app.EntityManager.ROWS_PER_PAGE;

public abstract class GenericListController extends ViewController {


    //Elementos FXML
    @FXML
    public AnchorPane center;
    @FXML
    public TableView datos;
    @FXML
    public Button newItem;
    @FXML
    public Button deleteItems;

    @FXML
    public Pagination pagination;
    @FXML
    public TableColumn actions;

    //Registro seleccionado
    public static Object selectedItem;

    //Elementos de la tabla
    protected ObservableList items;

    //Pantalla de creacion
    protected String create_screen_path;

    //Pantalla de edición
    protected String edit_screen_path;

    //Literal de clase del objeto (Ej.: Usuario.class)
    protected Class<?> classname;

    //Index de paginación
    public static int paginationIndex = -1;

    protected boolean columns_width_auto = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.em = new EntityManager();

        //Listener de botón de crear
        newItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow(create_screen_path, event);
            }
        });


        //Listener de botón de crear
        deleteItems.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableView.TableViewSelectionModel selectionModel = datos.getSelectionModel();
                ObservableList selectedItems = selectionModel.getSelectedItems();

                Alert alert;

                if (!selectedItems.isEmpty()) {
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Eliminación de elementos");
                    alert.setHeaderText("Se  eliminarán los elementos seleccionados, ¿Estás seguro?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        //El usuario está seguro y se procede a eliminar
                        em.removeNative(classname, selectedItems);

                        paintData(pagination.getCurrentPageIndex());
                    } else {

                    }
                } else {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Eliminación de elementos");
                    alert.setHeaderText("No has seleccionado ningún usuario");
                    alert.show();
                }
            }
        });

        actions.setSortable(false);

        if (columns_width_auto) {
            datos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        }
        datos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        initPagination();
    }

    /**
     * Pintar datos según la paginación
     *
     * @param index Posición de la paginación
     */
    private void paintData(int index) {
        items = FXCollections.observableArrayList();
        List<Object> itemList = em.select(classname, index, "");

        if (!itemList.isEmpty()) {
            items.addAll(itemList);
        }

        datos.setItems(items);

        paintEditButtons();

    }

    /**
     * Pintar botones de editar
     * Lo hemos declarado abstracto ya que depende de un callback y no era posible generalizarlo
     */
    protected abstract void paintEditButtons();

    /**
     * Inicializar propiedades de la paginación
     */
    private void initPagination(){
        int count = em.getTableCount(classname);

        int numOfPages = 1;
        if (count % ROWS_PER_PAGE == 0) {
            numOfPages = count / ROWS_PER_PAGE;
        } {
            numOfPages = count / ROWS_PER_PAGE + 1;
        }
        if (paginationIndex != -1) {
            pagination.setCurrentPageIndex(paginationIndex);
        }
        pagination.setPageCount(numOfPages);
        pagination.setPageFactory(this::paintPage);
    }

    /**
     * Pinta la tabla según la paginación
     *
     * @param index Posición de paginación
     * @return VBox
     */
    protected VBox paintPage(int index) {

        paginationIndex = index;
        paintData(index);

        return new VBox();
    }
}
