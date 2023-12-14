package operaciones;

import java.util.ArrayList;

public class Operacion {

    private ArrayList<Ruta> rutas;
    private Empaquetado empaquetado;
    private Factura factura;
    private Direccion direccion;


    public Operacion() {
    }

    public Operacion(ArrayList<Ruta> rutas, Empaquetado empaquetado, Factura factura, Direccion direccion) {
        this.rutas = rutas;
        this.empaquetado = empaquetado;
        this.factura = factura;
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
