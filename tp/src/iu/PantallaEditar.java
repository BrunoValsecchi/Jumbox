package iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Validador;

import datos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaEditar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textMail;
	private JTextField textDni;
	private JTextField textContrasenia;
	private JTextField textRol;

	/**
	 * Launch the application.
	 */

	public void run(String nombre, String apellido, String mail, String dni, String contrasenia, int rol) {
		try {
			PantallaEditar frame = new PantallaEditar(nombre, apellido, mail, dni, contrasenia, rol);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public PantallaEditar(String nombre, String apellido, String mail, String dni, String contrasenia, int rol) {
		setTitle("Editar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(10, 20, 154, 22);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(174, 20, 245, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(10, 60, 154, 22);
		contentPane.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(174, 60, 245, 22);
		contentPane.add(textApellido);

		JLabel lblMail = new JLabel("Mail: ");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMail.setBounds(10, 100, 154, 22);
		contentPane.add(lblMail);

		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(174, 100, 245, 22);
		contentPane.add(textMail);

		JLabel lblDni = new JLabel("Dni: ");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setBounds(10, 140, 154, 22);
		contentPane.add(lblDni);

		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(174, 140, 245, 22);
		contentPane.add(textDni);

		JLabel lblContrasenia = new JLabel("Contraseña: ");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(10, 180, 154, 22);
		contentPane.add(lblContrasenia);

		textContrasenia = new JTextField();
		textContrasenia.setColumns(10);
		textContrasenia.setBounds(174, 180, 245, 22);
		contentPane.add(textContrasenia);

		JLabel lblRol = new JLabel("Rol: ");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRol.setBounds(10, 220, 154, 22);
		contentPane.add(lblRol);

		textRol = new JTextField();
		textRol.setColumns(10);
		textRol.setBounds(174, 220, 245, 22);
		contentPane.add(textRol);

		JButton guardarBot = new JButton("Guardar");
		guardarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Validador interfaz = new Validador();
				if (interfaz.ValidarEditar(nombre, apellido, mail, dni, contrasenia, rol)) {
					JOptionPane.showMessageDialog(null, "Se edito con exito");
					
					PantallaUusuarioJF uusuario = new PantallaUusuarioJF();
					uusuario.run();
					dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Error");

				}
			}
		});
		guardarBot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		guardarBot.setBounds(174, 280, 128, 26);
		contentPane.add(guardarBot);

		JButton cancelarBot = new JButton("Cancelar");
		cancelarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaUusuarioJF uusuario = new PantallaUusuarioJF();
				uusuario.run();
				dispose();
				
			}
		});
		cancelarBot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cancelarBot.setBounds(310, 280, 109, 26);
		contentPane.add(cancelarBot);
	}
}
