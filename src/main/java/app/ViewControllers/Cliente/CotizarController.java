package app.ViewControllers.Cliente;

import Entities.operaciones.Tarifa;
import Util.EntityManager;
import app.ViewControllers.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CotizarController extends ViewController implements Initializable {

    @FXML
    public Button button_buy;

    @FXML
    public TableColumn<Tarifa, Integer> id;
    @FXML
    public TableColumn<Tarifa, String> nombre;
    @FXML
    public TableColumn<Tarifa, Double> peso;
    @FXML
    public TableColumn<Tarifa, Double> precio;
    @FXML
    public TableColumn<Tarifa, String> size;
    @FXML
    public TableView<Tarifa> table_cotizar;
    @FXML
    public ComboBox comb; //menu desplegable
    @FXML
    public Text tarifa_label;
    @FXML
    public void Select(ActionEvent event) {
        String s = comb.getValue().toString();
        tarifa_label.setText("Comprar "+ s + "?");

    }
    ObservableList listTarifa = FXCollections.observableArrayList();

    protected void paintData(int index) {
        EntityManager em = new EntityManager();

        listTarifa = FXCollections.observableArrayList();
        List<Object> itemList = em.select(Tarifa.class, index, "", new String[0]);

        if (!itemList.isEmpty()) {
            listTarifa.addAll(itemList);
        }
        table_cotizar.setItems(listTarifa);
        comb.setItems(listTarifa);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<Tarifa, Integer>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<Tarifa, String>("nombre"));
        size.setCellValueFactory(new PropertyValueFactory<Tarifa, String>("dimensiones"));
        peso.setCellValueFactory(new PropertyValueFactory<Tarifa, Double>("pesoKg"));
        precio.setCellValueFactory(new PropertyValueFactory<Tarifa, Double>("precio"));

        paintData(-1);
    }


    }




