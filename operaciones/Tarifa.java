package operaciones;

import java.util.Date;

public class Tarifa {
    private double pesoKg;
    private double anchuraMn;
    private double alturaMn;
    private double diagonalMm;
    private double precio;

    public Tarifa(double pesoKg, double anchuraMn, double alturaMn, double diagonalMm, double precio) {
        this.pesoKg = pesoKg;
        this.anchuraMn = anchuraMn;
        this.alturaMn = alturaMn;
        this.precio = precio;
    }

    public double getAnchuraMn() {
        return anchuraMn;
    }
    public void setAnchuraMn(Tarifa anchuraMn) {
        this.anchuraMn = anchuraMn.getAnchuraMn();
    }
    public double getPesoKg() {
        return pesoKg;
    }


}
