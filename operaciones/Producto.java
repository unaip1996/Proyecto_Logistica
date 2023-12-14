package operaciones;

public class Producto {

    // Campos privados que representan las características del producto
    private String nombre; // Nombre del producto
    private double peso; // Peso del producto en kilogramos
    private double precio;// Precio del producto

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
