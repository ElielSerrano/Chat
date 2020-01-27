package vista;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;

import modelo.Clock;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class Usuarios {

	protected JFrame Uframe;
	private JButton minimizar;
	private JButton cerrar;
	private JButton enviarA;
	private JComboBox comboBox_Usuarios;
	private JButton enviarTodos;
	public static JLabel hora;
	Clock reloj = new Clock();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios window = new Usuarios();
					window.Uframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Usuarios() {
		initialize();
		Uframe.setUndecorated(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Uframe = new JFrame();
		Uframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/icono.png")));
		Uframe.setBounds(100, 100, 450, 300);
		Uframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		minimizar = new JButton("");
		minimizar.setBounds(34, 0, 38, 33);
		minimizar.setBorder(null);
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Uframe.setExtendedState(JFrame.CROSSHAIR_CURSOR);
			}
		});
		Uframe.getContentPane().setLayout(null);
		minimizar.setOpaque(true);
		minimizar.setContentAreaFilled(false);
		minimizar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/line low.png")));
		Uframe.getContentPane().add(minimizar);

		cerrar = new JButton("");
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setBorder(null);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Uframe.dispose();

			}
		});
		cerrar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/close.png")));
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		Uframe.getContentPane().add(cerrar);

		enviarA = new JButton("");
		enviarA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		enviarA.setOpaque(true);
		enviarA.setContentAreaFilled(false);
		enviarA.setIcon(new ImageIcon(Usuarios.class.getResource("/img/send.png")));
		enviarA.setBounds(249, 181, 57, 33);
		Uframe.getContentPane().add(enviarA);

		comboBox_Usuarios = new JComboBox();
		comboBox_Usuarios.setBounds(114, 139, 192, 20);
		Uframe.getContentPane().add(comboBox_Usuarios);

		JLabel lblEnviarMensaje = new JLabel("Enviar Mensaje  a...");
		lblEnviarMensaje.setFont(new Font("Consolas", Font.BOLD, 20));
		lblEnviarMensaje.setBounds(111, 85, 199, 43);
		Uframe.getContentPane().add(lblEnviarMensaje);

		enviarTodos = new JButton("");
		enviarTodos.setIcon(new ImageIcon(Usuarios.class.getResource("/img/sendall.png")));
		enviarTodos.setBounds(114, 181, 57, 33);
		enviarTodos.setOpaque(true);
		enviarTodos.setContentAreaFilled(false);
		Uframe.getContentPane().add(enviarTodos);

		hora = new JLabel("");
		hora.setBounds(280, 245, 143, 33);
		Uframe.getContentPane().add(hora);

		modelo.Clock.reloj();

	}
}
