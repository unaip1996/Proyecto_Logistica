package Entities.Usuarios;

/**
 * @author Clemente Navarro
 * 
 * Clase abstracta Usuario
 */

import Entities.operaciones.Direccion;
import Util.SerializableEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "Usuario")
public class Usuario implements Autentificacion, SerializableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
     
     protected String nick;
     protected String password;
     protected String passwordSalt;
     protected int type_user;
     protected String numberphone;
     protected String mail;
     protected LocalDateTime ultimoLogin;
     private ArrayList<Direccion> direccion;

     // Aparte de los campos exigidos en el enunciado se añadiran dos constantes, que se usarán a lo largo de proyecto
     // Para identificar el tipo de usuario
     public static final int ADMINTYPE = 1;
    public static final int USERTYPE = 0;
     //Instanciaremos con Strings ya que, aunque hayan campos que sean números, por el momento no se tiene pensando hacer operaciónes
     //Con estos campos.
     protected List<String> userinfo;

    public Usuario() {

    }

     //Dejaremos definido el constructor de usuario de tal manera de que solo haya que usar "super" en las clases hijas
     public Usuario(String nick, String password, String numberphone, String mail, int type_user){
          this.nick = nick;
          this.password = password;
          this.type_user = type_user;
          this.numberphone = numberphone;
          this.mail = mail;
          //Crearemos una lista, por el momento servirá para facilitar la obtención de los datos de los usuarios
          //Por el momento no se añade el tipo de usuario a userinfo puesto que más adelante los usuarios promedios también puedan
          //Ver su información, en caso de ser innecesario se modificará la variable.
          userinfo = new ArrayList<>(Arrays.asList(this.nick, this.password, this.numberphone, this.mail));          
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
    public Usuario(int id, String nick, String password, String passwordSalt, int type_user, String numberphone, String mail, LocalDateTime ultimoLogin) {
        this.id = id;
        this.nick = nick;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.type_user = type_user;
        this.numberphone = numberphone;
        this.mail = mail;
        this.ultimoLogin = ultimoLogin;
    }

    public int getId() {
        return id;
    }

     /**
      * Método para obtener el tipo de usuario (admin o promedio)
      *
      */
     public void getUserType(){

     };


     
      /*
      * Métodos provenientes de la interfaz
      */
      @Override
      public void login(String nick, String password){
          this.nick = nick;
          this.password = password;
          /*
           * Más allá de esto hay que implementar la lógica para averiguar si existe en la base datos 
           */
      }
      @Override
      public void register(String nick, String password){
          /*
           * En este caso sería simplemente añadirlo a la base de datos para que después pueda hacer el login
           */
      }

    public ArrayList<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<Direccion> direccion) {
        this.direccion = direccion;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public int getType_user() {
        return type_user;
    }

    public void setType_user(int type_user) {
        this.type_user = type_user;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public List<String> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(List<String> userinfo) {
        this.userinfo = userinfo;
    }
}

