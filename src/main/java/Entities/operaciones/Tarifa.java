package Entities.operaciones;

import Util.SerializableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Unai
 * @author Sara
 *
 * Clase Empaquetado, esta lleva asignada la tarifa escogida y el peso del paquete
 */

@Entity
@Table(name = "Tarifa")
public class Tarifa implements SerializableEntity {

    @Id
    @GeneratedValue
    private int id;

    private String nombre;

    private double pesoKg;

    private double precio;

    private String tamaño;

    public Tarifa() {
    }

    /**
     * Constructor con parametros
     *
     * @param nombre
     * @param tamaño
     * @param pesoKg
     * @param precio
     */
    public Tarifa(int id, String nombre, String tamaño, double pesoKg, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.pesoKg = pesoKg;
        this.precio = precio;

    }

    // getters / setters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String anchuraMn) {
        this.nombre = nombre;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void settamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
