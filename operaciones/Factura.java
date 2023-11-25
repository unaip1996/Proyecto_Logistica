package operaciones;

import Usuarios.Cliente;

import java.util.Date;

public class Factura { // Definición de la clase Factura
    // Campos privados de la clase Factura
    private String numeroFactura;// Número de factura
    private Date fecha;// Fecha de la factura
    private Cliente cliente; // Cliente asociado a la factura (de la clase Usuarios.Usuario)
    private double montoTotal;// Monto total de la factura

    /**
     * Constructor de la clase Factura que recibe varios parámetros para inicializar los campos
     *
     * @param numeroFactura
     * @param fecha
     * @param cliente
     * @param montoTotal
     */
    public Factura(String numeroFactura, Date fecha, Cliente cliente, double montoTotal) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
    }

    /**
     * Constructor de la subclase que llama al constructor de la clase base (Factura) y asigna valores a sus propios campos
     *
     */
    public void mostrarFactura() {
        System.out.println("Número de Factura: " + numeroFactura);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente);
        System.out.println("Monto Total: $" + montoTotal);
    }
}

/**
 * Subclase para Facturas de Envíos Marítimos
 *
 */
class FacturaMaritima extends Factura {
    private String puertoOrigen;
    private String puertoDestino;

    /**
     * Constructor de la subclase que llama al constructor de la clase base (Factura) y asigna valores a sus propios campos
     *
     * @param numeroFactura
     * @param fecha
     * @param cliente
     * @param montoTotal
     * @param puertoOrigen
     * @param puertoDestino
     */
    public FacturaMaritima(String numeroFactura, Date fecha, Cliente cliente, double montoTotal, String puertoOrigen, String puertoDestino) {
        super(numeroFactura, fecha, cliente, montoTotal);
        this.puertoOrigen = puertoOrigen;
        this.puertoDestino = puertoDestino;
    }


    /**
     * Método para mostrar la información específica de Facturas de Envíos Marítimos
     *
     */
    @Override
    public void mostrarFactura() {
        super.mostrarFactura();// Llama al método mostrarFactura() de la clase base
        System.out.println("Tipo de Envío: Marítimo");
        System.out.println("Puerto de Origen: " + puertoOrigen);
        System.out.println("Puerto de Destino: " + puertoDestino);
    }

}

/**
 * Subclase para Facturas de Envíos Terrestres
 */
class FacturaTerrestre extends Factura {
    private String origen;
    private String destino;

    /**
     * Constructor de la subclase que llama al constructor de la clase base (Factura) y asigna valores a sus propios campos
     *
     *
     * @param numeroFactura
     * @param fecha
     * @param cliente
     * @param montoTotal
     * @param origen
     * @param destino
     */
    public FacturaTerrestre(String numeroFactura, Date fecha, Cliente cliente, double montoTotal, String origen, String destino) {
        super(numeroFactura, fecha, cliente, montoTotal);
        this.origen = origen;
        this.destino = destino;
    }

    /**
     * Método para mostrar la información específica de Facturas de Envíos Terrestres
     */
    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Tipo de Envío: Terrestre");
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
    }
}

/**
 * Subclase para Facturas de Envíos Aéreos
 *
 */
class FacturaAerea extends Factura {
    private String aeropuertoOrigen;
    private String aeropuertoDestino;

    public FacturaAerea(String numeroFactura, Date fecha, Cliente cliente, double montoTotal, String aeropuertoOrigen, String aeropuertoDestino) {
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
