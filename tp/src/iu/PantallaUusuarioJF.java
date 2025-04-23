package iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import datos.Usuario;
import logica.Validador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PantallaUusuarioJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblSelec;
	private JButton volverBot;
	private JButton eliminarBot;
	private JButton editarBot;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			PantallaUusuarioJF frame = new PantallaUusuarioJF();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public PantallaUusuarioJF() {
		setTitle("Admin de usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuarios.setBounds(315, 11, 126, 23);
		contentPane.add(lblUsuarios);

		table = new JTable();
		table.setBounds(10, 45, 744, 346);
		contentPane.add(table);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Mail");
		modelo.addColumn("Dni");
		modelo.addColumn("Contraseña");
		modelo.addColumn("Rol");
		Usuario usuarios = new Usuario();
		table.setModel(modelo);

		lblSelec = new JLabel("Usuario seleccionado");
		lblSelec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelec.setBounds(10, 444, 744, 42);
		contentPane.add(lblSelec);

		volverBot = new JButton("Volver");
		volverBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		volverBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAdminJF admin = new PantallaAdminJF();
				admin.run();
				dispose();

			}
		});
		volverBot.setBounds(10, 497, 89, 23);
		contentPane.add(volverBot);

		eliminarBot = new JButton("Eliminar");
		eliminarBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eliminarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

				Usuario usuario = new Usuario();
				int rowSelect = table.getSelectedRow();
				if (rowSelect >= 0) {

					usuario.setDni((String) modelo.getValueAt(rowSelect, 4));
					if (usuario.Eliminar()) {
						JOptionPane.showMessageDialog(null, "Se elimino");

					} else {
						JOptionPane.showMessageDialog(null, "No se elimino");
					}

				}

				PantallaUusuarioJF uusuario = new PantallaUusuarioJF();

				uusuario.run();
			}
		});
		eliminarBot.setBounds(109, 497, 89, 23);
		contentPane.add(eliminarBot);

		editarBot = new JButton("Editar");
		editarBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				
				Validador interfaz = new Validador();

				String dni = JOptionPane.showInputDialog("Ingrese dni del usuario a editar");
				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				String apellido = JOptionPane.showInputDialog("Ingrese apellido");
				String mail = JOptionPane.showInputDialog("Ingrese mail");
				String contrasenia = JOptionPane.showInputDialog("Ingrese contrasenia");
				int rol = Integer.parseInt(JOptionPane.showInputDialog("Ingrese rol"));
				if (interfaz.ValidarEditar(nombre, apellido, mail, dni, contrasenia, rol)) {
					JOptionPane.showMessageDialog(null, "Se pudo editar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo editar");
				}
				
				PantallaUusuarioJF uusuario = new PantallaUusuarioJF();

				uusuario.run();

				
				/* Usuario usuario = new Usuario(); 
				int rowSelect = table.getSelectedRow(); 
				 if (rowSelect >= 0) { 

					String nombre = ((String) modelo.getValueAt(rowSelect, 0)); 
					String apellido = ((String) modelo.getValueAt(rowSelect, 1));
					String mail = ((String) modelo.getValueAt(rowSelect, 2));
					String dni = ((String) modelo.getValueAt(rowSelect, 3));
					String contrasenia = ((String) modelo.getValueAt(rowSelect, 4));
					int rol = ((int) modelo.getValueAt(rowSelect, 5));
					lblSelec.setText("Nombre: " + nombre + ", Apellido: " + apellido + ", Mail: " + mail + ", DNI: "
							+ dni + ", Contraseña: " + contrasenia + ", Rol: " + rol); 

					PantallaEditar editar = new PantallaEditar(nombre, apellido, mail, dni, contrasenia, rol);

					editar.run(nombre, apellido, mail, dni, contrasenia, rol);
					dispose(); 
					

				} */

			}
		});
		editarBot.setBounds(208, 497, 89, 23);
		contentPane.add(editarBot);

		JButton nuevoBot = new JButton("Nuevo");
		nuevoBot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nuevoBot.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

				Validador interfaz = new Validador();

				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				String apellido = JOptionPane.showInputDialog("Ingrese apellido");
				String mail = JOptionPane.showInputDialog("Ingrese mail");
				String dni = JOptionPane.showInputDialog("Ingrese dni");
				String contrasenia = JOptionPane.showInputDialog("Ingrese contrasenia");
				int rol = Integer.parseInt(JOptionPane.showInputDialog("Ingrese rol"));
				if (interfaz.ValidarIngreso(nombre, apellido, mail, dni, contrasenia, rol)) {
					JOptionPane.showMessageDialog(null, "Se pudo guardar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo guardar");
				}

				PantallaUusuarioJF usuario = new PantallaUusuarioJF();

				usuario.run();
				
				/* PantallaNuevoU ingreso = new PantallaNuevoU();

				ingreso.run();
				dispose(); */

			}
		});
		nuevoBot.setBounds(10, 410, 89, 23);
		contentPane.add(nuevoBot);

		for (Usuario usuario : usuarios.Mostrar()) {
			modelo.addRow(new Object[] { usuario.getNombre(), usuario.getApellido(), usuario.getMail(),
					usuario.getDni(), usuario.getContrasenia(), usuario.getRol() });
		}

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {

					int rowSelect = table.getSelectedRow();
					if (rowSelect >= 0) {
						lblSelec.setText("Nombre: " + (String) modelo.getValueAt(rowSelect, 0) + " | Apellido: "
								+ (String) modelo.getValueAt(rowSelect, 1) + " | Mail: "
								+ (String) modelo.getValueAt(rowSelect, 2) + " | Dni: "
								+ (String) modelo.getValueAt(rowSelect, 3) + " | Contraseña: "
								+ (String) modelo.getValueAt(rowSelect, 4) + " | Rol: "
								+ (int) modelo.getValueAt(rowSelect, 5));

					}

				}

			}

		});

	}
}
