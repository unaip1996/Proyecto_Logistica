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
    @JoinColumn(name = "empaquetado_id")
    private Empaquetado empaquetado;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    //Constructores


    public Operacion() {
    }

    public Operacion(ArrayList<Ruta> rutas, Empaquetado empaquetado, Factura factura, Direccion direccion) {
        this.rutas = rutas;
        this.empaquetado = empaquetado;
        this.factura = factura;
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

    public Empaquetado getEmpaquetado() {
        return empaquetado;
    }

    public void setEmpaquetado(Empaquetado empaquetado) {
        this.empaquetado = empaquetado;
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
}
