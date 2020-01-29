package ChupiPandi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginVista {

	private JFrame frmChat;
	private JTextField textField_usr;
	private JPasswordField textField_pass;
	private String usr = "root";
	private String pass = "root";
	private JButton acceder;
	private JButton minimizar;
	private JButton cerrar;
	private JLabel lblNewLabel;
	private JLabel marcaagua;
	Clock reloj = new Clock();
	public static JLabel horaLoginVista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVista window = new LoginVista();
					window.frmChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginVista() {
		initialize();
		frmChat.setUndecorated(true);
		frmChat.setLocationRelativeTo(null);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChat = new JFrame();
		frmChat.setTitle("Chat");
		frmChat.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginVista.class.getResource("/img/icono.png")));
		frmChat.setBounds(100, 100, 450, 300);
		frmChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChat.getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.DARK_GRAY);
		lblUsuario.setFont(new Font("Consolas", Font.BOLD, 20));
		lblUsuario.setBounds(74, 96, 77, 24);
		frmChat.getContentPane().add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.DARK_GRAY);
		lblContrasea.setFont(new Font("Consolas", Font.BOLD, 20));
		lblContrasea.setBounds(74, 143, 110, 24);
		frmChat.getContentPane().add(lblContrasea);

		textField_usr = new JTextField();
		textField_usr.setBounds(190, 102, 86, 20);
		frmChat.getContentPane().add(textField_usr);
		textField_usr.setColumns(10);

		textField_pass = new JPasswordField();
		textField_pass.setBounds(190, 146, 86, 20);
		frmChat.getContentPane().add(textField_pass);
		textField_pass.setColumns(10);

		acceder = new JButton("");
		acceder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!textField_usr.equals(usr) && !textField_pass.equals(pass)) {
					// cifra la contrase�a
					Cifrado.cryptMD5(pass);
					DatosServidorVista ds = new DatosServidorVista();
					ds.DSframe.setVisible(true);
					frmChat.dispose();
				} else {
					JOptionPane.showMessageDialog(frmChat, "Usuario o Contrase�a Erroneos...");
				}
			}
		});

		acceder.setOpaque(true);
		acceder.setContentAreaFilled(false);
		acceder.setBorder(null);
		acceder.setIcon(new ImageIcon(LoginVista.class.getResource("/img/okR.png")));
		acceder.setBounds(193, 177, 83, 59);
		frmChat.getContentPane().add(acceder);
		minimizar = new JButton("");
		minimizar.setBorder(null);
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmChat.setExtendedState(JFrame.CROSSHAIR_CURSOR);
			}
		});
		minimizar.setOpaque(true);
		minimizar.setContentAreaFilled(false);
		minimizar.setIcon(new ImageIcon(LoginVista.class.getResource("/img/line low.png")));
		minimizar.setBounds(34, 0, 38, 33);
		frmChat.getContentPane().add(minimizar);

		cerrar = new JButton("");
		cerrar.setBorder(null);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmChat.dispose();
			}
		});
		cerrar.setIcon(new ImageIcon(LoginVista.class.getResource("/img/close.png")));
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		frmChat.getContentPane().add(cerrar);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginVista.class.getResource("/img/square.png")));
		lblNewLabel.setBounds(34, 65, 380, 192);
		frmChat.getContentPane().add(lblNewLabel);

		marcaagua = new JLabel("");
		marcaagua.setIcon(new ImageIcon(LoginVista.class.getResource("/img/iconoMarcaAgua.png")));
		marcaagua.setBounds(400, 16, 40, 38);
		frmChat.getContentPane().add(marcaagua);

		horaLoginVista = new JLabel("");
		horaLoginVista.setBounds(293, 257, 147, 32);
		frmChat.getContentPane().add(horaLoginVista);

		// llamada hilo clock
		Clock.reloj();
	}
}
