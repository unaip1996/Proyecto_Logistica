package operaciones;

import java.time.LocalDateTime;

public class Ruta {

    final static int TIPO_AEREA = 0;
    final static int TIPO_MARITIMA = 1;
    final static int TIPO_TERRESTRE = 2;


    private int tipo;
    private Coordenada origen;
    private Coordenada destino;
    private LocalDateTime salida;
    private LocalDateTime llegada;
    public Ruta() {
        this.salida = LocalDateTime.now();
    }

    public Ruta(Coordenada origen, Coordenada destino) {
        this.origen = origen;
        this.destino = destino;

        this.salida = LocalDateTime.now();
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
