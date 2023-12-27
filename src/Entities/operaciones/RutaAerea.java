package Entities.operaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * @author unai
 *
 * Clase RutaAerea, lleva el registro de los aeropuertos por los que pasa y el vuelo asignado
 */

@Entity
public class RutaAerea extends Ruta{


    @ManyToOne
    @JoinColumn(name = "aeropuerto_id")
    private Aeropuerto aeropuertoOrigen;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_id")
    private Aeropuerto aeropuertoDestino;

    private String idVuelo;
    private String aerolinea;

    //Constructores


    public RutaAerea() {
        super();
        this.tipo = Ruta.TIPO_AEREA;
    }

    public RutaAerea(Coordenada origen, Coordenada destino, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, String idVuelo, String aerolinea) {
        super(origen, destino);
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.idVuelo = idVuelo;
        this.aerolinea = aerolinea;
        this.tipo = Ruta.TIPO_AEREA;
    }

    // getters / setters

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
}
