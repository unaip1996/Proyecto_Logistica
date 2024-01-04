package Entities.operaciones;


import jakarta.persistence.*;

/**
 * @author Unai
 *
 * Clase Empaquetado, esta lleva asignada la tarifa escogida y el peso del paquete
 */

@Entity
@Table(name = "Empaquetado")
public class Empaquetado {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tarifa_id")
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

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

}
