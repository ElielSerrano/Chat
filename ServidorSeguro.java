package ChupiPandi;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.zip.InflaterInputStream;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/**
 * 
 */

/**
 * @author alu01-dam2
 *
 */
public class ServidorSeguro {

	private String rutaAlmacen;
	private String claveAlmacen;

	/**
	 * @param rutaAlmacen
	 * @param claveAlmacen
	 */
	public ServidorSeguro(String rutaAlmacen, String claveAlmacen) {
		this.rutaAlmacen = rutaAlmacen;
		this.claveAlmacen = claveAlmacen;
	}

	@SuppressWarnings("finally")
	private SSLServerSocket getserverSocketSeguro(int puerto) {

		SSLServerSocket serverSocket = null;
		FileInputStream fichAlamacen = null;

		// paso 1, cargamos el almacen de claves

		try {
			fichAlamacen = new FileInputStream(this.rutaAlmacen);
			// paso 1.1, se crea un almacen del tipo por defecto
			KeyStore almacen = KeyStore.getInstance(KeyStore.getDefaultType());
			almacen.load(fichAlamacen, claveAlmacen.toCharArray());
			// paso 2, obtener una fabrica de key manager que ofrezcan soporte al algoritmo
			KeyManagerFactory fabrica = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			fabrica.init(almacen, claveAlmacen.toCharArray());
			// paso 3, intentamos obtener un contexto SSL que ofrezca soporte a tls

			SSLContext contextoSSL = SSLContext.getInstance("TLS");
			contextoSSL.init(fabrica.getKeyManagers(), null, null);

			// paso 4, se obtiene una fabrica de socket que permita obtener sslserversocket

			SSLServerSocketFactory fabricaSockets = contextoSSL.getServerSocketFactory();
			fabricaSockets.createServerSocket(puerto);

		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException
				| UnrecoverableKeyException | KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != fichAlamacen) {
				try {
					fichAlamacen.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return serverSocket;
		}
	}

	public void escuchar(int puerto) throws IOException {

		BufferedReader entrada = null;
		PrintWriter salida = null;
		SSLServerSocket socketServidor = null;
		Socket connRecibida = null;

		try {
			socketServidor = this.getserverSocketSeguro(puerto);
			while (true) {
				try {
					connRecibida = socketServidor.accept();
					System.out.println("Conexion segura recibida");
					entrada = new BufferedReader(new InputStreamReader(connRecibida.getInputStream()));
					salida = new PrintWriter(new OutputStreamWriter(connRecibida.getOutputStream()));

					String linea = entrada.readLine();
					salida.println(linea.length());
					salida.flush();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (null != connRecibida) {
						connRecibida.close();
					}
					if (null != entrada) {
						entrada.close();
					}
					if (null != salida) {
						salida.close();
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != socketServidor) {
				socketServidor.close();
			}
		}

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		int puerto = 60000;

		String rutaAlmacen = null;
		String claveAlmacen = null;
		ServidorSeguro servidor = new ServidorSeguro(rutaAlmacen, claveAlmacen);
		servidor.escuchar(puerto);

	}

}
