package iu;

import java.util.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.*;
import datos.*;

public class MainSBD {
	
	public static void main(String[] args) {
	
	int op = 0;
	int it = 0;

	
	ProductoSBD.inicializarProductos();
    OperacionSBD operacionSBD = new OperacionSBD();
    DistribucionSBD distribucionSBD = new DistribucionSBD();
    VentaSBD ventaSBD = new VentaSBD();

       
	
    do {
    	op = Integer.parseInt(JOptionPane.showInputDialog("compra"));

    	switch (op) {
    	
    	case 0: // Es para ver los productos
    		        ProductoSBD.verProductos();
    		        break;
    	case 1:// Es para agregar nuevos productos
    		
    				ProductoSBD.agregarProducto();
    				break;
    	case 2:// Es para salir del switch
    				JOptionPane.showMessageDialog(null, "chau");
    	case 3:	// Es para agregar stock a los productos
	        	ProductoSBD.verProductosStock();
    			ProductoSBD.agregarStock();	
    		break;
    	case 4: // Es para modificar informacion del producto
    			ProductoSBD.modificarProducto();
    		break;
    	case 5:// Esto lleva al carrito
    		do {
            	it = Integer.parseInt(JOptionPane.showInputDialog("carrito"));
            	Date fechaCompra;
				switch(it) {
            	
            	case 0:// Es para agregar productos al carrito
            		 String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea agregar al carrito:");
                     ProductoSBD producto = ProductoSBD.buscarProductoPorNombre(ProductoSBD.listaProductos, nombreProducto);
                     if (producto != null) {
                         int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar:"));
                         operacionSBD.agregarProductoAlCarrito(producto, cantidad);
                         JOptionPane.showMessageDialog(null, "Producto agregado al carrito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                     } else {
                         JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                    break;
            	case 1: // Es para agregar productos al carrito
            		 ArrayList<ProductoSBD> productosEnCarrito = operacionSBD.getCarrito();
                     if (productosEnCarrito.isEmpty()) {
                         JOptionPane.showMessageDialog(null, "El carrito está vacío.", "Carrito de Compras", JOptionPane.INFORMATION_MESSAGE);
                     } else {
                         StringBuilder mensaje = new StringBuilder("Productos en el carrito:\n\n");
                         for (ProductoSBD p : productosEnCarrito) {
                             mensaje.append("Nombre: " + p.getNombre() + "\n");
                             mensaje.append("Descripción: " + p.getDescripcion() + "\n");
                             mensaje.append("Precio: " + p.getPrecio() + "\n");
                             mensaje.append("Cantidad en el carrito: " + p.getCantidadCarrito() + "\n");
                             mensaje.append("\n");
                         }
                         JOptionPane.showMessageDialog(null, mensaje.toString(), "Carrito de Compras", JOptionPane.INFORMATION_MESSAGE);
                     }
                	break;
                case 2:// Es para finalizar la compra
                	if (operacionSBD.getPrecioTotal() == 0) {

                		JOptionPane.showMessageDialog(null, "No hay agregado ningun producto al carrito");
						
					} else {
						int numeroTarjeta;
						int numeroTarjetaAtras;
						
						numeroTarjeta=Integer.parseInt(JOptionPane.showInputDialog("Agrega el numero de tarjeta"));
						numeroTarjetaAtras=Integer.parseInt(JOptionPane.showInputDialog("Agrega el numero del reverso de la tarjeta de tarjeta"));


						Date fechCompra = new Date();
                     double precioTotalCompra = operacionSBD.getPrecioTotal();
                     String informacionCompra = "Fecha de compra: " + fechCompra + "\n" + "Precio total: $" + precioTotalCompra;
                     distribucionSBD.agregarCompra(informacionCompra);
                     distribucionSBD.setFechaEnvio(fechCompra); 	
                     JOptionPane.showMessageDialog(null,"Compra finalizada \n"+ informacionCompra);
                    
					}
                	
                     
                     break;
                    
                case 3:// Es para eliminar productos del carrito
                	 String nombreProductoEliminar = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea eliminar del carrito:");
                     ProductoSBD productoEliminar = ProductoSBD.buscarProductoPorNombre(ProductoSBD.listaProductos, nombreProductoEliminar);
                     if (productoEliminar != null) {
                         int cantidadEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea eliminar:"));
                         operacionSBD.eliminarProductoDelCarrito(productoEliminar, cantidadEliminar);
                         JOptionPane.showMessageDialog(null, "Producto eliminado del carrito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                     } else {
                         JOptionPane.showMessageDialog(null, "Producto no encontrado en el carrito.", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                	break;
                case 4: // Es para visualizar los envios
                	Distribucion distribucion1 = operacionSBD.getDistribucion();
                Date fechaEnvio = distribucionSBD.getFechaEnvio();

                if (fechaEnvio != null) {
                    Date fechaHoy = new Date();
                    long diferencia = fechaEnvio.getTime() - fechaHoy.getTime();
                    long diasRestantes = diferencia / (1000 * 60 * 60 * 24);

                    if (diasRestantes <= 0) {
                        JOptionPane.showMessageDialog(null, "El envío llegará a su casa en breve.", "Envío en camino", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El envío llegará a su casa en " + diasRestantes + " días.", "Envío en camino", JOptionPane.INFORMATION_MESSAGE);
                    }

                    ArrayList<String> compras = distribucionSBD.getCompras();
                    if (!compras.isEmpty()) {
                        StringBuilder mensajeCompras = new StringBuilder("Compras registradas en la distribución:\n\n");
                        for (String informacionCompra1 : compras) {
                            mensajeCompras.append(informacionCompra1 + "\n\n");
                        }
                        JOptionPane.showMessageDialog(null, mensajeCompras.toString(), "Compras en la distribución", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay compras registradas en la distribución.", "Distribución de Compras", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay fecha de envío registrada.", "Información de Envío", JOptionPane.INFORMATION_MESSAGE);
                }
                    break;
                    
                case 5:// Es para eliminar o cancelar envios(Todavia no funciona)
                	String seleccionMovimiento=JOptionPane.showInputDialog("Ingrese entregado o cancelar");
                	if (seleccionMovimiento != null) {
                        if (seleccionMovimiento.equals("Entregado")) {
                            ventaSBD.marcarComoEntregado(distribucionSBD, "entregado");
                        } else if (seleccionMovimiento.equals("Cancelado")) {
                            ventaSBD.marcarComoCancelado(distribucionSBD, "eliminado");
                        }
                    }
                	break;
                	
                case 6:
                	
                	break;
                	
                default:
                break;
            	}
    			
    		}while(it!=4);
    		
    		
    		break;
    	
    	
    	
    	default:
			break;
    	}
    }while (op!=2);

}
	
}
