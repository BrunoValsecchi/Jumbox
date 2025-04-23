package iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class PantallaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaMain frame = new PantallaMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaMain() {
		setTitle("JUMBOX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton salirBot = new JButton("Salir");
		salirBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salirBot.setBackground(SystemColor.activeCaption);
		salirBot.setBounds(280, 154, 144, 51);
		salirBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				dispose();
			}
		});
		contentPane.add(salirBot);
		
		JLabel bienvenida = new JLabel("Bienvenido a JUMBOX");
		bienvenida.setFont(new Font("Tahoma", Font.PLAIN, 30));
		bienvenida.setForeground(new Color(255, 255, 255));
		bienvenida.setBackground(new Color(255, 255, 255));
		bienvenida.setBounds(38, 21, 386, 68);
		contentPane.add(bienvenida);
		
		JButton iniciarBot = new JButton("Iniciar sesion");
		iniciarBot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		iniciarBot.setBackground(SystemColor.activeCaption);
		iniciarBot.setForeground(new Color(0, 0, 0));
		iniciarBot.setBounds(38, 154, 174, 51);
		iniciarBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaLogin login = new PantallaLogin();
				
				login.run();
				dispose();
				
			}
		});
		contentPane.add(iniciarBot);
		
		JLabel fondo = new JLabel("");
		fondo.setForeground(new Color(255, 255, 255));
		fondo.setIcon(new ImageIcon("D:\\dv\\git\\Jumbox\\tp\\src\\img\\fondo.jpg"));
		fondo.setBounds(0, 0, 434, 261);
		contentPane.add(fondo);
	}
}
