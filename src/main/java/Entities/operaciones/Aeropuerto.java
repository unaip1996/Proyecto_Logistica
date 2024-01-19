package Entities.operaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Unai
 *
 * Clase para objeto aeropuerto, en el futuro podría ser util para una entidad en BD
 */

@Entity
@Table(name = "Aeropuerto")
public class Aeropuerto {


    @Id
    @GeneratedValue
    private int id;

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

    public Aeropuerto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // getters / setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
