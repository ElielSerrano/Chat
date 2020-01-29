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

public class ServidorVista {

	private JFrame Sframe;
	private JButton minimizar;
	private JButton cerrar;
	private JLabel marcaagua;
	public static JLabel horaServer;
	private JButton btnEncenderOn;
	public static JLabel lblPonerSiEsta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorVista window = new ServidorVista();
					window.Sframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the application.
	 */
	public ServidorVista() {
		initialize();
		Sframe.setUndecorated(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Sframe = new JFrame();
		Sframe.setIconImage(Toolkit.getDefaultToolkit().getImage(ServidorVista.class.getResource("/img/icono.png")));
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
		minimizar.setIcon(new ImageIcon(ServidorVista.class.getResource("/img/line low.png")));
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
		cerrar.setIcon(new ImageIcon(ServidorVista.class.getResource("/img/close.png")));
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		Sframe.getContentPane().add(cerrar);

		marcaagua = new JLabel("");
		marcaagua.setIcon(new ImageIcon(LoginVista.class.getResource("/img/iconoMarcaAgua.png")));
		marcaagua.setBounds(400, 16, 40, 38);
		Sframe.getContentPane().add(marcaagua);

		horaServer = new JLabel("");
		horaServer.setBounds(293, 257, 147, 32);
		// llamada hilo clock
		Clock.reloj();
		Sframe.getContentPane().add(horaServer);

		btnEncenderOn = new JButton("");

		btnEncenderOn.setIcon(new ImageIcon(ServidorVista.class.getResource("/img/encender.png")));
		btnEncenderOn.setBounds(162, 111, 123, 105);
		btnEncenderOn.setOpaque(true);
		btnEncenderOn.setContentAreaFilled(false);
		btnEncenderOn.setBorder(null);
		Sframe.getContentPane().add(btnEncenderOn);

		JLabel lblServidor = new JLabel("SERVIDOR");
		lblServidor.setFont(new Font("Consolas", Font.BOLD, 20));
		lblServidor.setForeground(Color.DARK_GRAY);
		lblServidor.setBounds(172, 76, 88, 24);
		Sframe.getContentPane().add(lblServidor);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ServidorVista.class.getResource("/img/square.png")));
		lblNewLabel.setBounds(34, 65, 380, 192);
		Sframe.getContentPane().add(lblNewLabel);

		lblPonerSiEsta = new JLabel("");
		lblPonerSiEsta.setFont(new Font("Consolas", Font.BOLD, 20));
		lblPonerSiEsta.setBounds(172, 219, 113, 24);
		Sframe.getContentPane().add(lblPonerSiEsta);
		btnEncenderOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblPonerSiEsta.setText("Encendido");
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO llamada al servidor para encenderlo
				
				try {
					
					Server s = new Server();
					Server.main(null);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
		});

	}
}
