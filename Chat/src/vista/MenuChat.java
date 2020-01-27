package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuChat {

	protected JFrame menuChat;
	public static JLabel hora;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btn_Refrescar;
	private JButton btnEnviarMensaje;
	private JButton minimizar;
	private JButton cerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuChat window = new MenuChat();
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
	public MenuChat() {
		initialize();
        menuChat.setUndecorated(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuChat = new JFrame();
		menuChat.setResizable(false);
		menuChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuChat.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuChat.class.getResource("/img/icono.png")));
		menuChat.setTitle("Chat");
		menuChat.setBounds(100, 100, 450, 300);
		menuChat.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Conectados:");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 42, 129, 62);
		menuChat.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("aqui gente conectada");
		lblNewLabel_1.setBounds(162, 49, 170, 50);
		menuChat.getContentPane().add(lblNewLabel_1);

		btn_Refrescar = new JButton("");
		btn_Refrescar.setBorder(null);
		btn_Refrescar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// aqui va una llamada al hilo para saber que clientes hay conectados

			}
		});
		btn_Refrescar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/reload.png")));
		btn_Refrescar.setBounds(142, 183, 57, 33);
		btn_Refrescar.setOpaque(true);
		btn_Refrescar.setContentAreaFilled(false);
		menuChat.getContentPane().add(btn_Refrescar);

		hora = new JLabel("");
		hora.setBounds(287, 229, 147, 32);
		menuChat.getContentPane().add(hora);

		btnEnviarMensaje = new JButton("");
		btnEnviarMensaje.setBorder(null);
		btnEnviarMensaje.setOpaque(true);
		btnEnviarMensaje.setContentAreaFilled(false);
		btnEnviarMensaje.setIcon(new ImageIcon(MenuChat.class.getResource("/img/send.png")));
		btnEnviarMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// abrir vista para elegir a quien enviar mensaje
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
		minimizar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/line low.png")));
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
		cerrar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/close.png")));
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		menuChat.getContentPane().add(cerrar);
		
	}

	
}
