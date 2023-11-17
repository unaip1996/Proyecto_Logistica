package operaciones;

import java.util.ArrayList;

public class Empaquetado {

    private ArrayList<Producto> productos;
    private double pesoKg;
    private double anchuraMm;
    private double alturaMm;
    private double diagonalMm;

    public Empaquetado() {
    }

    public Empaquetado(ArrayList<Producto> productos, double pesoKg, double anchuraMm, double alturaMm, double diagonalMm) {
        this.productos = productos;
        this.pesoKg = pesoKg;
        this.anchuraMm = anchuraMm;
        this.alturaMm = alturaMm;
        this.diagonalMm = diagonalMm;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
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
}
