package iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Validador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaNuevoU extends JFrame {

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
	
			public void run() {
				try {
					PantallaNuevoU frame = new PantallaNuevoU();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		

	/**
	 * Create the frame.
	 */
	public PantallaNuevoU() {
		
		String nombre = null, apellido= null, mail= null, dni= null, contrasenia= null;
		int rol = 0;
		
		
		setTitle("Nuevo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(10, 20, 154, 22);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(10, 60, 154, 22);
		contentPane.add(lblApellido);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMail.setBounds(10, 100, 154, 22);
		contentPane.add(lblMail);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setBounds(10, 140, 154, 22);
		contentPane.add(lblDni);
		
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(10, 180, 154, 22);
		contentPane.add(lblContrasenia);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRol.setBounds(10, 220, 154, 22);
		contentPane.add(lblRol);
		
		textNombre = new JTextField();
		textNombre.setBounds(174, 20, 245, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		
		textApellido = new JTextField();
		textApellido.setBounds(174, 60, 245, 22);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textMail = new JTextField();
		textMail.setBounds(174, 100, 245, 22);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		textDni = new JTextField();
		textDni.setBounds(174, 140, 245, 22);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		textContrasenia = new JTextField();
		textContrasenia.setBounds(174, 180, 245, 22);
		contentPane.add(textContrasenia);
		textContrasenia.setColumns(10);
		
		textRol = new JTextField();
		textRol.setBounds(174, 220, 245, 22);
		contentPane.add(textRol);
		textRol.setColumns(10);
		
		
		JButton guardarBot = new JButton("Guardar");
		guardarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Validador interfaz = new Validador();
				if (interfaz.ValidarIngreso(nombre, apellido, mail, dni, contrasenia, rol)) {
					JOptionPane.showMessageDialog(null, "Se guardo con exito");
					
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
