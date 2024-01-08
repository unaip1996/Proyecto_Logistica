package Entities.operaciones;


import Util.SerializableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto implements SerializableEntity {


    @Id
    @GeneratedValue
    private int id;

    // Campos privados que representan las características del producto
    private String nombre; // Nombre del producto
    private double peso; // Peso del producto en kilogramos
    private double precio;// Precio del producto

    public Producto() {

    }

    /**
     * Constructor de la clase Producto que recibe nombre, peso y precio como parámetros
     *
     * @param nombre
     * @param peso
     * @param precio
     */
    public Producto(String nombre, double peso, double precio) {

        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    } // Método para obtener el nombre del producto

    public double getPeso() {
        return peso;
    } // Método para obtener el peso del producto

    public double getPrecio() {
        return precio;
    } // Método para obtener el precio del producto

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
