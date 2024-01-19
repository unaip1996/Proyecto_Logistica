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
    private double pesoKg;
    private double anchuraMm;
    private double alturaMm;
    private double diagonalMm;
    private double precio;

    private String nombre;

    private String dimensiones;

    public Tarifa() {
    }

    /**
     * Constructor con parametros
     *
     * @param pesoKg
     * @param anchuraMm
     * @param alturaMm
     * @param diagonalMm
     * @param precio
     */
    public Tarifa(Double pesoKg, Double anchuraMm, Double alturaMm, Double diagonalMm, Double precio, String nombre) {
        this.pesoKg = pesoKg;
        this.anchuraMm = anchuraMm;
        this.alturaMm = alturaMm;
        this.diagonalMm = diagonalMm;
        this.precio = precio;
        this.nombre = nombre;

        this.setDimensiones();
    }
    /**
     * Constructor con parametros
     * @param id
     * @param nombre
     * @param pesoKg
     * @param precio
     * @param anchuraMm
     * @param alturaMm
     * @param diagonalMm
     */

    public Tarifa(int id, String nombre, Double pesoKg, Double precio, Double anchuraMm, Double alturaMm, Double diagonalMm) {
        this.id = id;
        this.nombre = nombre;
        this.pesoKg = pesoKg;
        this.precio = precio;
        this.anchuraMm = anchuraMm;
        this.alturaMm = alturaMm;
        this.diagonalMm = diagonalMm;

        this.setDimensiones();
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

    public double getAnchuraMm() {
        return anchuraMm;
    }

    public void setAnchuraMm(double anchuraMm) {
        this.anchuraMm = anchuraMm;
    }

    public double getAlturaMm() {
        return alturaMm;
    }

    public void setAlturaMm(double alturaMm) {
        this.alturaMm = alturaMm;
    }

    public double getDiagonalMm() {
        return diagonalMm;
    }

    public void setDiagonalMm(double diagonalMm) {
        this.diagonalMm = diagonalMm;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones() {
        this.dimensiones = alturaMm + "mm X " + anchuraMm + "mm X " + diagonalMm + "mm";
    }

    @Override
    public String toString() {
        return nombre;
    }
}
