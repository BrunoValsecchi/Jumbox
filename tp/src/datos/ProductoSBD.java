package datos;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class ProductoSBD {

	private String nombre, descripcion;
	private double precio;
	private int stock;
    private int cantidadCarrito; 

	
	public ProductoSBD() {
	}

	public ProductoSBD(String nombre, String descripcion, double precio, int stock) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock=stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getCantidadCarrito() {
		return cantidadCarrito;
	}

	public void setCantidadCarrito(int cantidadCarrito) {
		this.cantidadCarrito = cantidadCarrito;
	}

		@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock
				+ "]";
	}




		public static ArrayList<ProductoSBD> listaProductos = new ArrayList<>();

	public static  void inicializarProductos() {
        
        listaProductos.add(new ProductoSBD("Producto 1", "Descripción del Producto 1", 200, 150));
        listaProductos.add(new ProductoSBD("Producto 2", "Descripción del Producto 2", 300, 5));
        listaProductos.add(new ProductoSBD("Producto 3", "Descripción del Producto 3", 5000, 47));

    }
	
	public static void verProductos() {
		String mensaje = "";
        for (ProductoSBD producto : listaProductos) {
        	
        	if (producto.getStock()>=10) {
				mensaje += "Nombre: " + producto.getNombre() + "\n";
            mensaje += "Descripción: " + producto.getDescripcion() + "\n";
            mensaje += "Precio: " + producto.getPrecio() + "\n";
            mensaje += "\n";
			} 
            
        }
        if (mensaje.length() == 0) {
            mensaje+=("No hay productos con stock mayor o igual a 10.");
        }
        JOptionPane.showMessageDialog(null, mensaje, "Detalles de Productos", JOptionPane.INFORMATION_MESSAGE);

    }
	
			
	
		
		/*JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        for (ProductoSBD producto : productos) {
            textArea.append("Nombre: " + producto.getNombre() + "\n");
            textArea.append("Descripción: " + producto.getDescripcion() + "\n");
            textArea.append("Precio: " + producto.getPrecio() + "\n");
            textArea.append("\n"); 
        }

        JOptionPane.showMessageDialog(null, textArea, "Detalles de Productos", JOptionPane.INFORMATION_MESSAGE);*/
	
	
	public static void agregarProducto() {
			String nombre = JOptionPane.showInputDialog("ingrese nombre del producto");
			double precio = Double.parseDouble(JOptionPane.showInputDialog("ingrese precio del producto"));
			String descripcion = JOptionPane.showInputDialog("ingrese descripcion del producto");
			int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese stock del producto"));
		
			ProductoSBD nuevoProducto=new ProductoSBD(nombre, descripcion, precio, stock);

			listaProductos.add(nuevoProducto);
		
	        JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");

	}
	


	public static void verProductosStock() {
		String mensaje = "";
        for (ProductoSBD producto : listaProductos) {
        	
        	
				mensaje += "Nombre: " + producto.getNombre() + "\n";
            mensaje += "Descripción: " + producto.getDescripcion() + "\n";
            mensaje += "Precio: " + producto.getPrecio() + "\n";
            mensaje += "Stock: " + producto.getStock() + "\n";
            mensaje += "\n";
			} 
            
       
        JOptionPane.showMessageDialog(null, mensaje, "Detalles de Productos", JOptionPane.INFORMATION_MESSAGE);

    }
	

	
		
		
	public static void agregarStock() {
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        int cantidadAgregada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a agregar al stock:"));

        boolean productoEncontrado = false;
        for (ProductoSBD producto : listaProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                producto.setStock(producto.getStock() + cantidadAgregada);
                JOptionPane.showMessageDialog(null, "Stock agregado con éxito.");
                productoEncontrado = true;
                break;
            }
        }

        if (!productoEncontrado) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }
	
	
	public static void modificarProducto() {
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto que desea modificar:");
        boolean productoEncontrado = false;

        for (ProductoSBD producto : listaProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre del producto:");
                String nuevaDescripcion = JOptionPane.showInputDialog("Nueva descripción del producto:");
                double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio del producto:"));

                producto.setNombre(nuevoNombre);
                producto.setDescripcion(nuevaDescripcion);
                producto.setPrecio(nuevoPrecio);

                JOptionPane.showMessageDialog(null, "Producto modificado con éxito.", "Producto Modificado", JOptionPane.INFORMATION_MESSAGE);
                productoEncontrado = true;
                break;
            }
        }

        if (!productoEncontrado) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	 public static ProductoSBD buscarProductoPorNombre(ArrayList<ProductoSBD> listaProductos, String nombre) {
	        for (ProductoSBD producto : listaProductos) {
	            if (producto.getNombre().equalsIgnoreCase(nombre)) {
	                return producto;
	            }
	        }
	        return null; 
	    }
	 
	 
	 public void aumentarCantidadCarrito(int cantidad) {
	        cantidadCarrito += cantidad;
	    }

	    public void reducirCantidadCarrito(int cantidad) {
	        cantidadCarrito -= cantidad;
	    }
	
}
