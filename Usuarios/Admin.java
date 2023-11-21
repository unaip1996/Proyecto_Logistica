package Usuarios;
/**
 * @authot Clemente Navarro
 * 
 * Clase abstracta Usuario
 */

import java.util.List;

public class Admin extends Usuario {
    

    // Constructor que toma nombre y contraseña como parámetros
    public Admin(String nick, String password, String numberphone, String mail) {
        super(nick, password, numberphone, mail, ADMINTYPE);
    }
    // Método para mostrar información del usuario (Historial de operaciones/facturación)
    @Override
    void showhistorial(){
        //Se usará la lógica necesaria paar acceder a la base de datos y mostrar el historial de operaciones/facturas
        
    };
    @Override
    List<String> getUserInfo(){
        userinfo.add(ADMINTYPE);
        return userinfo;
    }
    /*Métodos Gestion de usuarios
     * agregar usuarios: añade usuario a BD
     * eliminar usuarios: eliminar usuario a BD
     * modificar usuarios: modificar un campo del usuario
     * lista de usuarios: muestra una lista de usuarios
     * 
     * Todavía no se implentará estos métodos ya que será necesario implementar la Base de Datos primero
     */
    
   

    /*
     *Gestión de roles 
     * asignar Rol: asignar rol al usuario
     * quitar Rol: quita rol al usuario
     * lista de Roles: muestra todos los roles existentes
     * 
     *  Falta por implementar
    */

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
   public void validatefields() throws IllegalArgumentException {
        // Validar el campo 'nick'
        if (nick == null || nick.length() < 1 || nick.length() > 10) {
            throw new IllegalArgumentException("Error: El campo 'nick' debe tener entre 1 y 10 caracteres.");
        }

        // Validar el campo 'password'
        if (password == null || password.length() < 4 || password.length() > 8) {
            throw new IllegalArgumentException("Error: El campo 'password' debe tener entre 4 y 8 caracteres.");
        }
    }

    //Comprobción de las clases y métodos que se van añadiendo
    public static void main(String [] args){
        Admin admin1 = new Admin("Pablo", "1234","202122","pablo@gmail.com");
        Usuariosprom user1 = new Usuariosprom("Ppep", "1234","202122","pablo@gmail.com");

        System.out.println(admin1.getUserInfo());
        System.out.println(user1.getUserInfo());
        
    }

}
