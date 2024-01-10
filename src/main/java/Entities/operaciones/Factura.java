package Entities.operaciones;

import Util.EntityManager;
import Util.SerializableEntity;
import jakarta.persistence.*;
import Entities.Usuarios.Cliente;

import java.util.Date;

@Entity
@Table(name = "Factura")
public class Factura implements SerializableEntity { // Definición de la clase Factura
    // Campos privados de la clase Factura


    @Id
    @GeneratedValue
    private int id;
    private String cantidad;// Número de factura
    private Date fecha;// Fecha de la factura


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Cliente cliente; // Cliente asociado a la factura (de la clase Usuarios.Usuario)
    private double montoTotal;// Monto total de la factura

    public Factura() {

    }

    /**
     * Constructor de la clase Factura que recibe varios parámetros para inicializar los campos
     *
     * @param cantidad
     * @param fecha
     * @param cliente
     * @param montoTotal
     */
    public Factura(String cantidad, Date fecha, Cliente cliente, double montoTotal) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
    }

    public Factura(int id, String cantidad, double montoTotal, Date fecha, Integer clienteId) {
        this.id = id;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.montoTotal = montoTotal;

        if (clienteId != null) {
            Util.EntityManager em = new EntityManager();
            this.cliente = (Cliente) em.selectOne(Cliente.class, "WHERE id=?1", new String[]{clienteId.toString()});
        }
    }

    /**
     * Constructor de la subclase que llama al constructor de la clase base (Factura) y asigna valores a sus propios campos
     *
     */
    public void mostrarFactura() {
        System.out.println("Número de Factura: " + cantidad);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente);
        System.out.println("Monto Total: $" + montoTotal);
    }


    public int getId() {
        return id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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

