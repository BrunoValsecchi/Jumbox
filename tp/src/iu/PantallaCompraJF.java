package iu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import datos.Operacion;
import datos.Producto;
import datos.ProductoSBD;
import datos.Usuario;
import datos.Distribucion;
import logica.VentaSBD;

public class PantallaCompraJF extends JFrame {
       
	
	private int stockActual;
	private ArrayList<Producto> carrito = new ArrayList<>();
    private JPanel contentPane;
    private JTable tableProducto;
    private JLabel lblSelec;
    private JScrollPane scrollPaneCarrito;
    private JTable tableCarrito;
    private DefaultTableModel modeloCarrito;
    private JTextField cantidadField;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaCompraJF frame = new PantallaCompraJF();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaCompraJF() {
        ProductoSBD.inicializarProductos();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 414, 150);
        contentPane.add(scrollPane);

        
        

        tableProducto = new JTable();
        scrollPane.setViewportView(tableProducto);
        tableProducto.setModel(
                new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Precio", "Descripción", "Stock" }));

        cargarDatosTabla(); // Cargar datos al inicializar la pantalla
        scrollPaneCarrito = new JScrollPane();
        scrollPaneCarrito.setBounds(10, 220, 414, 150);
        contentPane.add(scrollPaneCarrito);

        tableCarrito = new JTable();
        scrollPaneCarrito.setViewportView(tableCarrito);
        modeloCarrito = new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Precio", "Cantidad" });
        tableCarrito.setModel(modeloCarrito);

        lblSelec = new JLabel("Detalles del producto");
        lblSelec.setBounds(10, 170, 400, 20);
        contentPane.add(lblSelec);

        JButton agregarCarritoBot = crearBoton("Agregar al Carrito", 450, 10, 150, 30);
        contentPane.add(agregarCarritoBot);

        cantidadField = new JTextField();
        cantidadField.setBounds(140, 167, 150, 30);
        contentPane.add(cantidadField);

        agregarCarritoBot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAlCarrito();
            }
        });

        JButton eliminarProductoCarritoBot = crearBoton("Eliminar Producto del Carrito", 450, 50, 150, 30);
        eliminarProductoCarritoBot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProductoDelCarrito();
            }
        });
        
        JButton finalizarCompraBot = crearBoton("Finalizar Compra", 450, 90, 150, 30);
        finalizarCompraBot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Usuario usu= new Usuario();
            	String dni = usu.getDni();
                finalizarCompra( dni);
            }
        });
        contentPane.add(finalizarCompraBot);

        
        contentPane.add(eliminarProductoCarritoBot);

       
        JButton compraBot = crearBoton("Volver a Productos", 450, 130, 150, 30);
        compraBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        volverAPantallaProducto();
    }
        });
        contentPane.add(compraBot);

    }

    private JButton crearBoton(String texto, int x, int y, int ancho, int alto) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, alto);
        return boton;
    }

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

    
    
    private void agregarAlCarrito() {
        int rowSelect = tableProducto.getSelectedRow();
        if (rowSelect >= 0) {
            String nombre = (String) tableProducto.getValueAt(rowSelect, 0);
            double precio = (Double) tableProducto.getValueAt(rowSelect, 1);
            int stock = (int) tableProducto.getValueAt(rowSelect, 3);

            try {
                int cantidad = Integer.parseInt(cantidadField.getText());
                if (cantidad > 10 && cantidad <= stock) {
                    Producto producto = new Producto(0, nombre, precio, "", 0, 0);
                    carrito.add(producto);
                    modeloCarrito.addRow(new Object[]{producto.getNombre(), producto.getPrecio(), cantidad});

                    producto.reducirStock(cantidad);

                    // Almacena el valor de stock en la variable miembro
                    stockActual = cantidad;

                    tableProducto.setValueAt(stock - cantidad, rowSelect, 3);

                    cantidadField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 10 y no debe exceder el stock disponible.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    private void eliminarProductoDelCarrito() {
        int rowSelect = tableCarrito.getSelectedRow();
        if (rowSelect >= 0) {
            String nombre = (String) tableCarrito.getValueAt(rowSelect, 0); // Columna de nombre
            double precio = (Double) tableCarrito.getValueAt(rowSelect, 1);
            int cantidad = (int) tableCarrito.getValueAt(rowSelect, 2);

            Producto producto = new Producto(0, nombre, precio, "", 0, 0);
            carrito.remove(producto);
            modeloCarrito.removeRow(rowSelect);

            // Incrementa el stock en la base de datos
            producto.aumentarStock(cantidad);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto del carrito para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void finalizarCompra(String dni) {
    	
    	Operacion operacion = new Operacion(dni);
    	Distribucion distribucion = new Distribucion();
        if (carrito.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El carrito está vacío. Agrega productos antes de finalizar la compra.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Producto producto : carrito) {
            operacion.agregarProducto(producto);
        }

        operacion.calcularPrecioTotal(stockActual);

        operacion.guardarOperacion();

        carrito.clear();
        modeloCarrito.setRowCount(0);

        cargarDatosTabla();

        JOptionPane.showMessageDialog(null, "Compra realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    }

    // Resto del código...


    
    
    
    
    
    
    private void volverAPantallaProducto() {
        PantallaProductoJF pantallaProducto = new PantallaProductoJF();
        pantallaProducto.setVisible(true);
        dispose(); 
    }
}

		
		
		
		
		
		
		
		
		
		


