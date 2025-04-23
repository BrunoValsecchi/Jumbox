package iu;

import javax.swing.JOptionPane;

import logica.*;

public class PantallaVenta {

	public void Menu() {

		String[] Opciones = { "Compra", "Ingresar cliente", "Salir" };

		int op = 0;

		do {

			op = JOptionPane.showOptionDialog(null, "Sector ventas", null, op, op, null, Opciones, Opciones[0]);

			switch (op) {
			case 0:

				MainSBD.main(Opciones);

				break;

			case 1:

				PantallaCliente interfazCliente = new PantallaCliente();
				
				interfazCliente.MenuCliente();

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
