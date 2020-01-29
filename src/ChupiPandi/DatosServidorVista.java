package ChupiPandi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DatosServidorVista {

	JFrame DSframe;
	private JButton minimizar;
	private JButton cerrar;
	private JLabel marcaagua;
	Clock reloj = new Clock();
	public static JLabel horaServidor;
	private JButton btn_EnviaraServidor;
	public static JTextField ipServidor;
	public static JTextField puertoServidor;
	public static JTextField aliasServidor;

	public static String ip = "";
	public static String puerto = "";
	public static String alias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosServidorVista window = new DatosServidorVista();
					window.DSframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatosServidorVista() {
		initialize();
		DSframe.setUndecorated(true);
		DSframe.getContentPane().setLayout(null);
		DSframe.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("IP Servidor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(72, 93, 121, 24);
		DSframe.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Puerto");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_1.setBounds(72, 141, 66, 24);
		DSframe.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Alias");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_2.setBounds(72, 181, 55, 24);
		DSframe.getContentPane().add(lblNewLabel_2);

		ipServidor = new JTextField();
		ipServidor.setText("EJ: 192.168.0.80");
		ipServidor.setBounds(239, 102, 102, 20);
		DSframe.getContentPane().add(ipServidor);
		ipServidor.setColumns(10);

		puertoServidor = new JTextField();
		puertoServidor.setText("EJ: 60000");
		puertoServidor.setBounds(239, 146, 102, 20);
		DSframe.getContentPane().add(puertoServidor);
		puertoServidor.setColumns(10);

		aliasServidor = new JTextField();
		aliasServidor.setBounds(239, 186, 102, 20);
		DSframe.getContentPane().add(aliasServidor);
		aliasServidor.setColumns(10);

		btn_EnviaraServidor = new JButton("");
		btn_EnviaraServidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cliente c = new Cliente();
				UsuariosVista usr = new UsuariosVista();

				// TODO HAY QUE ENVIAR LOS DATOS RECOGIDOS AL SERVIDOR

				alias = aliasServidor.getText();
				ip = ipServidor.getText();
				puerto = puertoServidor.getText();

				usr.Uframe.setVisible(true);
				DSframe.dispose();
				try {
					c.start();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btn_EnviaraServidor.setIcon(new ImageIcon(DatosServidorVista.class.getResource("/img/okR.png")));
		btn_EnviaraServidor.setBounds(148, 186, 83, 59);
		btn_EnviaraServidor.setBorder(null);
		btn_EnviaraServidor.setOpaque(true);
		btn_EnviaraServidor.setContentAreaFilled(false);

		DSframe.getContentPane().add(btn_EnviaraServidor);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DSframe = new JFrame();
		DSframe.setIconImage(
				Toolkit.getDefaultToolkit().getImage(DatosServidorVista.class.getResource("/img/icono.png")));
		DSframe.setBounds(100, 100, 450, 300);
		DSframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		minimizar = new JButton("");
		minimizar.setBounds(34, 0, 38, 33);
		minimizar.setBorder(null);
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DSframe.setExtendedState(JFrame.CROSSHAIR_CURSOR);
			}
		});
		DSframe.getContentPane().setLayout(null);

		JLabel recuadro = new JLabel("");
		recuadro.setIcon(new ImageIcon(DatosServidorVista.class.getResource("/img/square.png")));
		recuadro.setBounds(34, 58, 380, 192);
		DSframe.getContentPane().add(recuadro);
		minimizar.setOpaque(true);
		minimizar.setContentAreaFilled(false);
		minimizar.setIcon(new ImageIcon(DatosServidorVista.class.getResource("/img/line low.png")));
		DSframe.getContentPane().add(minimizar);

		cerrar = new JButton("");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setBorder(null);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DSframe.dispose();

			}
		});
		cerrar.setIcon(new ImageIcon(DatosServidorVista.class.getResource("/img/close.png")));
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		DSframe.getContentPane().add(cerrar);

		marcaagua = new JLabel("");
		marcaagua.setIcon(new ImageIcon(LoginVista.class.getResource("/img/iconoMarcaAgua.png")));
		marcaagua.setBounds(400, 16, 40, 38);
		DSframe.getContentPane().add(marcaagua);

		horaServidor = new JLabel("");
		horaServidor.setBounds(313, 261, 127, 28);
		DSframe.getContentPane().add(horaServidor);
		// llamada hilo clock
		Clock.reloj();

	}

	/**
	 * @return the aliasServidor
	 */
	public static JTextField getAliasServidor() {
		return aliasServidor;
	}

	/**
	 * @param aliasServidor the aliasServidor to set
	 */
	public static void setAliasServidor(JTextField aliasServidor) {
		DatosServidorVista.aliasServidor = aliasServidor;
	}

	/**
	 * @return the ip
	 */
	public static String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public static void setIp(String ip) {
		DatosServidorVista.ip = ip;
	}

	/**
	 * @return the puerto
	 */
	public static String getPuerto() {
		return puerto;
	}

	/**
	 * @param puerto the puerto to set
	 */
	public static void setPuerto(String puerto) {
		DatosServidorVista.puerto = puerto;
	}

}
