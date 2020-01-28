package vista;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Servidor {

	private JFrame Sframe;
	private JButton encender;
	private JButton minimizar;
	private JButton cerrar;
	private JLabel marcaagua;
	public static JLabel horaServer;
	private JButton btnApagar;
	private JButton btnEncenderOn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor window = new Servidor();
					window.Sframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Servidor() {
		initialize();
		Sframe.setUndecorated(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Sframe = new JFrame();
		Sframe.setIconImage(Toolkit.getDefaultToolkit().getImage(Servidor.class.getResource("/img/icono.png")));
		Sframe.setBounds(100, 100, 450, 300);
		Sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Sframe.getContentPane().setLayout(null);

		Sframe.setLocationRelativeTo(null);

		minimizar = new JButton("");
		minimizar.setBorder(null);
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Sframe.setExtendedState(JFrame.CROSSHAIR_CURSOR);
			}
		});
		minimizar.setOpaque(true);
		minimizar.setContentAreaFilled(false);
		minimizar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/line low.png")));
		minimizar.setBounds(34, 0, 38, 33);
		Sframe.getContentPane().add(minimizar);

		cerrar = new JButton("");
		cerrar.setBorder(null);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sframe.dispose();

			}
		});
		cerrar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/close.png")));
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		Sframe.getContentPane().add(cerrar);

		marcaagua = new JLabel("");
		marcaagua.setIcon(new ImageIcon(Login.class.getResource("/img/iconoMarcaAgua.png")));
		marcaagua.setBounds(400, 16, 40, 38);
		Sframe.getContentPane().add(marcaagua);

		horaServer = new JLabel("");
		horaServer.setBounds(293, 257, 147, 32);
		Sframe.getContentPane().add(horaServer);

		btnEncenderOn = new JButton("");
		btnEncenderOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO llamada al servidor para encenderlo
			}
		});
		btnEncenderOn.setIcon(new ImageIcon(Servidor.class.getResource("/img/encender.png")));
		btnEncenderOn.setBounds(99, 122, 123, 105);
		btnEncenderOn.setOpaque(true);
		btnEncenderOn.setContentAreaFilled(false);
		btnEncenderOn.setBorder(null);
		Sframe.getContentPane().add(btnEncenderOn);

		btnApagar = new JButton("");
		btnApagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO llamada al servidor para apagarlo
			}
		});
		btnApagar.setIcon(new ImageIcon(Servidor.class.getResource("/img/off.png")));
		btnApagar.setBounds(232, 122, 123, 105);
		Sframe.getContentPane().add(btnApagar);
		btnApagar.setOpaque(true);
		btnApagar.setContentAreaFilled(false);
		btnApagar.setBorder(null);

		JLabel lblServidor = new JLabel("SERVIDOR");
		lblServidor.setFont(new Font("Consolas", Font.BOLD, 20));
		lblServidor.setForeground(Color.DARK_GRAY);
		lblServidor.setBounds(183, 76, 88, 24);
		Sframe.getContentPane().add(lblServidor);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Servidor.class.getResource("/img/square.png")));
		lblNewLabel.setBounds(34, 65, 380, 192);
		Sframe.getContentPane().add(lblNewLabel);

		JLabel lblPonerSiEsta = new JLabel("poner si esta encendido o apagado");
		lblPonerSiEsta.setBounds(139, 40, 168, 14);
		Sframe.getContentPane().add(lblPonerSiEsta);

		// llamada hilo clock
		modelo.Clock.reloj();
	}
}
