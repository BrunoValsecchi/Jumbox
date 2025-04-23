package iu;

import javax.swing.JOptionPane;

import datos.Producto;

import logica.ValidadorProducto;

public class Main {

	public static void main(String[] args) {

		String[] Opciones = { "Iniciar sesion", "Salir" };

		int op = 0;

		do {

			op = JOptionPane.showOptionDialog(null, "JUMBOX", null, op, op, null, Opciones, Opciones[0]);

			switch (op) {
			case 0:

				/*InicioSesion interfazInicio = new InicioSesion();

				interfazInicio.Inicio();*/

				break;

			case 1:

				JOptionPane.showMessageDialog(null, "Elegiste salir");

				break;

			default:
				break;
			}

		} while (op != 1);

	}
}
