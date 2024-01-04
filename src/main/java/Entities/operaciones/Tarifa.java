package Entities.operaciones;

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
public class Tarifa {

    @Id
    @GeneratedValue
    private Long id;
    private double pesoKg;
    private double anchuraMn;
    private double alturaMn;
    private double diagonalMm;
    private double precio;

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
    public Tarifa(double pesoKg, double anchuraMn, double alturaMn, double diagonalMm, double precio) {
        this.pesoKg = pesoKg;
        this.anchuraMn = anchuraMn;
        this.alturaMn = alturaMn;
        this.diagonalMm = diagonalMm;
        this.precio = precio;
    }

    // getters / setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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
}
