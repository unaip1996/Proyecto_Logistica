package operaciones;

/**
 * @author Unai
 *
 * Clase para el manejo de ubicaciones, siempre tendrá una latitud y longitud
 */
public class Coordenada {

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