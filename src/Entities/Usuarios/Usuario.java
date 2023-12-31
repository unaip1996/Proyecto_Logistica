package Entities.Usuarios;

/**
 * @author Clemente Navarro
 * 
 * Clase abstracta Usuario
 */
import Entities.operaciones.Direccion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
public abstract class Usuario implements Autentificacion {

    @Id
    @GeneratedValue
    private Long id;

    public Usuario() {

    }
     
     protected String nick;
     protected String password;
     protected String type_user;
     protected String numberphone;
     protected String mail;
     private ArrayList<Direccion> direccion;

     // Aparte de los campos exigidos en el enunciado se añadiran dos constantes, que se usarán a lo largo de proyecto
     // Para identificar el tipo de usuario
     protected static final String ADMINTYPE = "1";
     protected static final String USERTYPE = "0";
     //Instanciaremos con Strings ya que, aunque hayan campos que sean números, por el momento no se tiene pensando hacer operaciónes
     //Con estos campos.
     protected List<String> userinfo;

     //Dejaremos definido el constructor de usuario de tal manerda de que solo haya que usar "super" en las clases hijas
     public Usuario(String nick, String password, String numberphone, String mail, String type_user){
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    //Este método servirá para mostrar toda la información de un usuario
     abstract List<String> getUserInfo();

     /**
      * Método para obtener el tipo de usuario (admin o promedio)
      *
      */
     public void getUserType(){

     };

     /**
      * Método para mostrar información del usuario (Historial de operaciones/facturación)
      *
      */
     abstract void showhistorial();


     
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
}

