package vista;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
import java.awt.TextArea;
import java.awt.Toolkit;

public class Chat {

	private JFrame frameChat;
	private JButton minimizar;
	private JButton cerrar;

private static final long serialVersionUID = 1L;
	
	private JFrame ventana;
	WindowListener exitListener;
	
	private JLabel labelClientes;
	private JTextArea chat;
	private JTextField campo;
	private JButton botonEnviar, botonSalir, botonLimpiar, botonListado, botonScroll;
	DefaultCaret caret;
	private TextArea vistaMensajes;
	private JButton btnSend;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
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
	public Chat() {
		initialize();
		frameChat.setUndecorated(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameChat = new JFrame();
		frameChat.setIconImage(Toolkit.getDefaultToolkit().getImage(Chat.class.getResource("/img/icono.png")));
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
		minimizar.setOpaque(true);
		minimizar.setContentAreaFilled(false);
		minimizar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/line low.png")));
		frameChat.getContentPane().add(minimizar);

		cerrar = new JButton("");
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setBorder(null);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameChat.dispose();

			}
		});
		cerrar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/close.png")));
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		frameChat.getContentPane().add(cerrar);
		
		vistaMensajes = new TextArea();
		vistaMensajes.setEditable(false);
		vistaMensajes.setBounds(0, 39, 450, 202);
		frameChat.getContentPane().add(vistaMensajes);
		
		JTextField dondeEscribes = new JTextField();
		dondeEscribes.setBounds(0, 244, 385, 56);
		frameChat.getContentPane().add(dondeEscribes);
		dondeEscribes.setColumns(10);
		
		btnSend = new JButton("");
		btnSend.setIcon(new ImageIcon(Chat.class.getResource("/img/sending.png")));
		btnSend.setBounds(385, 248, 65, 41);
		btnSend.setOpaque(true);
		btnSend.setContentAreaFilled(false);
		btnSend.setBorderPainted(false);
		frameChat.getContentPane().add(btnSend);

	}

}
