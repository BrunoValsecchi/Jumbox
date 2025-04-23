package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Usuario {

	private String nombre, apellido, mail, dni, contrasenia;
	private int rol;

	public Usuario(String nombre, String apellido, String mail, String dni, String contrasenia, int rol) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.dni = dni;
		this.contrasenia = contrasenia;
		this.rol = rol;

	}

	public Usuario() {

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public PreparedStatement getStmt() {
		return stmt;
	}

	public void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", dni=" + dni
				+ ", contrasenia=" + contrasenia + ", rol=" + rol + "]";
	}

	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;

	public boolean guardar() {

		String sql = "INSERT INTO `usuario`(`nombre`, `apellido`, `mail`, `dni`, `contrasenia`, `id_rol`) VALUES (?,?,?,?,?,?)";
		try {

			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getApellido());
			stmt.setString(3, this.getMail());
			stmt.setString(4, this.getDni());
			stmt.setString(5, this.getContrasenia());
			stmt.setInt(6, this.getRol());
			stmt.executeUpdate();
			conexion.close();
			return true;

		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}

	}

	public boolean editar() {

		String sql = "UPDATE `usuario` SET `nombre`=?,`apellido`=?,`mail`=?, `contrasenia`=?, `id_rol`=? WHERE dni = ?";
		try {

			stmt = conexion.prepareStatement(sql);

			stmt.setString(1, this.getNombre());
			stmt.setString(2, this.getApellido());
			stmt.setString(3, this.getMail());
			stmt.setString(4, this.getContrasenia());
			stmt.setInt(5, this.getRol());
			stmt.setString(6, this.getDni());
			stmt.executeUpdate();
			conexion.close();

			return true;

		} catch (Exception e) {
			System.out.println("Error al editar");
			return false;
		}

	}

	public boolean Eliminar() {

		String sql = "DELETE FROM `usuario` WHERE dni=?";
		try {

			stmt = conexion.prepareStatement(sql);

			stmt.setString(1, this.getDni());
			stmt.executeUpdate();

			conexion.close();

			return true;

		} catch (Exception e) {
			System.out.println("Error al eliminar");
			return false;
		}

	}

	public LinkedList<Usuario> Mostrar() {
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		String sql = "SELECT * FROM `usuario`";

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

				usuarios.add(new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], Integer.parseInt(datos[5])));

			}
			if (usuarios.isEmpty()) {

				return null;
			} else {

				return usuarios;
			}

		} catch (Exception e) {
			System.out.println("Error al mostrar");
			return null;
		}

	}

}
