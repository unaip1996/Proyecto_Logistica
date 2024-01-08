package Entities.operaciones;


import Util.SerializableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Unai
 *
 * Clase para objeto puerto, en el futuro podría ser util para una entidad en BD
 */

@Entity
@Table(name = "Puerto")
public class Puerto implements SerializableEntity {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;

    //Constructores

    public Puerto() {
    }

    public Puerto(String nombre) {
        this.nombre = nombre;
    }

    // getters / setters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
