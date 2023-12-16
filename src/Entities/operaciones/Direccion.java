package src.Entities.operaciones;
import src.Entities.Usuarios.Cliente;
public class Direccion {

    private String pais;
    private String provincia;
    private String ciudad;
    private String calle;
    private int numero;
    private String escalera;
    private int codigoPostal;

    private Cliente cliente;

    public Direccion(String pais, String provincia, String ciudad, String calle, int numero, String escalera, int codigoPostal, Cliente cliente ){
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.escalera = escalera;
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getEscalera() {
        return escalera;
    }
    public void setEscalera(String escalera) {
        this.escalera = escalera;
    }
    public int getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
