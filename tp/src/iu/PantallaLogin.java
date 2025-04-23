package iu;

import java.awt.EventQueue;

import datos.Usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Validador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PantallaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpDni;
	private JLabel mensajeError;
	private JPasswordField inpContrasea;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			PantallaLogin frame = new PantallaLogin();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public PantallaLogin() {
		setTitle("Iniciar sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDni.setBounds(10, 11, 115, 46);
		contentPane.add(lblDni);

		inpDni = new JTextField();
		inpDni.setBounds(197, 19, 227, 46);
		contentPane.add(inpDni);
		inpDni.setColumns(10);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContrasea.setBounds(10, 101, 227, 46);
		contentPane.add(lblContrasea);

		inpContrasea = new JPasswordField();
		inpContrasea.setBounds(197, 101, 227, 46);
		contentPane.add(inpContrasea);

		mensajeError = new JLabel("Error al ingresar");
		mensajeError.setVisible(false);
		mensajeError.setForeground(Color.RED);
		mensajeError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mensajeError.setBounds(150, 228, 227, 22);
		contentPane.add(mensajeError);

		JButton ingresarBot = new JButton("Ingresar");
		ingresarBot.setBounds(90, 171, 115, 46);
		ingresarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Validador interfazUsu = new Validador();

				Usuario usu = null;
				boolean validador = true;
				int rolusuario = 0;

				while (validador) {
					if (interfazUsu.ValidarCaracteres(inpContrasea.getPassword())) {
						usu = interfazUsu.IniciarSesion(inpDni.getText());

						if (usu != null) {
							JOptionPane.showMessageDialog(null, "Inicio sesion correctamente");
							validador = false;
							rolusuario = usu.getRol();

							if (rolusuario == 1) {

								PantallaAdminJF interfazAdmin = new PantallaAdminJF();

								interfazAdmin.run();

								dispose();
							} else if (rolusuario == 2) {

								PantallaVentaJF interfazVenta = new PantallaVentaJF();

								interfazVenta.run();

								dispose();
							}

							else if (rolusuario == 3) {

								PantallaDistribucionJF interfazDistribucion = new PantallaDistribucionJF();

								interfazDistribucion.run();

								dispose();
							}

							else {
								mensajeError.setVisible(true);
							}

						}
					}

				}
			}
		});
		contentPane.add(ingresarBot);

		JButton cancelarBot = new JButton("Cancelar");
		cancelarBot.setBounds(240, 171, 115, 46);
		cancelarBot.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		contentPane.add(cancelarBot);
	}

}
