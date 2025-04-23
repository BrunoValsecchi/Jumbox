package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Producto {

	private String nombre, descripcion;
	private double precio;
	private int id_producto, id_categoria, stock;

	public Producto() {
	}

	public Producto( int id_producto,String nombre, double precio,String descripcion,  int id_categoria, int stock) {
		
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.precio = precio;		
		this.descripcion = descripcion;
		this.id_categoria = id_categoria;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;

	 public boolean guardarProd() {

	        String sql = "INSERT INTO `producto`(`id_producto`, `nombre`, `precio`, `descripcion`, `id_categoria`, `stock`) VALUES (?,?,?,?,?,?)";

	        try {
	            stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, this.getId_producto());
	            stmt.setString(2, this.getNombre());
	            stmt.setDouble(3, this.getPrecio());
	            stmt.setString(4, this.getDescripcion());
	            stmt.setInt(5, this.getId_categoria());
	            stmt.setInt(6, this.getStock());
	            stmt.executeUpdate();
	            return true;
	        } catch (Exception e) {
	            System.out.println("Error al guardar");
	            return false;
	        }
	    }

	 public boolean editarProd() {

		    String sql = "UPDATE `producto` SET `nombre`=?, `precio`=?,`descripcion`=?,  `id_categoria`=?, `stock`=? WHERE `id_producto`=?";

		    try {
		        stmt = conexion.prepareStatement(sql);
		        
		        stmt.setInt(1, this.getId_producto());
		        stmt.setString(2, this.getNombre());		       
		        stmt.setDouble(3, this.getPrecio());
		        stmt.setString(4, this.getDescripcion());
		        stmt.setInt(5, this.getId_categoria());
		        stmt.setInt(6, this.getStock());
		        
		        stmt.executeUpdate();
				conexion.close();
		        return true;
		    } catch (Exception e) {
				System.out.println("Error al editar");
				return false;
			}
		    
		    
		}
	 public boolean EliminarProd() {
		    String sql = "DELETE FROM `producto` WHERE id_producto=?";
		    try {
		        stmt = conexion.prepareStatement(sql);
		        stmt.setInt(1, this.getId_producto());
		        stmt.executeUpdate();
		        return true;
		    } catch (Exception e) {
		        System.out.println("Error al eliminar");
		        return false;
		    }
		}
	
	 public boolean reducirStock(int cantidad) {
	        if (cantidad >= 0 && cantidad <= this.stock) {
	            this.stock -= cantidad;

	            // Actualiza el stock en la base de datos
	            String sql = "UPDATE `producto` SET `stock`=? WHERE `id_producto`=?";
	            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	                stmt.setInt(1, this.stock);
	                stmt.setInt(2, this.id_producto);
	                stmt.executeUpdate();
	                return true;
	            } catch (Exception e) {
	                System.out.println("Error al actualizar el stock: " + e.getMessage());
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }
	 public boolean aumentarStock(int cantidad) {
	        if (cantidad >= 0) {
	            this.stock += cantidad;

	            // Actualiza el stock en la base de datos
	            String sql = "UPDATE `producto` SET `stock`=? WHERE `id_producto`=?";
	            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	                stmt.setInt(1, this.stock);
	                stmt.setInt(2, this.id_producto);
	                stmt.executeUpdate();
	                return true;
	            } catch (Exception e) {
	                System.out.println("Error al incrementar el stock: " + e.getMessage());
	                return false;
	            }
	        } else {
	            System.out.println("Cantidad no válida");
	            return false;
	        }
	    }

	 
	    
	  public LinkedList<Producto> MostrarProd() {
	        LinkedList<Producto> productos = new LinkedList<>();
	        String sql = "SELECT * FROM `producto`";

	        try {
	            stmt = conexion.prepareStatement(sql);
	            ResultSet resultados = stmt.executeQuery();
	            while (resultados.next()) {
	                int id_producto = resultados.getInt("id_producto");
	                String nombre = resultados.getString("nombre");
	                double precio = resultados.getDouble("precio");
	                String descripcion = resultados.getString("descripcion");
	                int id_categoria = resultados.getInt("id_categoria");
	                int stock = resultados.getInt("stock");

	                productos.add(new Producto(id_producto, nombre, precio, descripcion, id_categoria, stock));
	            }
	            return productos;

	        } catch (Exception e) {
	            System.out.println("Error al mostrar");
	            return null;
	        }
	    }

}
