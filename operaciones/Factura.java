package operaciones;

import java.util.Date;

public class Factura {
    private String numeroFactura;
    private Date fecha;
    private String cliente; //aca el cliente puede ser el usuario?
    private double montoTotal;

    public Factura(String numeroFactura, Date fecha, String cliente, double montoTotal) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
    }

    public void mostrarFactura() {
        System.out.println("Número de Factura: " + numeroFactura);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente);
        System.out.println("Monto Total: $" + montoTotal);
    }
}

// Subclase para Facturas de Envíos Marítimos
class FacturaMaritima extends Factura {
    private String puertoOrigen;
    private String puertoDestino;

    public FacturaMaritima(String numeroFactura, Date fecha, String cliente, double montoTotal, String puertoOrigen, String puertoDestino) {
        super(numeroFactura, fecha, cliente, montoTotal);
        this.puertoOrigen = puertoOrigen;
        this.puertoDestino = puertoDestino;
    }

    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Tipo de Envío: Marítimo");
        System.out.println("Puerto de Origen: " + puertoOrigen);
        System.out.println("Puerto de Destino: " + puertoDestino);
    }
}

// Subclase para Facturas de Envíos Terrestres
class FacturaTerrestre extends Factura {
    private String origen;
    private String destino;

    public FacturaTerrestre(String numeroFactura, Date fecha, String cliente, double montoTotal, String origen, String destino) {
        super(numeroFactura, fecha, cliente, montoTotal);
        this.origen = origen;
        this.destino = destino;
    }

    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Tipo de Envío: Terrestre");
        System.out.println("Origen: " + origen);
        System.out.println("Destino: " + destino);
    }
}

// Subclase para Facturas de Envíos Aéreos
class FacturaAerea extends Factura {
    private String aeropuertoOrigen;
    private String aeropuertoDestino;

    public FacturaAerea(String numeroFactura, Date fecha, String cliente, double montoTotal, String aeropuertoOrigen, String aeropuertoDestino) {
        super(numeroFactura, fecha, cliente, montoTotal);
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
    }

    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Tipo de Envío: Aéreo");
        System.out.println("Aeropuerto de Origen: " + aeropuertoOrigen);
        System.out.println("Aeropuerto de Destino: " + aeropuertoDestino);
    }
}
