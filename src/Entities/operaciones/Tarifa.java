package operaciones;

import java.util.Date;

/**
 * @author Unai
 * @author Sara
 *
 * Clase Empaquetado, esta lleva asignada la tarifa escogida y el peso del paquete
 */
public class Tarifa {
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
        this.precio = precio;
    }

    // getters / setters

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
