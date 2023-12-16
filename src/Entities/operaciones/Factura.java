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

