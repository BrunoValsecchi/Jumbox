package iu;

import javax.swing.table.DefaultTableModel;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datos.Producto;
import datos.ProductoSBD;
import logica.Validador;
import logica.ValidadorProducto;

public class PantallaProductoJF extends JFrame {

	private JPanel contentPane;
	private JTable tableProducto;
	private JLabel lblImagen;
	private JLabel lblSelec;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			PantallaProductoJF frame = new PantallaProductoJF();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public PantallaProductoJF() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 800, 600);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        lblImagen = new JLabel();
	        lblImagen.setBounds(10, 10, 150, 150);
	        contentPane.add(lblImagen);

	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(170, 10, 600, 300);
	        contentPane.add(scrollPane);

	        tableProducto = new JTable();
	        scrollPane.setViewportView(tableProducto);
	        tableProducto.setModel(
	                new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Precio", "Descripción", "Stock" }));

	        cargarDatosTabla(); // Cargar datos al inicializar la pantalla

	        lblSelec = new JLabel("Datos");
	        lblSelec.setBounds(10, 170, 400, 50);
	        contentPane.add(lblSelec);

	        JButton agregarProdBot = new JButton("Agregar Producto");
	        agregarProdBot.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (agregarProducto()) {
	                    JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");
	                    // Recargar datos después de agregar un producto
	                    cargarDatosTabla();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Error al agregar el producto.", "Error",
	                            JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        agregarProdBot.setBounds(10, 250, 150, 30);
	        contentPane.add(agregarProdBot);

	        JButton editarProdBot = new JButton("Editar");
	        editarProdBot.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            	dispose();
					
					ValidadorProducto interfaz = new ValidadorProducto();

				    int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id"));
					String nombre = JOptionPane.showInputDialog("Ingrese el nombre de producto");
				    int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio"));
					String descripcion = JOptionPane.showInputDialog("Ingrese apellido");
				    int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stocl"));
				    int id_categoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id categoria"));
					if (interfaz.ValidarEditar(nombre, descripcion, precio, id_producto,  id_categoria,  stock)) {
						JOptionPane.showMessageDialog(null, "Se pudo editar");
					} else {
						JOptionPane.showMessageDialog(null, "No pudo editar");
					}
					
					PantallaProductoJF productojf = new PantallaProductoJF();

					productojf.run();

	            }
	        });
	        editarProdBot.setBounds(10, 290, 150, 30);
	        contentPane.add(editarProdBot);

	        

	        

		JButton editarStockBot = new JButton(
				"Editar Stock");/*
								 * editarStockBot.addActionListener(new ActionListener() { public void
								 * actionPerformed(ActionEvent e) { editarStock(); } });
								 */
		editarStockBot.setBounds(10, 330, 150, 30);
		contentPane.add(editarStockBot);
		
		
		JButton eliminarProdBot = new JButton("Eliminar Producto");
		eliminarProdBot.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        eliminarProducto();
		    }
		});
		eliminarProdBot.setBounds(10, 370, 150, 30);
		contentPane.add(eliminarProdBot);
		
		
