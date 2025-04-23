package iu;

import javax.swing.JOptionPane;

import datos.Usuario;
import logica.Validador;

public class PantallaUsuario {

	public void MenuUsuario() {

		Validador interfaz = new Validador();
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
				String contrasenia = JOptionPane.showInputDialog("Ingrese contrasenia");
				String dni = JOptionPane.showInputDialog("Ingrese dni");
				int rol = Integer.parseInt(JOptionPane.showInputDialog("Ingrese rol"));
				if (interfaz.ValidarIngreso(nombre, apellido, mail, contrasenia, dni, rol)) {
					JOptionPane.showMessageDialog(null, "Se pudo guardar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo guardar");
				}
				break;

			case "Mostrar existente":
				String registros = "Lista de usuarios";
				if (interfaz.Mostrar() == null) {
					JOptionPane.showMessageDialog(null, "No hay usuarios");
				} else {

					for (Usuario usuario : interfaz.Mostrar()) {
						registros = registros + "\n" + usuario;
					}
					JOptionPane.showMessageDialog(null, registros);
				}
				break;

			case "Editar":
				dni = JOptionPane.showInputDialog("Ingrese dni del usuario a editar");
				nombre = JOptionPane.showInputDialog("Ingrese nombre");
				apellido = JOptionPane.showInputDialog("Ingrese apellido");
				mail = JOptionPane.showInputDialog("Ingrese mail");
				contrasenia = JOptionPane.showInputDialog("Ingrese contrasenia");
				rol = Integer.parseInt(JOptionPane.showInputDialog("Ingrese rol"));
				if (interfaz.ValidarEditar(nombre, apellido, mail, contrasenia, dni, rol)) {
					JOptionPane.showMessageDialog(null, "Se pudo editar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo editar");
				}
				break;

			case "Eliminar":
				dni = JOptionPane.showInputDialog("Ingrese dni del usuario a eliminar");

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
