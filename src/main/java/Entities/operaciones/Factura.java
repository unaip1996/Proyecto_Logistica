package Entities.operaciones;

import jakarta.persistence.*;
import Entities.Usuarios.Cliente;

import java.util.Date;

@Entity
public class Factura { // Definición de la clase Factura
    // Campos privados de la clase Factura
    private String numeroFactura;// Número de factura
    private Date fecha;// Fecha de la factura


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Cliente cliente; // Cliente asociado a la factura (de la clase Usuarios.Usuario)
    private double montoTotal;// Monto total de la factura
    @Id
    @GeneratedValue
    private Long id;

    public Factura() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}

