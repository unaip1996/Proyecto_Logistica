package Entities.operaciones;

import Entities.Usuarios.Cliente;
import Util.SerializableEntity;
import app.EntityManager;
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
    private int numero;
    private String calle;
    private String esc;
    private int piso;
    private Character puerta;
    private int codigoPostal;

    private String text;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Cliente cliente;


    public Direccion(int id, String pais, String provincia, String ciudad, int numero, String calle, String esc, int piso, Character puerta, int codigoPostal, Integer clienteId) {
        this.id = id;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.numero = numero;
        this.calle = calle;
        this.esc = esc;
        this.piso = piso;
        this.puerta = puerta;
        this.codigoPostal = codigoPostal;

        this.text = pais
                + ", " + provincia
                + ", " + ciudad
                + ", C/" + calle
                + ", Nº " + numero
                + ", Esc. " + esc
                + ", " + piso + "º"
                + puerta
                + ", CP: " + codigoPostal
                ;

        if (clienteId != null) {
            EntityManager em = new EntityManager();
            this.cliente = (Cliente) em.selectOne(Cliente.class, "WHERE id=?1", new String[]{clienteId.toString()});
        }
    }

    public Direccion() {

    }

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

    public String getEsc() {
        return esc;
    }

    public void setEsc(String esc) {
        this.esc = esc;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Character getPuerta() {
        return puerta;
    }

    public void setPuerta(Character puerta) {
        this.puerta = puerta;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
