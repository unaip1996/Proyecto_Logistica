package Usuarios;
/**
 * @authot Clemente Navarro
 * 
 * Clase abstracta Usuario
 */
import java.util.List;
public class Usuariosprom extends Usuario {
    


     // Constructor que toma nombre y contraseña como parámetros
     public Usuariosprom(String nick, String password, String numberphone, String mail) {
        super(nick, password, numberphone, mail, USERTYPE);
    }
    @Override
    List<String> getUserInfo(){
        return userinfo;
    }
    @Override
    void showhistorial(){
    }
   
}
