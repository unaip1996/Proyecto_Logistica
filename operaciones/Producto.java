package operaciones;

public class Producto {
        private String nombre;
        private double peso;
        private double precio;
        private Envio envio; // Utilizamos una clase Envio para representar el tipo de envío

        public Producto(String nombre, double peso, double precio, Envio envio) {
            this.nombre = nombre;
            this.peso = peso;
            this.precio = precio;
            this.envio = envio;
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

        public Envio getEnvio() {
            return envio;
        }

    // Clase para representar el tipo de envío
    class Envio {
        private String tipo;

        public Envio(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }
    }
}
