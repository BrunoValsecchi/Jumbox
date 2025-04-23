package logica;

import java.util.ArrayList;
import java.util.Date;

public class DistribucionSBD {
	
	private Date fechaEnvio;
    private ArrayList<String> compras; 
    private ArrayList<String> comprasEntregadas;
    private ArrayList<String> comprasCanceladas;
    
    public DistribucionSBD() {
        this.fechaEnvio = fechaEnvio;
        compras = new ArrayList<>();
        comprasEntregadas = new ArrayList<>();
        comprasCanceladas = new ArrayList<>();
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public void agregarCompra(String informacionCompra) {
    	compras.add(informacionCompra); 
    }

    public ArrayList<String> getCompras() {
        return compras;
    }
    
    public void moverCompraAEntregados(String informacionCompra) {
        if (compras.contains(informacionCompra)) {
        	compras.remove(informacionCompra);
            comprasEntregadas.add(informacionCompra);
        }
    }

    public void moverCompraACancelados(String informacionCompra) {
        if (compras.contains(informacionCompra)) {
        	compras.remove(informacionCompra);
            comprasCanceladas.add(informacionCompra);
        }
    }
}
