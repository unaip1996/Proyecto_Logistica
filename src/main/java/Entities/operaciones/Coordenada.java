package Entities.operaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Unai
 *
 * Clase para el manejo de ubicaciones, siempre tendrá una latitud y longitud
 */

@Entity
@Table(name = "Coordenada")
public class Coordenada {

    @Id
    @GeneratedValue
    private Long id;
    private double latitud;
    private double longitud;

    //Constructores


    public Coordenada() {
    }

    /**
     *
     * @param latitud
     * @param longitud
     */
    public Coordenada(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // getters / setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}