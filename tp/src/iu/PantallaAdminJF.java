package iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaAdminJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					PantallaAdminJF frame = new PantallaAdminJF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the frame.
	 */
	public PantallaAdminJF() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Administrador");
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdmin.setBounds(170, 11, 196, 43);
		contentPane.add(lblAdmin);
		
		JButton usuBot = new JButton("Administrar usuarios");
		usuBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                PantallaUusuarioJF usuario = new PantallaUusuarioJF();
				
				usuario.run();
				dispose();
				
			}
		});
		usuBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usuBot.setBounds(111, 65, 235, 43);
		contentPane.add(usuBot);
		
		JButton producBot = new JButton("Administrar productos");
		producBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		producBot.setBounds(111, 119, 235, 43);
	producBot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
            PantallaProductoJF producto = new PantallaProductoJF();
			
			producto.run();
			dispose();
			
		}
	});
		contentPane.add(producBot);
		
		JButton salirBot = new JButton("Salir");
		salirBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salirBot.setBounds(111, 173, 235, 33);
		salirBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                PantallaLogin login = new PantallaLogin();
				
				login.run();
				dispose();
				
			}
		});
		contentPane.add(salirBot);
	}
}
