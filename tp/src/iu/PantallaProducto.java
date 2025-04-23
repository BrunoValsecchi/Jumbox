package iu;

import javax.swing.JOptionPane;

import logica.ValidadorProducto;
import datos.Producto;

public class PantallaProducto {

	public void Producto() {

		ValidadorProducto interfaz = new ValidadorProducto();
		String[] opciones = {

				"Ingresar nuevo producto", "Mostrar existente", "Editar", "Eliminar", "Salir" };

		String opcion = "";
		do {

			opcion = (String) JOptionPane.showInputDialog(null, "Elija la accion a realizar", null, 0, null, opciones,
					opciones[0]);
			switch (opcion) {

			case "Ingresar nuevo producto":
				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				String descripcion = JOptionPane.showInputDialog("Ingrese descripcion");
				double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio"));
				int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto"));
				int id_categoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoria del producto"));
				int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock"));
				if (interfaz.ValidarIngreso(nombre, descripcion, precio, id_producto, id_categoria, stock)) {
					JOptionPane.showMessageDialog(null, "Se pudo guardar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo guardar");
				}
				break;

			case "Mostrar existente":
				String registros = "Lista de productos";
				if (interfaz.Mostrar() == null) {
					JOptionPane.showMessageDialog(null, "No hay productos");
				} else {

					for (Producto productos : interfaz.Mostrar()) {
						registros = registros + "\n" + productos;
					}
					JOptionPane.showMessageDialog(null, registros);
				}
				break;

			case "Editar":
				nombre = JOptionPane.showInputDialog("Ingrese nombre");
				descripcion = JOptionPane.showInputDialog("Ingrese descripcion");
				precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio"));
				id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto"));
				id_categoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoria del producto"));
				stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock"));
				if (interfaz.ValidarEditar(nombre, descripcion, precio, id_producto, id_categoria, stock)) {
					JOptionPane.showMessageDialog(null, "Se pudo editar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo editar");
				}
				break;

			case "Eliminar":
				id_producto = Integer
						.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto a eliminar"));

				if (interfaz.ValidarEliminar(id_producto)) {
					JOptionPane.showMessageDialog(null, "Se pudo Eliminar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo Eliminar");
				}

				break;

			default:
				break;
			}

		} while (!opcion.equals("Salir"));

		/*
		 * int op = 0; int it = 0;
		 * 
		 * 
		 * Producto.inicializarProductos();
		 * 
		 * Operacion operacion = new Operacion(); Distribucion distribucion = new
		 * Distribucion(); Venta venta = new Venta();
		 * 
		 * 
		 * 
		 * do { op = Integer.parseInt(JOptionPane.showInputDialog("compra"));
		 * 
		 * switch (op) {
		 * 
		 * case 0: // Es para ver los productos Producto.verProductos(); break; case
		 * 1:// Es para agregar nuevos productos
		 * 
		 * Producto.agregarProducto(); break; case 2:// Es para salir del switch
		 * JOptionPane.showMessageDialog(null, "chau"); case 3: // Es para agregar stock
		 * a los productos Producto.verProductosStock(); Producto.agregarStock(); break;
		 * case 4: // Es para modificar informacion del producto
		 * Producto.modificarProducto(); break; case 5:// Esto lleva al carrito do { it
		 * = Integer.parseInt(JOptionPane.showInputDialog("carrito")); Date fechaCompra;
		 * switch(it) {
		 * 
		 * case 0:// Es para agregar productos al carrito String nombreProducto =
		 * JOptionPane.
		 * showInputDialog("Ingrese el nombre del producto que desea agregar al carrito:"
		 * ); Producto producto =
		 * Producto.buscarProductoPorNombre(Producto.listaProductos, nombreProducto); if
		 * (producto != null) { int cantidad = Integer.parseInt(JOptionPane.
		 * showInputDialog("Ingrese la cantidad que desea agregar:"));
		 * operacion.agregarProductoAlCarrito(producto, cantidad);
		 * JOptionPane.showMessageDialog(null, "Producto agregado al carrito.", "Éxito",
		 * JOptionPane.INFORMATION_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error",
		 * JOptionPane.ERROR_MESSAGE); } break; case 1: // Es para agregar productos al
		 * carrito ArrayList<Producto> productosEnCarrito = operacion.getCarrito(); if
		 * (productosEnCarrito.isEmpty()) { JOptionPane.showMessageDialog(null,
		 * "El carrito está vacío.", "Carrito de Compras",
		 * JOptionPane.INFORMATION_MESSAGE); } else { StringBuilder mensaje = new
		 * StringBuilder("Productos en el carrito:\n\n"); for (Producto p :
		 * productosEnCarrito) { mensaje.append("Nombre: " + p.getNombre() + "\n");
		 * mensaje.append("Descripción: " + p.getDescripcion() + "\n");
		 * mensaje.append("Precio: " + p.getPrecio() + "\n");
		 * mensaje.append("Cantidad en el carrito: " + p.getCantidadCarrito() + "\n");
		 * mensaje.append("\n"); } JOptionPane.showMessageDialog(null,
		 * mensaje.toString(), "Carrito de Compras", JOptionPane.INFORMATION_MESSAGE); }
		 * break; case 2:// Es para finalizar la compra if (operacion.getPrecioTotal()
		 * == 0) {
		 * 
		 * JOptionPane.showMessageDialog(null,
		 * "No hay agregado ningun producto al carrito");
		 * 
		 * } else { int numeroTarjeta; int numeroTarjetaAtras;
		 * 
		 * numeroTarjeta=Integer.parseInt(JOptionPane.
		 * showInputDialog("Agrega el numero de tarjeta"));
		 * numeroTarjetaAtras=Integer.parseInt(JOptionPane.
		 * showInputDialog("Agrega el numero del reverso de la tarjeta de tarjeta"));
		 * 
		 * 
		 * Date fechCompra = new Date(); double precioTotalCompra =
		 * operacion.getPrecioTotal(); String informacionCompra = "Fecha de compra: " +
		 * fechCompra + "\n" + "Precio total: $" + precioTotalCompra;
		 * distribucion.agregarCompra(informacionCompra);
		 * distribucion.setFechaEnvio(fechCompra);
		 * JOptionPane.showMessageDialog(null,"Compra finalizada \n"+
		 * informacionCompra);
		 * 
		 * }
		 * 
		 * 
		 * break;
		 * 
		 * case 3:// Es para eliminar productos del carrito String
		 * nombreProductoEliminar = JOptionPane.
		 * showInputDialog("Ingrese el nombre del producto que desea eliminar del carrito:"
		 * ); Producto productoEliminar =
		 * Producto.buscarProductoPorNombre(Producto.listaProductos,
		 * nombreProductoEliminar); if (productoEliminar != null) { int cantidadEliminar
		 * = Integer.parseInt(JOptionPane.
		 * showInputDialog("Ingrese la cantidad que desea eliminar:"));
		 * operacion.eliminarProductoDelCarrito(productoEliminar, cantidadEliminar);
		 * JOptionPane.showMessageDialog(null, "Producto eliminado del carrito.",
		 * "Éxito", JOptionPane.INFORMATION_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null, "Producto no encontrado en el carrito.",
		 * "Error", JOptionPane.ERROR_MESSAGE); } break; case 4: // Es para visualizar
		 * los envios Distribucion distribucion1 = operacion.getDistribucion(); Date
		 * fechaEnvio = distribucion.getFechaEnvio();
		 * 
		 * if (fechaEnvio != null) { Date fechaHoy = new Date(); long diferencia =
		 * fechaEnvio.getTime() - fechaHoy.getTime(); long diasRestantes = diferencia /
		 * (1000 * 60 * 60 * 24);
		 * 
		 * if (diasRestantes <= 0) { JOptionPane.showMessageDialog(null,
		 * "El envío llegará a su casa en breve.", "Envío en camino",
		 * JOptionPane.INFORMATION_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null, "El envío llegará a su casa en " +
		 * diasRestantes + " días.", "Envío en camino",
		 * JOptionPane.INFORMATION_MESSAGE); }
		 * 
		 * ArrayList<String> compras = distribucion.getCompras(); if
		 * (!compras.isEmpty()) { StringBuilder mensajeCompras = new
		 * StringBuilder("Compras registradas en la distribución:\n\n"); for (String
		 * informacionCompra1 : compras) { mensajeCompras.append(informacionCompra1 +
		 * "\n\n"); } JOptionPane.showMessageDialog(null, mensajeCompras.toString(),
		 * "Compras en la distribución", JOptionPane.INFORMATION_MESSAGE); } else {
		 * JOptionPane.showMessageDialog(null,
		 * "No hay compras registradas en la distribución.", "Distribución de Compras",
		 * JOptionPane.INFORMATION_MESSAGE); } } else {
		 * JOptionPane.showMessageDialog(null, "No hay fecha de envío registrada.",
		 * "Información de Envío", JOptionPane.INFORMATION_MESSAGE); } break;
		 * 
		 * case 5:// Es para eliminar o cancelar envios(Todavia no funciona) String
		 * seleccionMovimiento=JOptionPane.
		 * showInputDialog("Ingrese entregado o cancelar"); if (seleccionMovimiento !=
		 * null) { if (seleccionMovimiento.equals("Entregado")) {
		 * venta.marcarComoEntregado(distribucion, "entregado"); } else if
		 * (seleccionMovimiento.equals("Cancelado")) {
		 * venta.marcarComoCancelado(distribucion, "eliminado"); } } break;
		 * 
		 * case 6:
		 * 
		 * break;
		 * 
		 * default: break; }
		 * 
		 * }while(it!=4);
		 */
	}
}
