package operaciones;

public class RutaMaritima extends Ruta {

    private Puerto puertoOrigen;
    private Puerto puertoDestino;

    private String nombreBarco;
    private String idContenedor;


    public RutaMaritima() {
        super();
    }

    public RutaMaritima(Coordenada origen, Coordenada destino, Puerto puertoOrigen, Puerto puertoDestino, String nombreBarco, String idContenedor) {
        super(origen, destino);
        this.puertoOrigen = puertoOrigen;
        this.puertoDestino = puertoDestino;
        this.nombreBarco = nombreBarco;
        this.idContenedor = idContenedor;
    }

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
