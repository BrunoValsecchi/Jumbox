package iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datos.Operacion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaCancelado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					PantallaCancelado frame = new PantallaCancelado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the frame.
	 */
	public PantallaCancelado() {
		setTitle("Distribucion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cancelados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 151, 25);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(10, 47, 625, 276);
		contentPane.add(table);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Id operacion");
		modelo.addColumn("Precio total");
		modelo.addColumn("Cantidad de producto");
		modelo.addColumn("Estado");
		modelo.addColumn("Id usuario");
		Operacion operaciones = new Operacion();
		table.setModel(modelo);
		
		for (Operacion operacion : operaciones.MostrarOp3()) {
			modelo.addRow(new Object[] { operacion.getId_operacion(), operacion.getPrecio_total(), operacion.getCantidad_producto(), operacion.getEstado(), operacion.getId_usuario() });
		}
		
		JButton volverBot = new JButton("Volver");
		volverBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaDistribucionJF distribucion = new PantallaDistribucionJF();
				distribucion.run();
				dispose();
				
			}
		});
		volverBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		volverBot.setBounds(546, 334, 89, 31);
		contentPane.add(volverBot);
	}

}
