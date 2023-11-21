package operaciones;

/**
 * @author unai
 *
 * Clase RutaAerea, lleva el registro del coche asignado
 */
public class RutaTerrestre extends Ruta{

    private String vehiculo;
    private String matricula;

    //Constructores

    public RutaTerrestre() {
    }

    public RutaTerrestre(Coordenada origen, Coordenada destino, String vehiculo, String matricula) {
        super(origen, destino);
        this.vehiculo = vehiculo;
        this.matricula = matricula;
    }

    // getters / setters

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
