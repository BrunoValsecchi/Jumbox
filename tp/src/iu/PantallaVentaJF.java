package iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PantallaVentaJF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					PantallaVentaJF frame = new PantallaVentaJF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the frame.
	 */
	public PantallaVentaJF() {
		setTitle("Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVenta = new JLabel("Sector ventas");
		lblVenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVenta.setBounds(160, 11, 152, 25);
		contentPane.add(lblVenta);
		
		JButton compraBot = new JButton("Compra");
		compraBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PantallaCompraJF pantallaCompra = new PantallaCompraJF();
			        pantallaCompra.setVisible(true);
			        dispose();
			}
		});
		compraBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		compraBot.setBounds(94, 47, 250, 38);
		contentPane.add(compraBot);
		
		JButton clienteBot = new JButton("Administrar cliente");
		clienteBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 PantallaClienteJF pantallaCliente = new PantallaClienteJF();
			        pantallaCliente.run();
			        dispose();
			}
		});
		clienteBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clienteBot.setBounds(94, 96, 250, 43);
		contentPane.add(clienteBot);
		
		JButton salirBot = new JButton("Salir");
		salirBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaLogin login = new PantallaLogin();
				login.run();
				dispose();
				
			}
		});
		salirBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salirBot.setBounds(94, 150, 250, 38);
		contentPane.add(salirBot);
	}
}
