package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Distribucion {

	private int id_distribucion;
	private Date fecha_envio;
	private String entregado;
	private int id_operacion;
	
	public Distribucion(int id_distribucion, Date fecha_envio, String entregado, int id_operacion) {
		
		this.id_distribucion = id_distribucion;
		this.fecha_envio = fecha_envio;
		this.entregado = entregado;
		this.id_operacion = id_operacion;
	}

	public Distribucion() {
		
	}

	public int getId_distribucion() {
		return id_distribucion;
	}

	public void setId_distribucion(int id_distribucion) {
		this.id_distribucion = id_distribucion;
	}

	public Date getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public String getEntregado() {
		return entregado;
	}

	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	public int getId_operacion() {
		return id_operacion;
	}

	public void setId_operacion(int id_operacion) {
		this.id_operacion = id_operacion;
	}

	 public void guardarDistribucion() {
	    	

	        try (Connection con = new Conexion().conectar()) {
	            String sql = "INSERT INTO operacion (fecha_envio, entregado, id_operacion) VALUES (, ?, ?, ?";
	            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	                stmt.setDate(1, fecha_envio);
	                stmt.setString(2, entregado);
	                stmt.setInt(3, id_operacion);
	                stmt.executeUpdate();
	                
	                int id_distribucion;
	                try (var generatedKeys = stmt.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        id_distribucion = generatedKeys.getInt(1);
	                    } else {
	                        throw new SQLException("No se pudo obtener el ID de la distribucion generada.");
	                    }
	                }

	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	
}
