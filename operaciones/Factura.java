package operaciones;

import java.util.Date;

public class Factura { // Definición de la clase Factura
    // Campos privados de la clase Factura
    private String numeroFactura;// Número de factura
    private Date fecha;// Fecha de la factura
    private Usuarios.Usuario cliente; // Cliente asociado a la factura (de la clase Usuarios.Usuario)
    private double montoTotal;// Monto total de la factura

    public Factura(String numeroFactura, Date fecha, Usuarios.Usuario cliente, double montoTotal) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
    }// Constructor de la clase Factura que recibe varios parámetros para inicializar los campos

    public void mostrarFactura() {
        System.out.println("Número de Factura: " + numeroFactura);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente);
        System.out.println("Monto Total: $" + montoTotal);
    }    // Constructor de la subclase que llama al constructor de la clase base (Factura) y asigna valores a sus propios campos
}

// Subclase para Facturas de Envíos Marítimos
class FacturaMaritima extends Factura {
    private String puertoOrigen;
    private String puertoDestino;

    public FacturaMaritima(String numeroFactura, Date fecha, Usuarios.Usuario cliente, double montoTotal, String puertoOrigen, String puertoDestino) {
        super(numeroFactura, fecha, cliente, montoTotal);
        this.puertoOrigen = puertoOrigen;
        this.puertoDestino = puertoDestino;
    }    // Constructor de la subclase que llama al constructor de la clase base (Factura) y asigna valores a sus propios campos


    @Override
    public void mostrarFactura() {
        super.mostrarFactura();// Llama al método mostrarFactura() de la clase base
        System.out.println("Tipo de Envío: Marítimo");
        System.out.println("Puerto de Origen: " + puertoOrigen);
        System.out.println("Puerto de Destino: " + puertoDestino);
    }    // Método para mostrar la información específica de Facturas de Envíos Marítimos

}

// Subclase para Facturas de Envíos Terrestres
class FacturaTerrestre extends Factura {
    private String origen;
    private String destino;

    // Constructor de la subclase que llama al constructor de la clase base (Factura) y asigna valores a sus propios campos
    public FacturaTerrestre(String numeroFactura, Date fecha, Usuarios.Usuario cliente, double montoTotal, String origen, String destino) {
        super(numeroFactura, fecha, cliente, montoTotal);
        this.origen = origen;
        this.destino = destino;
    }

    @Override
    // Método para mostrar la información específica de Facturas de Envíos Terrestres
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Tipo de Envío: Terrestre");
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
    }
}

// Subclase para Facturas de Envíos Aéreos
class FacturaAerea extends Factura {
    private String aeropuertoOrigen;
    private String aeropuertoDestino;

    public FacturaAerea(String numeroFactura, Date fecha, Usuarios.Usuario cliente, double montoTotal, String aeropuertoOrigen, String aeropuertoDestino) {
        super(numeroFactura, fecha, cliente, montoTotal);
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
    }

    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Tipo de Envío: Aéreo");
        System.out.println("Aeropuerto de Origen: " + aeropuertoOrigen);
        System.out.println("Aeropuerto de Destino: " + aeropuertoDestino);
    }
}
