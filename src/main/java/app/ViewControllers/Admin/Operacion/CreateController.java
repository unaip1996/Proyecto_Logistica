package app.ViewControllers.Admin.Operacion;

import Entities.Usuarios.Cliente;
import Entities.operaciones.Direccion;
import Entities.operaciones.Factura;
import Util.EntityManager;
import Util.ViewUtils;
import app.ViewControllers.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateController extends ViewController {
    @FXML
    public Button back_button;
    @FXML
    public Button save_button;
    @FXML
    public Label error_label;

    @FXML
    public AnchorPane center;

    @FXML
    public AnchorPane scrollContainer;

    @FXML
    public ComboBox<Direccion> direccion_input;

    @FXML
    public ComboBox<Factura> factura_input;

    @FXML
    public ComboBox<Cliente> cliente_input;

    @FXML
    public TextField peso_input;

    @FXML
    public Accordion accordion_rutas;

    @FXML
    public Button button_newRuta;

    private List<RutaView> rutaViews;

    public double TITLEDPANE_HEIGHT = 30;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        em = new EntityManager();

        ViewUtils.setDecimalBehaviour(peso_input);

        List<Object> usuarios = em.select(Cliente.class, -1, " ORDER BY nick DESC");

        ObservableList comboboxItems = FXCollections.observableArrayList();

        if (!usuarios.isEmpty()) {
            comboboxItems.addAll(usuarios);
        }

        cliente_input.setItems(comboboxItems);



        List<Object> direcciones = em.select(Direccion.class, -1, "");

        ObservableList direccionesItems = FXCollections.observableArrayList();

        if (!direcciones.isEmpty()) {
            direccionesItems.addAll(direcciones);
        }

        direccion_input.setItems(direccionesItems);



        List<Object> facturas = em.select(Factura.class, -1, "");

        ObservableList facturasItems = FXCollections.observableArrayList();

        if (!facturas.isEmpty()) {
            facturasItems.addAll(facturas);
        }

        factura_input.setItems(facturasItems);



        rutaViews = new ArrayList<RutaView>();

        button_newRuta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AnchorPane rutaPane = new AnchorPane();


                scrollContainer.setPrefHeight(scrollContainer.getHeight() + TITLEDPANE_HEIGHT);

                RutaView rutaView = new RutaView(rutaPane);
                rutaViews.add(rutaView);
            }
        });
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                back(event);
            }
        });
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Direccion direccion = direccion_input.getValue();
                Factura factura = factura_input.getValue();
                Cliente cliente = cliente_input.getValue();
                String peso_empaquetado = peso_input.getText();

                String[] fields = {peso_empaquetado};

                if (!rutaViews.isEmpty()) {
                    for (RutaView rutaView : rutaViews) {

                    }
                }

                save_button.setDisable(true);

                if (ViewUtils.validateFields(fields) && direccion != null && factura != null && cliente != null) {
//                    String[] parameters = new String[]{cantidad, montoTotal, String.valueOf(cliente.getId()), selectedDate.toString()};
//
//                    em.executeNativeQuery("INSERT INTO Operacion(numero, monto_total, usuario_id, fecha) VALUES(?1,?2,?3,?4)", parameters);

                    back(event);
                } else {
                    error_label.setText("Por favor, rellena los campos obligatorios");
                }



                save_button.setDisable(false);
            }
        });
    }

    private void back(ActionEvent event) {
        goToWindow("src/main/resources/Admin/Operacion/List.fxml", event);
    }

    class RutaView {

        public final double PANE_HEIGHT = 170;

        public boolean isPaneOpen;
        public ObservableList tipos;

        public Label tipoLabel;
        public ComboBox tipoSelector;
        public Label origenLabel;
        public TextField origen;
        public Label destinoLabel;
        public TextField destino;
        public Label salidaLabel;
        public DatePicker salida;
        public Label llegadaLabel;
        public DatePicker llegada;
        public Button eliminarRuta;
        public Label aeropuertoOrigenLabel;
        public ComboBox aeropuertoOrigen;
        public Label aeropuertoDestinoLabel;
        public ComboBox aeropuertoDestino;
        public Label vehiculoLabel;
        public TextField vehiculo;
        public Label matriculaLabel;
        public TextField matricula;




        RutaView (Pane rutaPane) {
            isPaneOpen = false;
            int index = accordion_rutas.getPanes().size();
            tipos = FXCollections.observableArrayList(new String[]{
                    "Maritima",
                    "Aerea",
                    "Terrestre"
            });

            tipoLabel = new Label("Tipo de Ruta     *");
            tipoLabel.setLayoutX(50);
            tipoLabel.setLayoutY(25);
            rutaPane.getChildren().add(tipoLabel);

            tipoSelector = new ComboBox();
            tipoSelector.setItems(tipos);
            tipoSelector.setLayoutX(50);
            tipoSelector.setLayoutY(60);
            tipoSelector.setId("tipoRuta");

            tipoSelector.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    rutaPane.lookupAll("#datosRuta");
                    AnchorPane datosRuta = new AnchorPane();
                    datosRuta.setId("datosRuta");
                    datosRuta.setLayoutX(50);
                    datosRuta.setLayoutY(175);
                    datosRuta.setPrefWidth(600);

                    datosRuta.setStyle("-fx-background-color: #0356fc");


                    matriculaLabel = new Label("Matrícula     *");
                    matriculaLabel.setLayoutX(0);
                    matriculaLabel.setLayoutY(25);
                    datosRuta.getChildren().add(matriculaLabel);
                    matricula = new TextField();
                    matricula.setLayoutX(0);
                    matricula.setLayoutY(60);
                    ViewUtils.setDecimalBehaviour(matricula);
                    matricula.setId("aeropuertoOrigen");
                    datosRuta.getChildren().add(matricula);


                    //aeropuertoOrigenLabel = new Label("Aeropuerto Origen     *");
                    //aeropuertoOrigenLabel.setLayoutX(50);
                    //aeropuertoOrigenLabel.setLayoutY(25);
                    //datosRuta.getChildren().add(origenLabel);
                    //aeropuertoOrigen = new TextField();
                    //aeropuertoOrigen.setLayoutX(50);
                    //aeropuertoOrigen.setLayoutY(60);
                    //ViewUtils.setDecimalBehaviour(origen);
                    //aeropuertoOrigen.setId("aeropuertoOrigen");
                    //datosRuta.getChildren().add(origen);

                    rutaPane.getChildren().add(datosRuta);

                }
            });
            rutaPane.getChildren().add(tipoSelector);



            origenLabel = new Label("Origen     *");
            origenLabel.setLayoutX(190);
            origenLabel.setLayoutY(25);
            rutaPane.getChildren().add(origenLabel);
            origen = new TextField();
            origen.setLayoutX(190);
            origen.setLayoutY(60);
            ViewUtils.setDecimalBehaviour(origen);
            origen.setId("origen");
            rutaPane.getChildren().add(origen);

            destinoLabel = new Label("Destino     *");
            destinoLabel.setLayoutX(380);
            destinoLabel.setLayoutY(25);
            rutaPane.getChildren().add(destinoLabel);
            destino = new TextField();
            destino.setLayoutX(380);
            destino.setLayoutY(60);
            ViewUtils.setDecimalBehaviour(destino);
            destino.setId("destino");
            rutaPane.getChildren().add(destino);



            salidaLabel = new Label("Salida     *");
            salidaLabel.setLayoutX(50);
            salidaLabel.setLayoutY(100);
            rutaPane.getChildren().add(salidaLabel);
            salida = new DatePicker(LocalDate.now());
            salida.setLayoutX(50);
            salida.setLayoutY(135);
            salida.setPrefWidth(120);
            salida.setId("salida");
            rutaPane.getChildren().add(salida);

            llegadaLabel = new Label("Llegada");
            llegadaLabel.setLayoutX(190);
            llegadaLabel.setLayoutY(100);
            rutaPane.getChildren().add(llegadaLabel);
            llegada = new DatePicker(LocalDate.now());
            llegada.setLayoutX(190);
            llegada.setLayoutY(135);
            llegada.setPrefWidth(120);
            llegada.setId("llegada");
            rutaPane.getChildren().add(llegada);


            TitledPane pane = new TitledPane("Ruta " + (index + 1), rutaPane);
            pane.setExpanded(true);
            pane.setOnMouseClicked(new EventHandler<Event>() {
                @Override
                public void handle(Event keyEvent) {
                    double newHeight = scrollContainer.getPrefHeight();
                    newHeight = isPaneOpen ? newHeight - PANE_HEIGHT : newHeight + PANE_HEIGHT;

                    scrollContainer.setPrefHeight(newHeight);

                    isPaneOpen = !isPaneOpen;
                }
            });
            accordion_rutas.getPanes().add(pane);



            eliminarRuta = new Button("Eliminar");
            eliminarRuta.setLayoutX(550);
            eliminarRuta.setLayoutY(25);
            eliminarRuta.setTextFill(Color.RED);
            eliminarRuta.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    accordion_rutas.getPanes().remove(pane);
                    rutaViews.remove(index);

                    scrollContainer.setPrefHeight(scrollContainer.getHeight() - (TITLEDPANE_HEIGHT + PANE_HEIGHT));
                }
            });
            rutaPane.getChildren().add(eliminarRuta);
        }
    }
}