package iu;

import javax.swing.JOptionPane;

public class PantallaAdmin {

	public void MenuAdmin() {
		String[] Opciones = { "Administrar usuarios", "Administrar productos", "Salir" };

		int op = 0;

		do {

			op = JOptionPane.showOptionDialog(null, "Administrador", null, op, op, null, Opciones, Opciones[0]);

			switch (op) {
			case 0:

				PantallaUsuario interfazUsuario = new PantallaUsuario();

				interfazUsuario.MenuUsuario();

				break;

			case 1:

				PantallaProducto interfazProducto = new PantallaProducto();

				interfazProducto.Producto();

				break;

			case 2:

				JOptionPane.showMessageDialog(null, "Elegiste salir");

				break;

			default:
				break;
			}

		} while (op != 2);
	}
}
