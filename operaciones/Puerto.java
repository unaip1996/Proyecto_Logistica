package operaciones;


/**
 * @author Unai
 *
 * Clase para objeto puerto, en el futuro podría ser util para una entidad en BD
 */
public class Puerto {

    private String nombre;

    //Constructores

    public Puerto() {
    }

    public Puerto(String nombre) {
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
