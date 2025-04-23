package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.Cliente;

public class ValidadorCliente {

	Cliente VerificadorCliente = new Cliente();

	public boolean ValidarIngreso(String nombre, String apellido, String mail, int telefono, String direccion, int dni) {

		if (nombre.length() == 0 && apellido.length() == 0 && mail.length() == 0
				&& direccion.length() == 0 && telefono >= 0 && dni >= 0) {
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
			return false;
		} else {
			VerificadorCliente.setNombre(nombre);
			VerificadorCliente.setApellido(apellido);
			VerificadorCliente.setMail(mail);
			VerificadorCliente.setTelefono(telefono);
			VerificadorCliente.setDireccion(direccion);
			VerificadorCliente.setDni(dni);
			
			if (VerificadorCliente.guardar()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean ValidarEditar(String nombre, String apellido, String mail, int telefono, String direccion, int dni) {

		if (nombre.length() == 0 && apellido.length() == 0 && mail.length() == 0
				&& direccion.length() == 0 && telefono >= 0 && dni >= 0) {
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
			return false;
		} else {
			VerificadorCliente.setNombre(nombre);
			VerificadorCliente.setApellido(apellido);
			VerificadorCliente.setMail(mail);
			VerificadorCliente.setTelefono(telefono);
			VerificadorCliente.setDireccion(direccion);
			VerificadorCliente.setDni(dni);
			if (VerificadorCliente.editar()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean ValidarEliminar(int dni) {

		if (dni >= 0) {
			JOptionPane.showMessageDialog(null, "Debe completar con un dni valido");
			return false;
		} else {
			VerificadorCliente.setDni(dni);
			if (VerificadorCliente.Eliminar()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public LinkedList<Cliente> Mostrar() {

		return VerificadorCliente.Mostrar();
	}
	
}
