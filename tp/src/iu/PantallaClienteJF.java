package iu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import datos.Cliente;
import logica.ValidadorCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;

public class PantallaClienteJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			PantallaClienteJF frame = new PantallaClienteJF();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public PantallaClienteJF() {
		setTitle("Admin de clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClientes.setBounds(170, 11, 164, 23);
		contentPane.add(lblClientes);

		table = new JTable();
		table.setBounds(10, 45, 496, 206);
		contentPane.add(table);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Mail");
		modelo.addColumn("Telefono");
		modelo.addColumn("Direccion");
		modelo.addColumn("Dni");
		Cliente clientes = new Cliente();
		table.setModel(modelo);

		JButton nuevoBot = new JButton("Nuevo");
		nuevoBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValidadorCliente interfaz = new ValidadorCliente();

				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				String apellido = JOptionPane.showInputDialog("Ingrese apellido");
				String mail = JOptionPane.showInputDialog("Ingrese mail");
				int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono"));
				String direccion = JOptionPane.showInputDialog("Ingrese direccion");
				int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni"));
				if (interfaz.ValidarIngreso(nombre, apellido, mail, telefono, direccion, dni)) {
					JOptionPane.showMessageDialog(null, "Se pudo guardar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo guardar");
				}

			}
		});
		nuevoBot.setBounds(10, 262, 89, 23);
		contentPane.add(nuevoBot);

		JLabel lblSelec = new JLabel("Selec");
		lblSelec.setBounds(10, 296, 414, 14);
		contentPane.add(lblSelec);

		JButton volverBot = new JButton("Volver");
		volverBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaVentaJF venta = new PantallaVentaJF();
				venta.run();
				dispose();

			}
		});
		volverBot.setBounds(10, 321, 89, 23);
		contentPane.add(volverBot);

		JButton eliminarBot = new JButton("Eliminar");
		eliminarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente cliente = new Cliente();
				int rowSelect = table.getSelectedRow();
				if (rowSelect >= 0) {

					cliente.setDni((int) modelo.getValueAt(rowSelect, 4));
					if (cliente.Eliminar()) {
						JOptionPane.showMessageDialog(null, "Se elimino");

					} else {
						JOptionPane.showMessageDialog(null, "No se elimino");
					}

				}
			}
		});
		eliminarBot.setBounds(109, 321, 89, 23);
		contentPane.add(eliminarBot);

		JButton editarBot = new JButton("Editar");
		editarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ValidadorCliente interfaz = new ValidadorCliente();

				int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dni del cliente a editar"));
				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				String apellido = JOptionPane.showInputDialog("Ingrese apellido");
				String mail = JOptionPane.showInputDialog("Ingrese mail");
				int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono"));
				String direccion = JOptionPane.showInputDialog("Ingrese direccion");

				if (interfaz.ValidarEditar(nombre, apellido, mail, telefono, direccion, dni)) {
					JOptionPane.showMessageDialog(null, "Se pudo editar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo editar");
				}

			}
		});
		editarBot.setBounds(208, 321, 89, 23);
		contentPane.add(editarBot);

		for (Cliente cliente : clientes.Mostrar()) {
			modelo.addRow(new Object[] { cliente.getNombre(), cliente.getApellido(), cliente.getMail(),
					cliente.getTelefono(), cliente.getDireccion(), cliente.getDni() });
		}

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {

					int rowSelect = table.getSelectedRow();
					if (rowSelect >= 0) {
						lblSelec.setText("Nombre:" + (String) modelo.getValueAt(rowSelect, 0) + " Apellido:"
								+ (String) modelo.getValueAt(rowSelect, 1) + " Mail:"
								+ (String) modelo.getValueAt(rowSelect, 2) + " Telefono:"
								+ (int) modelo.getValueAt(rowSelect, 3) + " Direccion:"
								+ (String) modelo.getValueAt(rowSelect, 4) + " Dni:"
								+ (int) modelo.getValueAt(rowSelect, 5));

					}

				}

			}

		});
	}
}
