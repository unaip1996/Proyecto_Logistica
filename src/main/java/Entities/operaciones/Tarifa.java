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
    private double anchuraMn;
    private double alturaMn;
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
     * @param anchuraMn
     * @param alturaMn
     * @param diagonalMm
     * @param precio
     */
    public Tarifa(double pesoKg, double anchuraMn, double alturaMn, double diagonalMm, double precio, String nombre) {
        this.pesoKg = pesoKg;
        this.anchuraMn = anchuraMn;
        this.alturaMn = alturaMn;
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
     * @param anchuraMn
     * @param alturaMn
     * @param diagonalMm
     */

    public Tarifa(int id, String nombre, double pesoKg, double precio, double anchuraMn, double alturaMn, double diagonalMm) {
        this.id = id;
        this.nombre = nombre;
        this.pesoKg = pesoKg;
        this.precio = precio;
        this.anchuraMn = anchuraMn;
        this.alturaMn = alturaMn;
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

    public double getAnchuraMn() {
        return anchuraMn;
    }

    public void setAnchuraMn(double anchuraMn) {
        this.anchuraMn = anchuraMn;
    }

    public double getAlturaMn() {
        return alturaMn;
    }

    public void setAlturaMn(double alturaMn) {
        this.alturaMn = alturaMn;
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
        this.dimensiones = alturaMn + "mm X " + anchuraMn + "mm X " + diagonalMm + "mm";
    }

    @Override
    public String toString() {
        return nombre;
    }
}
