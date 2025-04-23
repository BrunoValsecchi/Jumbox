package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Cliente {

	private String nombre, apellido, mail;
	private int telefono;
	private String direccion;
	private int dni;

	public Cliente(String nombre, String apellido, String mail, int telefono, String direccion, int dni) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.direccion = direccion;
		this.dni = dni;
	}

	public Cliente() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", dni=" + dni + "]";
	}

	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;

	public boolean guardar() {

		String sql = "INSERT INTO `cliente`(`nombre`, `apellido`, `mail`, `telefono`, `direccion`, `dni`) VALUES (?,?,?,?,?,?)";
		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getApellido());
			stmt.setString(3, this.getMail());
			stmt.setInt(4, this.getTelefono());
			stmt.setString(5, this.getDireccion());
			stmt.setInt(6, this.getDni());
			stmt.executeUpdate();
			conexion.close();
			return true;

		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}

	}

	public boolean editar() {

		String sql = "UPDATE `cliente` SET `nombre`=?,`apellido`=?,`mail`=?, `telefono`=?, `direccion`=? WHERE dni = ?";
		try {

			stmt = conexion.prepareStatement(sql);

			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getApellido());
			stmt.setString(3, this.getMail());
			stmt.setInt(4, this.getTelefono());
			stmt.setString(5, this.getDireccion());
			stmt.setInt(6, this.getDni());
			stmt.executeUpdate();
			conexion.close();

			return true;

		} catch (Exception e) {
			System.out.println("Error al editar");
			return false;
		}

	}

	public boolean Eliminar() {

		String sql = "DELETE FROM `cliente` WHERE dni=?";
		try {

			stmt = conexion.prepareStatement(sql);

			stmt.setInt(1, this.getDni());
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println("Error al eliminar");
			return false;
		}

	}

	public LinkedList<Cliente> Mostrar() {
		LinkedList<Cliente> clientes = new LinkedList<Cliente>();
		String sql = "SELECT * FROM `cliente`";

		String[] datos = new String[6];
		try {

			stmt = conexion.prepareStatement(sql);

			ResultSet resultados = stmt.executeQuery();
			while (resultados.next()) {

				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);
				datos[5] = resultados.getString(6);

				clientes.add(new Cliente(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], 
						Integer.parseInt(datos[5])));
			}
			if (clientes.isEmpty()) {

				return null;
			} else {

				return clientes;
			}

		} catch (Exception e) {
			System.out.println("Error al mostrar");
			return null;
		}
	}
}
