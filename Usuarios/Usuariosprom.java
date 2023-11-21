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
    //getters
    private String getNick(){
        return this.nick;
    }
    private String getPassword(){
        return this.password;
    }
    private String getNumberphone(){
        return this.numberphone;
    }
    private String getMail(){
        return this.mail;
    }
    //setters
    private void setNick(String elem){
        this.nick = elem;
    }
    private void setPassword(String elem){
        this.password = elem;
    }
    private void setNumberphone(String elem){
        this.numberphone= elem;
    }
    private void setMail(String elem){
        this.mail= elem;
    }
}
