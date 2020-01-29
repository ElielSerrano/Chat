package ChupiPandi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuChatVista {

	protected JFrame menuChat;
	public static JLabel hora;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btn_Refrescar;
	private JButton btnEnviarMensaje;
	private JButton minimizar;
	private JButton cerrar;
	Clock reloj = new Clock();
	private JLabel recuadro;
	private JLabel marcaagua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuChatVista window = new MenuChatVista();
					window.menuChat.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuChatVista() {
		initialize();
		menuChat.setUndecorated(true);
		menuChat.setLocationRelativeTo(null);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuChat = new JFrame();
		menuChat.setResizable(false);
		menuChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuChat.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuChatVista.class.getResource("/img/icono.png")));
		menuChat.setTitle("Chat");
		menuChat.setBounds(100, 100, 450, 300);
		menuChat.getContentPane().setLayout(null);

		recuadro = new JLabel("");
		recuadro.setIcon(new ImageIcon(MenuChatVista.class.getResource("/img/square.png")));
		recuadro.setBounds(23, 47, 380, 192);
		menuChat.getContentPane().add(recuadro);

		lblNewLabel = new JLabel("Conectados:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 59, 129, 62);
		menuChat.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("aqui gente conectada");
		lblNewLabel_1.setBounds(158, 66, 170, 50);
		menuChat.getContentPane().add(lblNewLabel_1);

		btn_Refrescar = new JButton("");
		btn_Refrescar.setBorder(null);
		btn_Refrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ClientList cl = new ClientList();
				String aux = String.valueOf(cl.getListaClientes());
				lblNewLabel_1.setText(aux);

			}
		});
		btn_Refrescar.setIcon(new ImageIcon(MenuChatVista.class.getResource("/img/reload.png")));
		btn_Refrescar.setBounds(142, 183, 57, 33);
		btn_Refrescar.setOpaque(true);
		btn_Refrescar.setContentAreaFilled(false);
		menuChat.getContentPane().add(btn_Refrescar);

		hora = new JLabel("");
		hora.setBounds(293, 257, 147, 32);
		menuChat.getContentPane().add(hora);

		btnEnviarMensaje = new JButton("");
		btnEnviarMensaje.setBorder(null);
		btnEnviarMensaje.setOpaque(true);
		btnEnviarMensaje.setContentAreaFilled(false);
		btnEnviarMensaje.setIcon(new ImageIcon(MenuChatVista.class.getResource("/img/send.png")));
		btnEnviarMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// abrir vista para elegir a quien enviar mensaje

				Cliente.salida.enviarMensaje("lista");

				UsuariosVista usr = new UsuariosVista();
				usr.Uframe.setVisible(true);
				menuChat.dispose();
			}
		});
		btnEnviarMensaje.setBounds(209, 183, 57, 33);
		menuChat.getContentPane().add(btnEnviarMensaje);

		minimizar = new JButton("");
		minimizar.setBorder(null);
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menuChat.setExtendedState(JFrame.CROSSHAIR_CURSOR);
			}
		});
		minimizar.setOpaque(true);
		minimizar.setContentAreaFilled(false);
		minimizar.setIcon(new ImageIcon(MenuChatVista.class.getResource("/img/line low.png")));
		minimizar.setBounds(34, 0, 38, 33);
		menuChat.getContentPane().add(minimizar);

		cerrar = new JButton("");
		cerrar.setBorder(null);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuChat.dispose();

			}
		});
		cerrar.setIcon(new ImageIcon(MenuChatVista.class.getResource("/img/close.png")));
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		menuChat.getContentPane().add(cerrar);
		// llamada hilo clock
		Clock.reloj();

		marcaagua = new JLabel("");
		marcaagua.setIcon(new ImageIcon(LoginVista.class.getResource("/img/iconoMarcaAgua.png")));
		marcaagua.setBounds(400, 16, 40, 38);
		menuChat.getContentPane().add(marcaagua);

	}

}
