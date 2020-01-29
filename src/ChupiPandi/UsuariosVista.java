package ChupiPandi;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class UsuariosVista {

	public static JFrame Uframe;
	private JButton minimizar;
	private JButton cerrar;
	private JButton enviarA;
	public static JComboBox<String> comboBox_Usuarios;
	private JButton enviarTodos;
	public static JLabel horaUsuarios;
	Clock reloj = new Clock();
	private JLabel lblNewLabel;
	private JLabel marcaagua;
	public static String directo;
	public static String destino;
	private JButton btnRefrescar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuariosVista window = new UsuariosVista();
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
	public UsuariosVista() {
		initialize();
		Uframe.setUndecorated(true);
		Uframe.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Uframe = new JFrame();
		Uframe.setIconImage(Toolkit.getDefaultToolkit().getImage(UsuariosVista.class.getResource("/img/icono.png")));
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
		minimizar.setIcon(new ImageIcon(UsuariosVista.class.getResource("/img/line low.png")));
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
		cerrar.setIcon(new ImageIcon(UsuariosVista.class.getResource("/img/close.png")));
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		Uframe.getContentPane().add(cerrar);

		comboBox_Usuarios = new JComboBox();
		comboBox_Usuarios.setBounds(114, 139, 192, 20);

		Uframe.getContentPane().add(comboBox_Usuarios);

		JLabel lblEnviarMensaje = new JLabel("Enviar Mensaje  a...");
		lblEnviarMensaje.setForeground(Color.DARK_GRAY);
		lblEnviarMensaje.setFont(new Font("Consolas", Font.BOLD, 20));
		lblEnviarMensaje.setBounds(111, 85, 199, 43);
		Uframe.getContentPane().add(lblEnviarMensaje);
		// ENVIAR A TODOS
		enviarTodos = new JButton("");
		enviarTodos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ChatVista cv = new ChatVista();
				cv.frameChat.setVisible(true);
				Uframe.dispose();
			}
		});
		enviarTodos.setIcon(new ImageIcon(UsuariosVista.class.getResource("/img/team.png")));
		enviarTodos.setBounds(114, 181, 65, 41);
		enviarTodos.setOpaque(true);
		enviarTodos.setContentAreaFilled(false);
		Uframe.getContentPane().add(enviarTodos);

		horaUsuarios = new JLabel("");
		horaUsuarios.setBounds(297, 256, 143, 33);
		Uframe.getContentPane().add(horaUsuarios);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UsuariosVista.class.getResource("/img/square.png")));
		lblNewLabel.setBounds(31, 66, 380, 192);
		Uframe.getContentPane().add(lblNewLabel);

		marcaagua = new JLabel("");
		marcaagua.setIcon(new ImageIcon(LoginVista.class.getResource("/img/iconoMarcaAgua.png")));
		marcaagua.setBounds(400, 16, 40, 38);
		Uframe.getContentPane().add(marcaagua);

		// ENVIAR A UNO
		enviarA = new JButton("");
		enviarA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				destino = "@" + comboBox_Usuarios.getSelectedItem().toString();
				directo = "directo@";

				ChatVista cv = new ChatVista();
				cv.frameChat.setVisible(true);

			}
		});
		enviarA.setOpaque(true);
		enviarA.setContentAreaFilled(false);
		enviarA.setIcon(new ImageIcon(UsuariosVista.class.getResource("/img/employee.png")));
		enviarA.setBounds(249, 181, 65, 41);
		Uframe.getContentPane().add(enviarA);

		btnRefrescar = new JButton("");
		btnRefrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox_Usuarios.removeAllItems();
				Cliente.salida.enviarMensaje("lista");

			}
		});
		btnRefrescar.setIcon(new ImageIcon(UsuariosVista.class.getResource("/img/reload.png")));
		btnRefrescar.setBounds(189, 189, 57, 33);
		btnRefrescar.setOpaque(true);
		btnRefrescar.setContentAreaFilled(false);
		Uframe.getContentPane().add(btnRefrescar);
		Clock.reloj();

	}
}
