package Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario{
     
     protected String nick;
     protected String password;
     protected String type_user;
     protected String numberphone;
     protected String mail;
     // Aparte de los campos exigidos en el enunciado se añadiran dos constantes, que se usarán a lo largo de proyecto
     // Para identificar el tipo de usuario
     protected static final String ADMINTYPE = "1";
     protected static final String USERYPE = "0";
     //Instanciaremos con Strings ya que, aunque hayan campos que sean números, por el momento no se tiene pensando hacer operaciónes
     //Con estos campos.
     protected List<String> userinfo;

     //Dejaremos definido el constructor de usuario de tal manerda de que solo haya que usar "super" en las clases hijas
     public Usuario(String nick, String password, String type_user, String numberphone, String mail){
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
     //Este método servirá para mostrar toda la información de un usuario
     public List<String> getUserInfo(){
           return userinfo;
     }
     //Método pensado para que se use solo usuarios Admins.
     //En el caso de que sepamos el usuario u otro motivo, este método servirá para buscar un objeto específico
     public String getSpecificInfo(int x){
          try {
               // Verificar si el índice está dentro del rango
               if (x >= 0 && x < userinfo.size()) {
                   Object specificObject = userinfo.get(x);
   
                   // Verificar si el objeto en la posición x es un String
                   if (specificObject instanceof String) {
                       return (String) specificObject;
                   } else {
                       throw new ClassCastException("El elemento en la posición " + x + " no es un String.");
                   }
               } else {
                   throw new IndexOutOfBoundsException("Índice fuera de rango: " + x);
               }
           } catch (IndexOutOfBoundsException e) {
               // Manejar la excepción de índice fuera de rango
               return "Índice fuera de rango: " + x + ", "+ "Rango: " + ((Integer)userinfo.size()-1) ;
           } catch (ClassCastException e) {
               // Manejar la excepción de tipo incorrecto
               return "El elemento en la posición " + x + " no es una cadena.";
           }
     }
     //Este método servirá para asegurarnos de los requerimientos exigidos en el enunciado
     public void validarCampos() throws IllegalArgumentException {
          // Validar el campo 'nick'
          if (nick == null || nick.length() < 1 || nick.length() > 10) {
              throw new IllegalArgumentException("Error: El campo 'nick' debe tener entre 1 y 10 caracteres.");
          }
  
          // Validar el campo 'password'
          if (password == null || password.length() < 4 || password.length() > 8) {
              throw new IllegalArgumentException("Error: El campo 'password' debe tener entre 4 y 8 caracteres.");
          }
      }
     // Método para obtener el tipo de usuario (admin o promedio)
     public void getUserType(){

     };
     
     // Método para mostrar información del usuario (Historial de operaciones/facturación)
      void showhistorial(){};
     
     public static void main(String [] args){
          Usuario user1 = new Usuario("Pacon`t", "1234","1","202122","paco123@gmail.com");
          try {
               user1.validarCampos();
               System.out.println("\n" + "Los campos son válidos. Puedes continuar con el registro." + "\n");
               System.out.println("La información que se añadirá a la base de datos será la siguiente: " + "\n" + user1.getUserInfo()+ "\n" );
               
               // Lógica adicional para registrar al usuario en la base de datos, etc.
           } catch (IllegalArgumentException e) {
               System.out.println("Error: " + e.getMessage());
               System.out.println("Corrige los campos antes de continuar.");
           }
              
     }
}

