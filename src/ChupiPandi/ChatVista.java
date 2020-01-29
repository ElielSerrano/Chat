package ChupiPandi;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.Font;

public class ChatVista {

	public JFrame frameChat;
	private JButton minimizar;
	private JButton cerrar;
	private JLabel marcaagua;

	private static final long serialVersionUID = 1L;

	private JFrame ventana;
	WindowListener exitListener;

	private JLabel labelClientes;
	private JTextArea chat;
	private JTextField campo;
	private JButton botonEnviar, botonSalir, botonLimpiar, botonListado, botonScroll;
	DefaultCaret caret;
	public static TextArea vistaMensajes;
	private JButton btnSend;
	Clock reloj = new Clock();
	public static JLabel horaChat;
	private JLabel nombreVentaCliente;
	private JButton btnArchivoSend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatVista window = new ChatVista();
					window.frameChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatVista() {
		initialize();
		frameChat.setUndecorated(true);
		frameChat.setLocationRelativeTo(null);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameChat = new JFrame();
		frameChat.setIconImage(Toolkit.getDefaultToolkit().getImage(ChatVista.class.getResource("/img/icono.png")));
		frameChat.setBounds(100, 100, 450, 300);
		frameChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		minimizar = new JButton("");
		minimizar.setBounds(34, 0, 38, 33);
		minimizar.setBorder(null);
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameChat.setExtendedState(JFrame.CROSSHAIR_CURSOR);
			}
		});
		frameChat.getContentPane().setLayout(null);
		marcaagua = new JLabel("");
		marcaagua.setIcon(new ImageIcon(LoginVista.class.getResource("/img/iconoMarcaAgua.png")));
		marcaagua.setBounds(410, 0, 40, 38);
		frameChat.getContentPane().add(marcaagua);
		minimizar.setOpaque(true);
		minimizar.setContentAreaFilled(false);
		minimizar.setIcon(new ImageIcon(ChatVista.class.getResource("/img/line low.png")));
		frameChat.getContentPane().add(minimizar);

		cerrar = new JButton("");
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setBorder(null);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String salir = "/salir";
				Cliente.salida.enviarMensaje(salir);

				frameChat.dispose();
				UsuariosVista.Uframe.dispose();


			}
		});
		cerrar.setIcon(new ImageIcon(ChatVista.class.getResource("/img/close.png")));
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		frameChat.getContentPane().add(cerrar);

		vistaMensajes = new TextArea();
		vistaMensajes.setEditable(false);
		vistaMensajes.setBounds(0, 39, 450, 202);
		frameChat.getContentPane().add(vistaMensajes);

		JTextField dondeEscribes = new JTextField();
		dondeEscribes.setBounds(0, 244, 327, 56);
		frameChat.getContentPane().add(dondeEscribes);
		dondeEscribes.setColumns(10);

		btnSend = new JButton("");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String mensaje = dondeEscribes.getText();
				String aux;
				if (UsuariosVista.directo != null && UsuariosVista.destino != null) {
					aux = UsuariosVista.directo + mensaje + UsuariosVista.destino;
				} else {
					aux = mensaje;
				}
				Cliente.salida.enviarMensaje(aux);
				dondeEscribes.setText("");
			}
		});
		btnSend.setIcon(new ImageIcon(ChatVista.class.getResource("/img/sending.png")));
		btnSend.setBounds(321, 247, 65, 41);
		btnSend.setOpaque(true);
		btnSend.setContentAreaFilled(false);
		btnSend.setBorderPainted(false);
		frameChat.getContentPane().add(btnSend);

		nombreVentaCliente = new JLabel(UsuariosVista.comboBox_Usuarios.getSelectedItem().toString());
		nombreVentaCliente.setFont(new Font("Consolas", Font.BOLD, 20));
		nombreVentaCliente.setBounds(82, 9, 160, 24);
		frameChat.getContentPane().add(nombreVentaCliente);

		horaChat = new JLabel("");
		horaChat.setBounds(269, 9, 131, 29);
		frameChat.getContentPane().add(horaChat);

		btnArchivoSend = new JButton("");
		btnArchivoSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnArchivoSend.setIcon(new ImageIcon(ChatVista.class.getResource("/img/sendarchivo.png")));
		btnArchivoSend.setBounds(375, 247, 65, 41);
		btnArchivoSend.setOpaque(true);
		btnArchivoSend.setContentAreaFilled(false);
		btnArchivoSend.setBorderPainted(false);
		frameChat.getContentPane().add(btnArchivoSend);
		// llamada hilo clock
		Clock.reloj();

	}

}
