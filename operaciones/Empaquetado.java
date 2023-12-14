package operaciones;

import java.util.ArrayList;


/**
 * @author Unai
 *
 * Clase Empaquetado, esta lleva asignada la tarifa escogida y el peso del paquete
 */
public class Empaquetado {

    private Tarifa tarifa;
    private double pesoKg;

    //Constructores

    public Empaquetado() {
    }

    /**
     * Constructor con parametros
     *
     * @param tarifa
     * @param pesoKg
     */
    public Empaquetado(Tarifa tarifa, double pesoKg) {
        this.tarifa = tarifa;
        this.pesoKg = pesoKg;
    }

    // getters / setters

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
}
