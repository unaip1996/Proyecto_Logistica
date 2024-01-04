package Entities.operaciones;


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
public class Puerto {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    //Constructores

    public Puerto() {
    }

    public Puerto(String nombre) {
        this.nombre = nombre;
    }

    // getters / setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
