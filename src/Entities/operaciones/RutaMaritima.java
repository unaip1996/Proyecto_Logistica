package Entities.operaciones;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * @author unai
 *
 * Clase RutaMaritima, lleva el registro de los puertos por los que pasa y el contenedor asignado
 */
public class RutaMaritima extends Ruta {

    @ManyToOne
    @JoinColumn(name = "puerto_id")
    private Puerto puertoOrigen;

    @ManyToOne
    @JoinColumn(name = "puerto_id")
    private Puerto puertoDestino;

    private String nombreBarco;
    private String idContenedor;

    //Constructores


    public RutaMaritima() {
        super();
        this.tipo = Ruta.TIPO_MARITIMA;
    }

    public RutaMaritima(Coordenada origen, Coordenada destino, Puerto puertoOrigen, Puerto puertoDestino, String nombreBarco, String idContenedor) {
        super(origen, destino);
        this.puertoOrigen = puertoOrigen;
        this.puertoDestino = puertoDestino;
        this.nombreBarco = nombreBarco;
        this.idContenedor = idContenedor;
        this.tipo = Ruta.TIPO_MARITIMA;
    }

    // getters / setters

    public Puerto getPuertoOrigen() {
        return puertoOrigen;
    }

    public void setPuertoOrigen(Puerto puertoOrigen) {
        this.puertoOrigen = puertoOrigen;
    }

    public Puerto getPuertoDestino() {
        return puertoDestino;
    }

    public void setPuertoDestino(Puerto puertoDestino) {
        this.puertoDestino = puertoDestino;
    }

    public String getNombreBarco() {
        return nombreBarco;
    }

    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }

    public String getIdContenedor() {
        return idContenedor;
    }

    public void setIdContenedor(String idContenedor) {
        this.idContenedor = idContenedor;
    }
}