/*
		JButton EstadisticaBot = new JButton("Estadistica");
		EstadisticaBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EstadisticaBot.setBounds(10, 370, 150, 30);
		contentPane.add(EstadisticaBot);
*/
		JButton CarritoBot = new JButton("Carrito");
		/*
		 * CarritoBot.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { irACarrito();
		 * 
		 * });}
		 */
		CarritoBot.setBounds(10, 410, 150, 30);
		contentPane.add(CarritoBot);

		JButton VolverBot = new JButton("Volver");
		VolverBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAdminJF admin = new PantallaAdminJF();

				admin.run();
				dispose();
			}
		});
		VolverBot.setBounds(10, 450, 150, 30);
		contentPane.add(VolverBot);
		/*
		 * tableProducto.getSelectionModel().addListSelectionListener(e ->
		 * mostrarDetallesProducto());
		 * 
		 * if (tableProducto.getRowCount() > 0) {
		 * tableProducto.setRowSelectionInterval(0, 0); mostrarDetallesProducto(); }
		 */
	}

	/**/
	private void cargarDatosTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tableProducto.getModel();
        modelo.setRowCount(0); // Limpiar filas existentes

        Producto productoDao = new Producto();

        LinkedList<Producto> listaProductos = productoDao.MostrarProd();
        if (listaProductos != null) {
            for (Producto producto : listaProductos) {
                modelo.addRow(new Object[] { producto.getNombre(), producto.getPrecio(), producto.getDescripcion(),
                        producto.getStock() });
            }
        }
    }

    private boolean agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del producto");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del producto"));
        String descripcion = JOptionPane.showInputDialog("Ingrese descripción del producto");
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese stock del producto"));

        // Crea un nuevo objeto Producto
        Producto nuevoProducto = new Producto(0, nombre, precio, descripcion, 0, stock);

        // Llama al método guardarProd para agregar el producto a la base de datos
        return nuevoProducto.guardarProd();
    }
    
    
    
    
    
    private void eliminarProducto() {
        int rowSelect = tableProducto.getSelectedRow();
        if (rowSelect >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                int idProducto = obtenerIdProductoSeleccionado(); // Obtener el ID del producto seleccionado
                ValidadorProducto validadorProducto = new ValidadorProducto();
                if (validadorProducto.ValidarEliminar(idProducto)) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito.");
                    cargarDatosTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private int obtenerIdProductoSeleccionado() {
        int rowSelect = tableProducto.getSelectedRow();
        
        try {
            String idProductoStr = (String) tableProducto.getValueAt(rowSelect, 0);
            return Integer.parseInt(idProductoStr);
        } catch (NumberFormatException e) {
            // Manejar la excepción, por ejemplo, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al convertir a entero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Valor por defecto o indicador de error
        }
    }
/*
	 * private void mostrarDetallesProducto() { int rowSelect =
	 * tableProducto.getSelectedRow(); if (rowSelect >= 0) { String nombre =
	 * (String) tableProducto.getValueAt(rowSelect, 0);
	 * lblSelec.setText("Detalles de " + nombre);
	 * 
	 * cargarImagenProducto(nombre); } }
	 * 
	 * private void cargarImagenProducto(String nombreProducto) { String rutaImagen
	 * = "ruta/del/imagen/" + nombreProducto + ".jpg";
	 * 
	 * try { BufferedImage img = ImageIO.read(new File(rutaImagen)); Image scaledImg
	 * = img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
	 * Image.SCALE_SMOOTH); lblImagen.setIcon(new ImageIcon(scaledImg)); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 */
/*
 * private void modificarProducto() { String nombreProducto = JOptionPane.
 * showInputDialog("Ingrese el nombre del producto que desea modificar:");
 * boolean productoEncontrado = false;
 * 
 * for (ProductoSBD producto : ProductoSBD.listaProductos) { if
 * (producto.getNombre().equalsIgnoreCase(nombreProducto)) { String nuevoNombre
 * = JOptionPane.showInputDialog("Nuevo nombre del producto:"); String
 * nuevaDescripcion =
 * JOptionPane.showInputDialog("Nueva descripción del producto:"); double
 * nuevoPrecio =
 * Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio del producto:"))
 * ;
 * 
 * producto.setNombre(nuevoNombre); producto.setDescripcion(nuevaDescripcion);
 * producto.setPrecio(nuevoPrecio);
 * 
 * JOptionPane.showMessageDialog(null, "Producto modificado con éxito.",
 * "Producto Modificado", JOptionPane.INFORMATION_MESSAGE); productoEncontrado =
 * true;
 * 
 * DefaultTableModel modelo = (DefaultTableModel) tableProducto.getModel();
 * modelo.setRowCount(0); cargarDatosTabla(); break; } }
 * 
 * if (!productoEncontrado) { JOptionPane.showMessageDialog(null,
 * "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE); } }
 * 
 * private void editarStock() { String nombreProducto =
 * JOptionPane.showInputDialog("Ingrese el nombre del producto:"); int
 * cantidadAgregada = Integer.parseInt(JOptionPane.
 * showInputDialog("Ingrese la cantidad a agregar al stock:"));
 * 
 * boolean productoEncontrado = false; for (ProductoSBD producto :
 * ProductoSBD.listaProductos) { if
 * (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
 * producto.setStock(producto.getStock() + cantidadAgregada);
 * JOptionPane.showMessageDialog(null, "Stock editado con éxito.");
 * productoEncontrado = true;
 * 
 * DefaultTableModel modelo = (DefaultTableModel) tableProducto.getModel();
 * modelo.setRowCount(0); cargarDatosTabla(); break; } }
 * 
 * if (!productoEncontrado) { JOptionPane.showMessageDialog(null,
 * "Producto no encontrado."); } }
 * 
 * private void irACarrito() { PantallaCompraJF pantallaCompra = new
 * PantallaCompraJF(); pantallaCompra.setVisible(true); dispose(); } }
 * 
 */
}



