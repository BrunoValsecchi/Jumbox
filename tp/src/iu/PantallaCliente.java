package iu;

import javax.swing.JOptionPane;

import datos.Cliente;
import logica.ValidadorCliente;

public class PantallaCliente {

	public void MenuCliente() {
		
		ValidadorCliente interfaz = new ValidadorCliente();
		String[] opciones = {

				"Ingresar nuevo registro", "Mostrar existente", "Editar", "Eliminar", "Salir" };

		String opcion = "";
		do {

			opcion = (String) JOptionPane.showInputDialog(null, "Elija la accion a realizar", null, 0, null, opciones,
					opciones[0]);
			switch (opcion) {

			case "Ingresar nuevo registro":
				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				String apellido = JOptionPane.showInputDialog("Ingrese apellido");
				String mail = JOptionPane.showInputDialog("Ingrese mail");
				String direccion = JOptionPane.showInputDialog("Ingrese direccion");
				int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono"));
				int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni"));
				if (interfaz.ValidarIngreso(nombre, apellido, mail, telefono, direccion, dni)) {
					JOptionPane.showMessageDialog(null, "Se pudo guardar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo guardar");
				}
				break;

			case "Mostrar existente":
				String registros = "Lista de clientes";
				if (interfaz.Mostrar() == null) {
					JOptionPane.showMessageDialog(null, "No hay clientes");
				} else {

					for (Cliente cliente : interfaz.Mostrar()) {
						registros = registros + "\n" + cliente;
					}
					JOptionPane.showMessageDialog(null, registros);
				}
				break;

			case "Editar":
				dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni del cliente a editar"));
				nombre = JOptionPane.showInputDialog("Ingrese nombre");
				apellido = JOptionPane.showInputDialog("Ingrese apellido");
				mail = JOptionPane.showInputDialog("Ingrese mail");
				direccion = JOptionPane.showInputDialog("Ingrese direccion");
				telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono"));
				if (interfaz.ValidarEditar(nombre, apellido, mail, telefono, direccion, dni)) {
					JOptionPane.showMessageDialog(null, "Se pudo editar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo editar");
				}
				break;

			case "Eliminar":
				dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni del cliente a eliminar"));

				if (interfaz.ValidarEliminar(dni)) {
					JOptionPane.showMessageDialog(null, "Se pudo Eliminar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo Eliminar");
				}

				break;

			default:
				break;
			}

		} while (!opcion.equals("Salir"));
	}
	
}
