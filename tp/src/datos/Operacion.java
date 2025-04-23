package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import datos.Conexion;
import datos.Producto;

public class Operacion {

    private int id_operacion;
    private int precio_total;
    private int cantidad_producto;
    
    private String estado;
    private String dni;
    private List<Producto> productos;


	public Operacion(int id_operacion, int precio_total, int cantidad_producto, String estado,
			String dni) {
		
		this.id_operacion = id_operacion;
		this.precio_total = precio_total;
		this.cantidad_producto = cantidad_producto;
		
		this.estado = estado;
		this.dni = dni;
	}

	public Operacion(String dni) {
        this.dni = dni;
        this.productos = new ArrayList<>();
    }  
       
    public Operacion() {
		
	}

	public int getId_operacion() {
		return id_operacion;
	}

	public void setId_operacion(int id_operacion) {
		this.id_operacion = id_operacion;
	}

	public int getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(int precio_total) {
		this.precio_total = precio_total;
	}


	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getId_usuario() {
		return dni;
	}

	public void setId_usuario(String id_usuario) {
		this.dni = id_usuario;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
	
	public void calcularPrecioTotal(int stockActual) {
	    cantidad_producto = productos.size();
	    precio_total = 0; 

	    for (Producto producto : productos) {
	        precio_total += producto.getPrecio() * stockActual;
	    }	
	    JOptionPane.showMessageDialog(null, precio_total);
	}
	
	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;

    public void guardarOperacion() {
    	

        try (Connection con = new Conexion().conectar()) {
            String sql = "INSERT INTO operacion (id_operacion, precio_total, cantidad_producto, estado, id_usuario) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            	
            	/* int id_operacion;
                try (var generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        id_operacion = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("No se pudo obtener el ID de la operación generada.");
                    }
                } */     
       
            	estado = "Pendiente";
            	dni = "1";
            	
            	stmt.setInt(1, id_operacion);
                stmt.setInt(2, precio_total);
                stmt.setInt(3, cantidad_producto);
                stmt.setString(4, estado);
                stmt.setString(5, dni);
                
                stmt.executeUpdate();

                

               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public LinkedList<Operacion> MostrarOp() {
		LinkedList<Operacion> operaciones = new LinkedList<>();
		String sql = "SELECT * FROM `operacion` where estado='Pendiente'";

		String [] datos = new String[5];
		try {
			
			stmt = conexion.prepareStatement(sql);

			ResultSet resultados = stmt.executeQuery();
			while (resultados.next()) {

				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);
				
				
				operaciones.add(new Operacion(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), datos[3], datos[4]));
			}
				if (operaciones.isEmpty()) {
					
					return null;
				} else {
					return operaciones;
				}

        } catch (Exception e) {
            System.out.println("Error al mostrar");
            return null;
        }
		

	}
    
    public LinkedList<Operacion> MostrarOp2() {
		LinkedList<Operacion> operaciones = new LinkedList<>();
		String sql = "SELECT * FROM `operacion` where estado='Entregado'";

		String [] datos = new String[5];
		try {
			
			stmt = conexion.prepareStatement(sql);

			ResultSet resultados = stmt.executeQuery();
			while (resultados.next()) {

				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);
				
				
				operaciones.add(new Operacion(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), datos[3], datos[4]));
			}
				if (operaciones.isEmpty()) {
					
					return null;
				} else {
					return operaciones;
				}

        } catch (Exception e) {
            System.out.println("Error al mostrar");
            return null;
        }
		

	}
    
    public LinkedList<Operacion> MostrarOp3() {
		LinkedList<Operacion> operaciones = new LinkedList<>();
		String sql = "SELECT * FROM `operacion` where estado='Cancelado'";

		String [] datos = new String[5];
		try {
			
			stmt = conexion.prepareStatement(sql);

			ResultSet resultados = stmt.executeQuery();
			while (resultados.next()) {

				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);
				
				
				operaciones.add(new Operacion(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), datos[3], datos[4]));
			}
				if (operaciones.isEmpty()) {
					
					return null;
				} else {
					return operaciones;
				}

        } catch (Exception e) {
            System.out.println("Error al mostrar");
            return null;
        }
		
	}
    
    public boolean entregar(int id_operacion) {

		String sql = "UPDATE `usuario` SET `estado`=? WHERE id_operacion = ?";
		try {

			stmt = conexion.prepareStatement(sql);
			
			estado = "Entregado";

			stmt.setString(1, estado);
			stmt.setInt(2, id_operacion);
			
			stmt.executeUpdate();
			conexion.close();

			return true;

		} catch (Exception e) {
			System.out.println("Error al editar");
			return false;
		}

	}
    
    public boolean cancelar(int id_operacion) {

		String sql = "UPDATE `operacion` SET `estado`=? WHERE id_operacion = ?";
		try {

			stmt = conexion.prepareStatement(sql);

			estado = "Cancelado";
			
			stmt.setString(1, estado);
			stmt.setInt(2, id_operacion);
			
			stmt.executeUpdate();
			conexion.close();

			return true;

		} catch (Exception e) {
			System.out.println("Error al editar");
			return false;
		}

	}

}


