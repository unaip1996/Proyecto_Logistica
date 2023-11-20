package Usuarios;
public class Usuariosprom implements Usuarios {
    private String nombre;
    private String contraseña;

    // Constructor que toma nombre y contraseña como parámetros
    public Usuariosprom(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getTipoUsuario() {
        return "Usuario Promedio";
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Contraseña: " + contraseña);  // No es recomendado mostrar la contraseña, esto es solo un ejemplo
        System.out.println("Tipo de Usuario: " + getTipoUsuario());
    }
}
