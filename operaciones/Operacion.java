package operaciones;

import java.util.ArrayList;

/**
 * @author Unai
 *
 * Clase principal para operaciones
 */
public class Operacion {

    // Definimos rutas como un ArrayList, ya que puede haber mas de 1 ruta para una operación
    private ArrayList<Ruta> rutas;
    private Empaquetado empaquetado;
    private Factura factura;

    //Constructores


    public Operacion() {
    }

    public Operacion(ArrayList<Ruta> rutas, Empaquetado empaquetado, Factura factura) {
        this.rutas = rutas;
        this.empaquetado = empaquetado;
        this.factura = factura;
    }

    // getters / setters

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
}
