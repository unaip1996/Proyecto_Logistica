package Usuarios;

public class Admin extends Usuario {
    

    // Constructor que toma nombre y contraseña como parámetros
    public Admin(String nick, String password, String numberphone, String mail) {
        super(nick, password, ADMINTYPE, numberphone, mail);
        
    }

    
    public String getNick(){
        
    }

    
    public String getUserType() {
        return "Usuario Administrador";
    }

    
    public void showhistorial() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Contraseña: " + contraseña);  // Obiamente no mostrar la contraseña, esto es solo un ejemplo
        System.out.println("Tipo de Usuario: " + getTipoUsuario());
    }
}
