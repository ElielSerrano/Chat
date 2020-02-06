package ChupiPandi;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/**
 * 
 */

/**
 * @author alu01-dam2
 *
 */
public class ClienteServidorSeguro {
// aqui poner ruta de windows
	String almacen = "\\src\\clavescliente";
	String clave = "abcdabcd"; // esto es lo que pone en el pdf
	static SSLSocket conexion;

	/**
	 * @param conexion
	 * @throws IOException
	 */
	public ClienteServidorSeguro(String ip, int puerto) throws IOException {
		conexion = this.obtenerSocket(ip, puerto);
	}

	// envia un mensaje de prueba para verificar que funsiona
	public static void conectar() throws IOException {

		InputStreamReader isr = null;
		BufferedReader entrada = null;
		OutputStreamWriter osw = null;
		PrintWriter salida = null;

		try {
			System.out.println("Iniciando...");
			isr = new InputStreamReader(conexion.getInputStream());
			entrada = new BufferedReader(isr);
			osw = new OutputStreamWriter(conexion.getOutputStream());
			salida = new PrintWriter(osw);

			// de esta linea se intenta averiguar la longitud
			salida.println("123467890");
			salida.flush();

			// si todo va bien el servidor nos contesta el numero

			String num = entrada.readLine();
			int longitud = Integer.parseInt(num);
			System.out.println("La longitud devuelta es: " + longitud);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		if (null != salida) {
			salida.close();
		}
		if (null != osw) {
			osw.close();
		}
		if (null != entrada) {
			entrada.close();
		}
		if (null != isr) {
			isr.close();
		}
	}

	private SSLSocket obtenerSocket(String ip, int puerto) throws IOException {

		SSLSocket socket = null;

		System.out.println("Obteniendo Socket");

		FileInputStream ficheroAlmacenClaves = null;
		try {
			// paso 1 se carga el almacen de claves que esta en el servidor

			KeyStore alacenCliente = KeyStore.getInstance(KeyStore.getDefaultType());
			ficheroAlmacenClaves = new FileInputStream(this.almacen);
			clave.toCharArray();
			System.out.println("Almacen Cargado");

			// paso 2, creamos una fabrica de gestores de confianza que use el almacen
			// servidor

			TrustManagerFactory fabricaGestoresConfianza = TrustManagerFactory
					.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			System.out.println("Fabrica Trust creada");

			// paso 3, crea el contexto SSL, que ofezca soporte al algorito TLS

			SSLContext contexto = SSLContext.getInstance("TLS");
			contexto.init(null, fabricaGestoresConfianza.getTrustManagers(), null);

			// paso 4,se crea un socket que conecte con el servidor

			System.out.println("Contexto Creado");

			SSLSocketFactory fabricaSockets = contexto.getSocketFactory();
			socket = (SSLSocket) fabricaSockets.createSocket(ip, puerto);

			System.out.println("Socket creado");
		} catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != ficheroAlmacenClaves) {
				ficheroAlmacenClaves.close();
			}
		}

		return socket;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int puerto = 60000;

		ClienteServidorSeguro cliente = new ClienteServidorSeguro("localhost", puerto);
		cliente.conectar();

	}

}
