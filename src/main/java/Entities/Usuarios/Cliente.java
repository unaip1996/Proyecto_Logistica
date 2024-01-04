package Entities.Usuarios;
/**
 * @author Clemente Navarro
 * 
 * Clase abstracta Usuario
 */
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;
@Table(name = "Usuario")
public class Cliente extends Usuario{

    /**
     * Constructor que toma nombre y contraseña como parámetros
     *
     * @param nick
     * @param password
     * @param numberphone
     * @param mail
     */
    public Cliente(String nick, String password, String numberphone, String mail) {
        super(nick, password, numberphone, mail, USERTYPE);
    }

    /**
     * Constructor para Hibernate
     *
     * @param id
     * @param nick
     * @param password
     * @param passwordSalt
     * @param type_user
     * @param numberphone
     * @param mail
     * @param ultimoLogin
     */
    public Cliente(int id, String nick, String password, String passwordSalt, int type_user, String numberphone, String mail, LocalDateTime ultimoLogin) {
        super(id, nick, password, passwordSalt, type_user, numberphone, mail, ultimoLogin);
    }

    @Override
    List<String> getUserInfo(){
        return userinfo;
    }
    @Override
    void showhistorial(){
    }
}
