package Entities.operaciones;

import Entities.Usuarios.Cliente;
import Util.EntityManager;
import Util.SerializableEntity;
import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * @author Unai
 *
 * Clase principal para operaciones
 */

@Entity
@Table(name = "Operacion")
public class Operacion implements SerializableEntity {

    @Id
    @GeneratedValue
    private int id;

    // Definimos rutas como un ArrayList, ya que puede haber mas de 1 ruta para una operación


    @OneToMany(mappedBy = "operacion", cascade = CascadeType.ALL)
    private ArrayList<Ruta> rutas;

    @ManyToOne
    @JoinColumn(name = "tarifa_id")
    private Tarifa tarifa;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    private double pesoEmpaquetado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Cliente cliente;

    //Constructores


    public Operacion() {
    }

    public Operacion(Tarifa tarifa, Factura factura, Direccion direccion, Double pesoEmpaquetado) {
        this.tarifa = tarifa;
        this.factura = factura;
        this.direccion = direccion;
        this.pesoEmpaquetado = pesoEmpaquetado;
    }

    public Operacion(int id, Integer facturaId, Integer direccionId, Integer tarifaId, Double pesoEmpaquetado, Integer clienteId) {
        this.id = id;

        if (facturaId != null) {
            Util.EntityManager em = new EntityManager();
            this.factura = (Factura) em.selectOne(Factura.class, "WHERE id=?1", new Integer[]{facturaId});
        }

        if (direccionId != null) {
            Util.EntityManager em = new EntityManager();
            this.direccion = (Direccion) em.selectOne(Direccion.class, "WHERE id=?1", new Integer[]{direccionId});
        }

        if (tarifaId != null) {
            Util.EntityManager em = new EntityManager();
            this.tarifa = (Tarifa) em.selectOne(Tarifa.class, "WHERE id=?1", new Integer[]{tarifaId});
        }

        if (clienteId != null) {
            Util.EntityManager em = new EntityManager();
            this.cliente = (Cliente) em.selectOne(Tarifa.class, "WHERE id=?1", new Integer[]{clienteId});
        }

        this.pesoEmpaquetado = pesoEmpaquetado;
    }

    // getters / setters


    public int getId() {
        return id;
    }

    public ArrayList<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<Ruta> rutas) {
        this.rutas = rutas;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public double getPesoEmpaquetado() {
        return pesoEmpaquetado;
    }

    public void setPesoEmpaquetado(double pesoEmpaquetado) {
        this.pesoEmpaquetado = pesoEmpaquetado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
