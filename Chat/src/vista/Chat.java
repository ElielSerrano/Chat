package vista;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Chat {

	private JFrame frameChat;
	private JButton minimizar;
	private JButton cerrar;

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
		frameChat.getContentPane().setLayout(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameChat = new JFrame();
		frameChat.setBounds(100, 100, 450, 300);
		frameChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		minimizar = new JButton("");
		minimizar.setBorder(null);
		minimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameChat.setExtendedState(JFrame.CROSSHAIR_CURSOR);
			}
		});
		minimizar.setOpaque(true);
		minimizar.setContentAreaFilled(false);
		minimizar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/line low.png")));
		minimizar.setBounds(34, 0, 38, 33);
		frameChat.getContentPane().add(minimizar);

		cerrar = new JButton("");
		cerrar.setBorder(null);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameChat.dispose();

			}
		});
		cerrar.setIcon(new ImageIcon(MenuChat.class.getResource("/img/close.png")));
		cerrar.setBounds(0, 0, 38, 33);
		cerrar.setOpaque(true);
		cerrar.setContentAreaFilled(false);
		frameChat.getContentPane().add(cerrar);

	}

}
