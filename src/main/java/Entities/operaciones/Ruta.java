package Entities.operaciones;

import Util.SerializableEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;


/**
 * @author Unai
 *
 * Clase padre Ruta, contiene informacion sobre origen, llegada, y el tipo
 */

@Entity
@Table(name = "Ruta")
public class Ruta implements SerializableEntity {

    @Id
    @GeneratedValue
    private int id;

    //Constantes internas de la clase para saber el tipo de ruta que es
    public final static byte TIPO_AEREA = 0;
    public final static byte TIPO_MARITIMA = 1;
    public final static byte TIPO_TERRESTRE = 2;

    //Variable para el tipo; aunque podemos controlarlo por las clases hijas, puede venir bien para guardarla en BD
    protected int tipo;


    @ManyToOne
    @JoinColumn(name = "coordenada_id")
    private Coordenada origen;

    @ManyToOne
    @JoinColumn(name = "coordenada_id")
    private Coordenada destino;
    private LocalDateTime salida;
    private LocalDateTime llegada;

    //Constructores

    public Ruta() {
        //En el momento en el que se crea la ruta se le coloca la hora de salida
        this.salida = LocalDateTime.now();
    }

    public Ruta(Coordenada origen, Coordenada destino) {
        this.origen = origen;
        this.destino = destino;

        this.salida = LocalDateTime.now();
    }

    // getters / setters


    public int getId() {
        return id;
    }

    public Coordenada getOrigen() {
        return origen;
    }

    public void setOrigen(Coordenada origen) {
        this.origen = origen;
    }

    public Coordenada getDestino() {
        return destino;
    }

    public void setDestino(Coordenada destino) {
        this.destino = destino;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    public LocalDateTime getLlegada() {
        return llegada;
    }

    public void setLlegada(LocalDateTime llegada) {
        this.llegada = llegada;
    }
}
