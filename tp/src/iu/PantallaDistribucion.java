package iu;

import javax.swing.JOptionPane;

public class PantallaDistribucion {

	public void MenuDistribucion() {

		String[] Opciones = { "Preparar pedido", "Actualizar pedido", "Salir" };

		int op = 0;

		do {

			op = JOptionPane.showOptionDialog(null, "Sector distribucion", null, op, op, null, Opciones, Opciones[0]);

			switch (op) {
			case 0:

				JOptionPane.showMessageDialog(null, "Preparar pedido");

				break;

			case 1:

				JOptionPane.showMessageDialog(null, "Actualizar estado del pedido");

				break;

			case 2:

				JOptionPane.showMessageDialog(null, "elegiste salir");

				break;

			default:
				break;
			}

		} while (op != 2);
	}

}
