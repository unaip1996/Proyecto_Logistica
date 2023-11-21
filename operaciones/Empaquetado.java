package operaciones;

import java.util.ArrayList;


/**
 * @author Unai
 *
 * Clase Empaquetado, esta lleva el registro del listado del listado de productos que contiene y las medidas del paquete
 */
public class Empaquetado {

    private ArrayList<Producto> productos;
    private double pesoKg;
    private double anchuraMm;
    private double alturaMm;
    private double diagonalMm;

    //Constructores

    public Empaquetado() {
    }

    /**
     * Constructor con parametros
     *
     * @param productos
     * @param pesoKg
     * @param anchuraMm
     * @param alturaMm
     * @param diagonalMm
     */
    public Empaquetado(ArrayList<Producto> productos, double pesoKg, double anchuraMm, double alturaMm, double diagonalMm) {
        this.productos = productos;
        this.pesoKg = pesoKg;
        this.anchuraMm = anchuraMm;
        this.alturaMm = alturaMm;
        this.diagonalMm = diagonalMm;
    }



    // getters / setters

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
