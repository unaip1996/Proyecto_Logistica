package operaciones;

public class Producto {
        private String nombre;
        private double peso;
        private double precio;

        public Producto(String nombre, double peso, double precio) {
            this.nombre = nombre;
            this.peso = peso;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPeso() {
            return peso;
        }

        public double getPrecio() {
            return precio;
        }



}
