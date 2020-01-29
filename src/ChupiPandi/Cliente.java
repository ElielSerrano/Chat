/**
 * 
 */
package ChupiPandi;

import java.awt.AWTException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Maria Esther Serrano Bueno
 *
 */
public class Cliente extends Thread {
	static JFrame ventana;
	static Socket socket;
	public static MensajeIn entrada;
	public static MensajeOut salida;

	@Override
	public void run() {
		BufferedReader bfr = null;
		PrintWriter pw = null;
		InputStreamReader isr = null;
		try {
			// establece conexion al servidor
			socket = new Socket();
			socket.connect(new InetSocketAddress(DatosServidorVista.ip, Integer.parseInt(DatosServidorVista.puerto)));
			entrada = new MensajeIn(socket);
			salida = new MensajeOut(socket);
			salida.enviarMensaje(DatosServidorVista.alias);
			sleep(1000);
			salida.enviarMensaje("lista");
			while (!socket.isClosed()) {
				manejarMensajes();
			}
		} catch (IOException e) {
			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pw);
			close(bfr);
			close(isr);
			cerrar(socket);
		}
	}

	private static void manejarMensajes() {
		String cadena = entrada.recibirMensaje();
		String opc;
		String[] array = null;
		if (cadena.contains("@")) {
			array = cadena.split("@");
			opc = array[0];
		} else
			opc = cadena.trim();
		switch (opc) {
		case "lista":
			String[] listaClientes = array[1].split(",");
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < listaClientes.length; i++) {

				// System.out.println(listaClientes[i]);
				UsuariosVista.comboBox_Usuarios.addItem(listaClientes[i].trim());
			}

			break;

		default:
			// imprimir mensaje en textArea
			if (ChatVista.vistaMensajes == null) {
				ChatVista cv = new ChatVista();
				
				cv.frameChat.setVisible(true);
			}
			ChatVista.vistaMensajes.append(opc + "\n");
			Notificacion n = new Notificacion();
			try {
				n.main(null);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}
	}
	

	public static void cerrar(Socket socket) {
		try {
			if (null != socket) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void close(Writer writer) {
		try {
			if (null != writer) {
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void close(Reader reader) {
		try {
			if (null != reader) {
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
