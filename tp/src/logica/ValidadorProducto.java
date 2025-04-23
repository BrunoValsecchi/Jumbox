package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.Producto;
import datos.Usuario;

public class ValidadorProducto {

	Producto VerificadorProd = new Producto();

	public boolean ValidarIngreso(String nombre, String descripcion, double precio, int id_producto, int id_categoria,
			int stock) {

		if (nombre.length() == 0 && descripcion.length() == 0 && id_producto >= 0 && id_categoria >= 0) {
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
			return false;
		} else {
			VerificadorProd.setNombre(nombre);
			VerificadorProd.setDescripcion(descripcion);
			VerificadorProd.setPrecio(precio);
			VerificadorProd.setId_producto(id_producto);
			VerificadorProd.setId_categoria(id_categoria);
			VerificadorProd.setStock(stock);
			if (VerificadorProd.guardarProd()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean ValidarEditar(String nombre, String descripcion, double precio, int id_producto, int id_categoria,
			int stock) {

		if (nombre.length() == 0 && descripcion.length() == 0 && precio >= 0 && id_producto >= 0 && id_categoria >= 0
				&& stock >= 0) {
			JOptionPane.showMessageDialog(null,
					"Debe completar todos los campos y el precio / stock no puede ser cero");
			return false;
		} else {
			VerificadorProd.setNombre(nombre);
			VerificadorProd.setDescripcion(descripcion);
			VerificadorProd.setPrecio(precio);
			VerificadorProd.setId_producto(id_producto);
			VerificadorProd.setId_categoria(id_categoria);
			VerificadorProd.setStock(stock);
			if (VerificadorProd.editarProd()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean ValidarEliminar(int id_producto) {

		if (id_producto >= 0) {
			JOptionPane.showMessageDialog(null, "dni vacio");
			return false;
		} else {
			VerificadorProd.setId_producto(id_producto);
			if (VerificadorProd.EliminarProd()) {
				return true;
			} else {
				return false;
			}
		}

	}

	public LinkedList<Producto> Mostrar() {

		return VerificadorProd.MostrarProd();
	}

}
