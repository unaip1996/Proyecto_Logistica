package operaciones;

public class RutaAerea extends Ruta{

    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;

    private String idVuelo;
    private String aerolinea;


    public RutaAerea() {
        super();
    }

    public RutaAerea(Coordenada origen, Coordenada destino, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, String idVuelo, String aerolinea) {
        super(origen, destino);
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.idVuelo = idVuelo;
        this.aerolinea = aerolinea;
    }

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
