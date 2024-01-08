package Entities.operaciones;

import Entities.Usuarios.Cliente;
import Util.SerializableEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "Direccion")
public class Direccion implements SerializableEntity {

    @Id
    @GeneratedValue
    private int id;
    private String pais;
    private String provincia;
    private String ciudad;
    private String calle;
    private int numero;
    private String escalera;
    private int codigoPostal;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Cliente cliente;



    public int getId() {
        return id;
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
