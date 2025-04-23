package logica;

import java.util.ArrayList;

public class VentaSBD {
	private ArrayList<String> envioEntregado;
    private ArrayList<String> envioCancelado;

    public VentaSBD() {
        envioEntregado = new ArrayList<>();
        envioCancelado = new ArrayList<>();
    }
    public ArrayList<String> getEnviosEntregados() {
        return envioEntregado;
    }
	
    public void setEnvioEntregado(ArrayList<String> envioEntregado) {
			this.envioEntregado = envioEntregado;
		}
    
    public ArrayList<String> getEnvioEntregado() {
		return envioEntregado;
	}
	
    public void setEnvioCancelado(ArrayList<String> envioCancelado) {
		this.envioCancelado = envioCancelado;
	}
	
    public ArrayList<String> getEnvioCancelado() {
		return envioCancelado;
	}
	
	public ArrayList<String> getEnviosCancelados() {
        return envioCancelado;
    }
	
	 public void marcarComoEntregado(DistribucionSBD distribucionSBD, String compra) {
	        distribucionSBD.moverCompraAEntregados(compra);
	    }

	    public void marcarComoCancelado(DistribucionSBD distribucionSBD, String compra) {
	        distribucionSBD.moverCompraACancelados(compra);
	    }
}
