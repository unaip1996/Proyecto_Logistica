package operaciones;

/**
 * @author Unai
 *
 * Clase para objeto aeropuerto, en el futuro podría ser util para una entidad en BD
 */
public class Aeropuerto {

    private String nombre;

    //Constructores

    public Aeropuerto() {
    }

    /**
     *
     * @param nombre
     */
    public Aeropuerto(String nombre) {
        this.nombre = nombre;
    }

    // getters / setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
