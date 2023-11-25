package Usuarios;

public interface Autentificación {
    //hay que implementar la lógica para averiguar si los parametros en login existe en la base datos 
    void login(String x, String y);
    // En este caso sería simplemente añadirlo a la base de datos para que después pueda hacer el login
    void register(String x, String y);
}
