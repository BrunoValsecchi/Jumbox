package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.Usuario;

public class Validador {
	
	Usuario Verificador = new Usuario();

	public boolean ValidarIngreso(String nombre, String apellido, String mail, String dni, String contrasenia, int rol) {

		if (nombre.length() == 0 && apellido.length() == 0 && mail.length() == 0 && dni.length() == 0
				&& contrasenia.length() == 0 && rol <= 0) {
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
			return false;
		} else {
			Verificador.setNombre(nombre);
			Verificador.setApellido(apellido);
			Verificador.setMail(mail);
			Verificador.setDni(dni);
			Verificador.setContrasenia(contrasenia);
			Verificador.setRol(rol);
			if (Verificador.guardar()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean ValidarEditar(String nombre, String apellido, String mail, String dni, String contrasenia, int rol) {

		if (nombre.length() == 0 && apellido.length() == 0 && mail.length() == 0 && dni.length() == 0
				&& contrasenia.length() == 0 && rol <= 0) {
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
			return false;
		} else {
			Verificador.setNombre(nombre);
			Verificador.setApellido(apellido);
			Verificador.setMail(mail);
			Verificador.setDni(dni);
			Verificador.setContrasenia(contrasenia);
			Verificador.setRol(rol);
			if (Verificador.editar()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean ValidarEliminar(String dni) {

		if (dni.length() == 0) {
			JOptionPane.showMessageDialog(null, "Debe completar con un dni valido");
			return false;
		} else {
			Verificador.setDni(dni);
			if (Verificador.Eliminar()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public LinkedList<Usuario> Mostrar() {

		return Verificador.Mostrar();
	}

	public Usuario IniciarSesion(String dni) {

		if (Verificador.Mostrar() == null) {
			JOptionPane.showMessageDialog(null, "No hay personas");
			return null;
			

		} else {

			for (Usuario usuario : Verificador.Mostrar()) {

				if (dni.equalsIgnoreCase(usuario.getDni()))
					return usuario;

					
			}
		}
		return null;
		
	}
	

	public boolean ValidarCaracteres(char[] cs) {
			
		if (cs.length != 0) {
			return true;
		} else {
			return false;
		}
	}
}
