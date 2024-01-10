package Entities.operaciones;

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

    //Constructores


    public Operacion() {
    }

    public Operacion(Tarifa tarifa, Factura factura, Direccion direccion, double pesoEmpaquetado) {
        this.tarifa = tarifa;
        this.factura = factura;
        this.direccion = direccion;
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
}
