package app.ViewControllers.Admin.Operacion;

import Entities.Usuarios.Cliente;
import Entities.operaciones.*;
import Util.EntityManager;
import Util.ViewUtils;
import app.ViewControllers.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
    public ComboBox<Tarifa> tarifa_input;

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

        List<Object> usuarios = em.select(Cliente.class, -1, " ORDER BY nick DESC", new String[0]);

        ObservableList comboboxItems = FXCollections.observableArrayList();

        comboboxItems.add(null);
        if (!usuarios.isEmpty()) {
            comboboxItems.addAll(usuarios);
        }

        cliente_input.setItems(comboboxItems);

        cliente_input.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                direccion_input.setDisable(true);

                Cliente cliente = cliente_input.getValue();

                setDirecciones(cliente);

                direccion_input.setDisable(false);
            }
        });



        setDirecciones(null);



        List<Object> tarifas = em.select(Tarifa.class, -1, "", new String[0]);

        ObservableList tarifasItems = FXCollections.observableArrayList();

        if (!tarifas.isEmpty()) {
            tarifasItems.addAll(tarifas);
        }

        tarifa_input.setItems(tarifasItems);



        List<Object> facturas = em.select(Factura.class, -1, "", new String[0]);

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

                RutaView rutaView = new RutaView(rutaPane, new Ruta());
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
                Tarifa tarifa = tarifa_input.getValue();
                String peso_empaquetado = peso_input.getText();

                String[] string_fields = {peso_empaquetado};

                Object[] object_fields = {direccion, factura, tarifa};

                boolean rutasValidas = true;

                ArrayList<String> rutaQueries = new ArrayList<String>();

                if (!rutaViews.isEmpty()) {
                    for (int i = 0; i< rutaViews.size() && rutasValidas; i++) {
                        RutaView rutaView = rutaViews.get(i);
                        String tipoRuta = (String) rutaView.tipoSelector.getValue();
                        String origen = rutaView.origen.getText();
                        String destino = rutaView.destino.getText();
                        LocalDate salida = rutaView.salida.getValue();
                        LocalDate llegada = rutaView.llegada.getValue();


                        rutasValidas = ViewUtils.validateStringFields(new String[]{tipoRuta, origen, destino}) && ViewUtils.validateLocaldateFields(new LocalDate[]{salida});

                        if (rutasValidas) {

                            switch (rutaView.ruta.getTipo()) {
                                case Ruta.TIPO_MARITIMA:

                                    Puerto puertoOrigen = (Puerto) rutaView.puertoOrigen.getValue();
                                    Puerto puertoDestino = (Puerto) rutaView.puertoDestino.getValue();
                                    String nombreBarco = rutaView.nombreBarco.getText();
                                    String idContenedor = rutaView.idContenedor.getText();

                                    rutasValidas = rutasValidas && ViewUtils.validateObjectFields(new Object[]{puertoOrigen, puertoDestino}) && ViewUtils.validateStringFields(new String[]{nombreBarco, idContenedor});
                                    break;
                                case Ruta.TIPO_TERRESTRE:

                                    String vehiculo = rutaView.vehiculo.getText();
                                    String matricula = rutaView.matricula.getText();

                                    rutasValidas = rutasValidas && ViewUtils.validateStringFields(new String[]{vehiculo, matricula});
                                    break;
                                case Ruta.TIPO_AEREA:

                                    Aeropuerto aeropuertoOrigen = (Aeropuerto) rutaView.aeropuertoOrigen.getValue();
                                    Aeropuerto aeropuertoDestino = (Aeropuerto) rutaView.aeropuertoDestino.getValue();
                                    String aerolinea = rutaView.aerolinea.getText();
                                    String idVuelo = rutaView.idVuelo.getText();

                                    rutasValidas = rutasValidas && ViewUtils.validateObjectFields(new Object[]{aeropuertoOrigen, aeropuertoDestino}) && ViewUtils.validateStringFields(new String[]{aerolinea, idVuelo});
                                    break;
                            }
                        }
                    }
                }

                save_button.setDisable(true);

                if (ViewUtils.validateStringFields(string_fields) && ViewUtils.validateObjectFields(object_fields) && rutasValidas) {
                    String[] parameters = new String[]{String.valueOf(factura.getId()), String.valueOf(direccion.getId()), String.valueOf(tarifa.getId()), peso_empaquetado, String.valueOf(cliente.getId())};

                    int id = em.executeNativeQueryAndSelect("INSERT INTO Operacion(factura_id, direccion_id, tarifa_id, peso_empaquetado, usuario_id) VALUES(?1,?2,?3,?4, ?5)", parameters);

                    System.out.println("Id: "+ id);
                    back(event);
                } else {
                    error_label.setText("Por favor, rellena los campos obligatorios");
                }



                save_button.setDisable(false);
            }
        });
    }
    private void setDirecciones(Cliente cliente) {
        String query = "";
        String[] parameters;
        if (cliente == null){
            query = "";
            parameters = new String[0];
        }else {
            query = "WHERE usuario_id = ?1";
            parameters = new String[]{String.valueOf(cliente.getId())};
        }
        int length = parameters.length;
        //String item = parameters[0];
        List<Object> direcciones = em.select(Direccion.class, -1, query, parameters);

        ObservableList direccionesItems = FXCollections.observableArrayList();

        if (!direcciones.isEmpty()) {
            direccionesItems.addAll(direcciones);
        }

        direccion_input.setItems(direccionesItems);
    }

    private void back(ActionEvent event) {
        goToWindow("src/main/resources/Admin/Operacion/List.fxml", event);
    }

    class RutaView {

        public Ruta ruta;
        public final double PANE_HEIGHT = 340;

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
        public Label idVueloLabel;

        public TextField idVuelo;

        public Label aerolineaLabel;
        public TextField aerolinea;


        public Label puertoOrigenLabel;
        public ComboBox puertoOrigen;
        public Label puertoDestinoLabel;
        public ComboBox puertoDestino;
        public Label idContenedorLabel;

        public TextField idContenedor;

        public Label nombreBarcoLabel;
        public TextField nombreBarco;

        public Label vehiculoLabel;
        public TextField vehiculo;
        public Label matriculaLabel;
        public TextField matricula;

        public ObservableList aeropuertos;

        public ObservableList puertos;
        public AnchorPane datosRuta;


        RutaView (Pane rutaPane, Ruta ruta) {
            this.ruta = ruta;

            isPaneOpen = false;
            int index = accordion_rutas.getPanes().size();
            tipos = FXCollections.observableArrayList(new String[]{
                    "Marítima",
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
                    if (datosRuta == null) {
                        datosRuta = new AnchorPane();
                        datosRuta.setId("datosRuta");

                        datosRuta.setLayoutX(50);
                        datosRuta.setLayoutY(175);
                        datosRuta.setPrefWidth(550);
                        rutaPane.getChildren().add(datosRuta);
                    } else {
                        datosRuta.getChildren().clear();
                    }


                    String tipoRuta = (String) tipoSelector.getValue();


                    switch (tipoRuta) {
                        case "Marítima":
                            ruta.setTipo(Ruta.TIPO_MARITIMA);

                            puertos = FXCollections.observableArrayList();
                            List<Object> puertosList = em.select(Puerto.class, -1, " ORDER BY nombre DESC", new String[0]);

                            if (!puertosList.isEmpty()) {
                                puertos.addAll(puertosList);
                            }


                            puertoOrigenLabel = new Label("Puerto Origen     *");
                            puertoOrigenLabel.setLayoutX(0);
                            puertoOrigenLabel.setLayoutY(25);
                            datosRuta.getChildren().add(puertoOrigenLabel);
                            puertoOrigen = new ComboBox<Puerto>();
                            puertoOrigen.setLayoutX(0);
                            puertoOrigen.setLayoutY(60);
                            puertoOrigen.setItems(puertos);
                            puertoOrigen.setId("puertoOrigen");
                            puertoOrigen.setPrefWidth(150);
                            datosRuta.getChildren().add(puertoOrigen);


                            puertoDestinoLabel = new Label("Puerto Destino     *");
                            puertoDestinoLabel.setLayoutX(200);
                            puertoDestinoLabel.setLayoutY(25);
                            datosRuta.getChildren().add(puertoDestinoLabel);
                            puertoDestino = new ComboBox<Puerto>();
                            puertoDestino.setLayoutX(200);
                            puertoDestino.setLayoutY(60);
                            puertoDestino.setItems(puertos);
                            puertoDestino.setId("puertoDestino");
                            puertoDestino.setPrefWidth(150);
                            datosRuta.getChildren().add(puertoDestino);


                            nombreBarcoLabel = new Label("Nombre del barco     *");
                            nombreBarcoLabel.setLayoutX(400);
                            nombreBarcoLabel.setLayoutY(25);
                            datosRuta.getChildren().add(nombreBarcoLabel);
                            nombreBarco = new TextField();
                            nombreBarco.setLayoutX(400);
                            nombreBarco.setLayoutY(60);
                            ViewUtils.setDecimalBehaviour(nombreBarco);
                            nombreBarco.setId("nombreBarco");
                            datosRuta.getChildren().add(nombreBarco);

                            idContenedorLabel = new Label("Identificador del barco     *");
                            idContenedorLabel.setLayoutX(0);
                            idContenedorLabel.setLayoutY(115);
                            datosRuta.getChildren().add(idContenedorLabel);
                            idContenedor = new TextField();
                            idContenedor.setLayoutX(0);
                            idContenedor.setLayoutY(150);
                            ViewUtils.setDecimalBehaviour(idContenedor);
                            idContenedor.setId("idContenedor");
                            datosRuta.getChildren().add(idContenedor);

                            break;
                        case "Aerea":
                            ruta.setTipo(Ruta.TIPO_AEREA);

                            aeropuertos = FXCollections.observableArrayList();
                            List<Object> aeropuertosList = em.select(Aeropuerto.class, -1, " ORDER BY nombre DESC", new String[0]);

                            if (!aeropuertosList.isEmpty()) {
                                aeropuertos.addAll(aeropuertosList);
                            }


                            aeropuertoOrigenLabel = new Label("Aeropuerto Origen     *");
                            aeropuertoOrigenLabel.setLayoutX(0);
                            aeropuertoOrigenLabel.setLayoutY(25);
                            datosRuta.getChildren().add(aeropuertoOrigenLabel);
                            aeropuertoOrigen = new ComboBox<Aeropuerto>();
                            aeropuertoOrigen.setLayoutX(0);
                            aeropuertoOrigen.setLayoutY(60);
                            aeropuertoOrigen.setItems(aeropuertos);
                            aeropuertoOrigen.setId("aeropuertoOrigen");
                            aeropuertoOrigen.setPrefWidth(150);
                            datosRuta.getChildren().add(aeropuertoOrigen);


                            aeropuertoDestinoLabel = new Label("Aeropuerto Destino     *");
                            aeropuertoDestinoLabel.setLayoutX(200);
                            aeropuertoDestinoLabel.setLayoutY(25);
                            datosRuta.getChildren().add(aeropuertoDestinoLabel);
                            aeropuertoDestino = new ComboBox<Aeropuerto>();
                            aeropuertoDestino.setLayoutX(200);
                            aeropuertoDestino.setLayoutY(60);
                            aeropuertoDestino.setItems(aeropuertos);
                            aeropuertoDestino.setId("aeropuertoDestino");
                            aeropuertoDestino.setPrefWidth(150);
                            datosRuta.getChildren().add(aeropuertoDestino);


                            aerolineaLabel = new Label("Aerolinea     *");
                            aerolineaLabel.setLayoutX(400);
                            aerolineaLabel.setLayoutY(25);
                            datosRuta.getChildren().add(aerolineaLabel);
                            aerolinea = new TextField();
                            aerolinea.setLayoutX(400);
                            aerolinea.setLayoutY(60);
                            ViewUtils.setDecimalBehaviour(aerolinea);
                            aerolinea.setId("aerolinea");
                            datosRuta.getChildren().add(aerolinea);

                            idVueloLabel = new Label("Identificador del vuelo     *");
                            idVueloLabel.setLayoutX(0);
                            idVueloLabel.setLayoutY(115);
                            datosRuta.getChildren().add(idVueloLabel);
                            idVuelo = new TextField();
                            idVuelo.setLayoutX(0);
                            idVuelo.setLayoutY(150);
                            ViewUtils.setDecimalBehaviour(idVuelo);
                            idVuelo.setId("idVuelo");
                            datosRuta.getChildren().add(idVuelo);


                            break;
                        case "Terrestre":
                            ruta.setTipo(Ruta.TIPO_TERRESTRE);

                            vehiculoLabel = new Label("Vehículo     *");
                            vehiculoLabel.setLayoutX(0);
                            vehiculoLabel.setLayoutY(25);
                            datosRuta.getChildren().add(vehiculoLabel);
                            vehiculo = new TextField();
                            vehiculo.setLayoutX(0);
                            vehiculo.setLayoutY(60);
                            ViewUtils.setDecimalBehaviour(vehiculo);
                            vehiculo.setId("vehiculo");
                            datosRuta.getChildren().add(vehiculo);


                            matriculaLabel = new Label("Matrícula     *");
                            matriculaLabel.setLayoutX(200);
                            matriculaLabel.setLayoutY(25);
                            datosRuta.getChildren().add(matriculaLabel);
                            matricula = new TextField();
                            matricula.setLayoutX(200);
                            matricula.setLayoutY(60);
                            ViewUtils.setDecimalBehaviour(matricula);
                            matricula.setId("matricula");
                            datosRuta.getChildren().add(matricula);

                            break;
                    }

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
            llegada = new DatePicker();
            llegada.setLayoutX(190);
            llegada.setLayoutY(135);
            llegada.setPrefWidth(120);
            llegada.setId("llegada");
            rutaPane.getChildren().add(llegada);


            TitledPane pane = new TitledPane("Ruta " + (index + 1), rutaPane);
            pane.setExpanded(true);

            pane.expandedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean isOpen) {
                    double newHeight = scrollContainer.getPrefHeight();
                    newHeight = isPaneOpen ? newHeight - PANE_HEIGHT : newHeight + PANE_HEIGHT;

                    scrollContainer.setPrefHeight(newHeight);

                    isPaneOpen = isOpen;
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