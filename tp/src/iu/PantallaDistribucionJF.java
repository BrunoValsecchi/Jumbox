package iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import datos.Operacion;
import datos.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class PantallaDistribucionJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablePendientes;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					PantallaDistribucionJF frame = new PantallaDistribucionJF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public PantallaDistribucionJF() {
		setTitle("Distribucion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDistribucion = new JLabel("Sector distribucion");
		lblDistribucion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDistribucion.setBounds(350, 11, 242, 25);
		contentPane.add(lblDistribucion);
		
		tablePendientes = new JTable();
		tablePendientes.setBounds(10, 85, 718, 224);
		contentPane.add(tablePendientes);
		
		DefaultTableModel modeloPendientes = new DefaultTableModel();
		modeloPendientes.addColumn("Id operacion");
		modeloPendientes.addColumn("Precio total");
		modeloPendientes.addColumn("Cantidad de producto");
		modeloPendientes.addColumn("Estado");
		modeloPendientes.addColumn("Id usuario");
		Operacion operaciones = new Operacion();
		tablePendientes.setModel(modeloPendientes);
		
		for (Operacion operacion : operaciones.MostrarOp()) {
			modeloPendientes.addRow(new Object[] { operacion.getId_operacion(), operacion.getPrecio_total(), operacion.getCantidad_producto(), operacion.getEstado(), operacion.getId_usuario() });
		}
		
		JButton entregarBot = new JButton("Entregar pedido");
		entregarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Operacion operacion = new Operacion(); 
				int rowSelect = tablePendientes.getSelectedRow(); 
				 if (rowSelect >= 0) { 

					

					int id_operacion = ((int) modeloPendientes.getValueAt(rowSelect, 0));
					
					operacion.entregar(id_operacion);

				}
				
			}
		});
		entregarBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		entregarBot.setBounds(747, 85, 135, 25);
		contentPane.add(entregarBot);
		
		JButton salirBot = new JButton("Salir");
		salirBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaLogin login = new PantallaLogin();
				login.run();
				dispose();
				
			}
		});
		salirBot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		salirBot.setBounds(747, 284, 135, 25);
		contentPane.add(salirBot);
		
		
		
		JButton cancelarBot = new JButton("Cancelar pedido");
		cancelarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Operacion operacion = new Operacion(); 
				int rowSelect = tablePendientes.getSelectedRow(); 
				 if (rowSelect >= 0) { 

					

					int id_operacion = ((int) modeloPendientes.getValueAt(rowSelect, 0));
					
					operacion.cancelar(id_operacion);

				}
				
			}
		});
		cancelarBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelarBot.setBounds(747, 121, 135, 25);
		contentPane.add(cancelarBot);
		
		
		
		
		
		
		JLabel lblPendientes = new JLabel("Pedidos en preparacion");
		lblPendientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPendientes.setBounds(10, 49, 242, 25);
		contentPane.add(lblPendientes);
		
		JButton canceladosBot = new JButton("Ver cancelados");
		canceladosBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaCancelado cancel = new PantallaCancelado();
				cancel.run();
				dispose();
				
			}
		});
		canceladosBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		canceladosBot.setBounds(747, 193, 135, 25);
		contentPane.add(canceladosBot);
		
		JButton entregadosBot = new JButton("Ver entregados");
		entregadosBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaEntregado entrega = new PantallaEntregado();
				
				entrega.run();
				dispose();
			}
		});
		entregadosBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		entregadosBot.setBounds(747, 157, 135, 25);
		contentPane.add(entregadosBot);
		
		JLabel lblPreparacion = new JLabel("Listado");
		lblPreparacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreparacion.setBounds(10, 320, 718, 25);
		contentPane.add(lblPreparacion);
		
		tablePendientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {

					int rowSelect = tablePendientes.getSelectedRow();
					if (rowSelect >= 0) {
						lblPreparacion.setText("ID: " + (int) modeloPendientes.getValueAt(rowSelect, 0) + " | Total: "
								+ (int) modeloPendientes.getValueAt(rowSelect, 1) + " | Cantidad de productos: "
								+ (int) modeloPendientes.getValueAt(rowSelect, 2) + " | Estado: "
								+ (String) modeloPendientes.getValueAt(rowSelect, 3) + " | Usuario: "
								+ (String) modeloPendientes.getValueAt(rowSelect, 4));

					}

				}

			}

		});
	}
}
