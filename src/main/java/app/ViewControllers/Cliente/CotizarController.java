package app.ViewControllers.Cliente;

import Entities.Usuarios.Usuario;
import Entities.operaciones.Tarifa;
import app.EntityManager;
import app.ViewControllers.Admin.GenericListController;
import app.ViewControllers.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CotizarController extends ViewController implements Initializable {

    @FXML
    public Button button_buscar;

    @FXML
    public Button button_cotizar;

    @FXML
    public Button button_cuenta;

    @FXML
    public Button button_facturas;

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
    public Label label;
    @FXML
    void Select(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();
        label.setText("Comprar "+ s + "?");

    }

    ObservableList<Tarifa> listTarifa = FXCollections.observableArrayList(
            new Tarifa(01, "Paquete S", "35 X 25 X 10 CM", 2, 3.79 ),
            new Tarifa(02, "Paquete M", "60 X 30 X 15 CM", 3, 4.79 ),
            new Tarifa(03, "Paquete L", "70 X 40 X 25 CM", 5, 6.79 ),
            new Tarifa(04, "Paquete XL", "75 X 45 X 35 CM", 7, 8.49 ),
            new Tarifa(05, "Paquete XXL", "85 X 50 X 40 CM", 8, 9.29 ),
            new Tarifa(06, "Paquete XXXL", "90 X 55 X 45 CM", 10, 12.29 )
    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> listComb = FXCollections.observableArrayList("Paquete S","Paquete M","Paquete L","Paquete XL","Paquete XXL","Paquete XXXL");
        comb.setItems(listComb);

        id.setCellValueFactory(new PropertyValueFactory<Tarifa, Integer>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<Tarifa, String>("nombre"));
        size.setCellValueFactory(new PropertyValueFactory<Tarifa, String>("tamaño"));
        peso.setCellValueFactory(new PropertyValueFactory<Tarifa, Double>("PesoKg"));
        precio.setCellValueFactory(new PropertyValueFactory<Tarifa, Double>("id"));

        table_cotizar.setItems(listTarifa);
        button_buscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Usuario/Buscar.fxml", event);
            }
        });

        button_facturas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Usuario/Factura.fxml", event);
            }
        });

        button_cuenta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToWindow("src/main/resources/Usuario/MiCuenta.fxml", event);
            }
        });
    }


    }




