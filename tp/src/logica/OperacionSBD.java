
package logica;

import java.util.ArrayList;
import java.util.Date;


import javax.swing.JOptionPane;

import datos.Distribucion;
import datos.ProductoSBD;

public class OperacionSBD {
	private ArrayList<ProductoSBD> carrito;
    private Date fecha;
    private double precioTotal;
    private Distribucion distribucion; 

    public OperacionSBD() {
        carrito = new ArrayList<>();
        this.fecha = fecha;
        this.precioTotal = precioTotal;
    }
    
    public ArrayList<ProductoSBD> getCarrito() {
        return carrito;
    }
    
    public void setCarrito(ArrayList<ProductoSBD> carrito) {
		this.carrito = carrito;
	}

	public Date getFecha() {
        return fecha;
    }
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
    public double getPrecioTotal() {
        return precioTotal;
    }
    
    public void setDistribucion(Distribucion distribucion) {
		this.distribucion = distribucion;
    }
    public Distribucion getDistribucion() {
        return distribucion;
    }
    
    public void agregarProductoAlCarrito(ProductoSBD producto, int cantidad) {
        if (cantidad > 0 && producto.getStock() >= cantidad) {
            producto.aumentarCantidadCarrito(cantidad);
            carrito.add(producto);
            precioTotal += producto.getPrecio() * cantidad; 
        } else {
            JOptionPane.showMessageDialog(null, "Cantidad no válida o no hay suficiente stock.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarProductoDelCarrito(ProductoSBD producto, int cantidad) {
        if (carrito.contains(producto) && cantidad > 0) {
            if (producto.getCantidadCarrito() >= cantidad) {
                producto.reducirCantidadCarrito(cantidad);
                if (producto.getCantidadCarrito() == 0) {
                    carrito.remove(producto);
                }
                precioTotal -= producto.getPrecio() * cantidad; 
            } else {
                JOptionPane.showMessageDialog(null, "No puedes eliminar más unidades de las que están en el carrito.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado en el carrito o cantidad no válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

	public void finalCompra() {
        fecha = new Date(); 
    }

}
