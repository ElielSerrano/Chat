package ChupiPandi;

import java.io.IOException;
import java.net.Socket;

/**
 * @author haruseky
 *
 */
public class HilosServer extends Thread {

	private Socket cliente;
	private ClientList listaClientes;
	private Server servidor;
	private String alias;

	MensajeIn entrada;
	MensajeOut salida;

	/**
	 * Constructor donde inicializamos el socket, la lista de clientes y el servidor
	 * recogiendo por parametro las instancias dadas desde la clase Server
	 * 
	 * @param cliente
	 * @param listaClientes
	 * @param servidor
	 * @throws IOException
	 */
	public HilosServer(Socket cliente, ClientList listaClientes, Server servidor) throws IOException {
		// inicilaizamos el socket para la comunicacion
		this.cliente = cliente;
		this.listaClientes = listaClientes;
		alias = "";
		this.servidor = servidor;

		entrada = new MensajeIn(cliente);
		salida = new MensajeOut(cliente);
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public void run() {
		String cadena;
		// funcion para iniciar los parametros
		iniciarCliente();
		do {
			// recivimos los mensajes del cliente
			cadena = entrada.recibirMensaje();
			// los mandamos a un metodo de analisis
			manejoMensajes(cadena);
			// mientras el mensaje no sea /salir sigue en ejecucion
		} while (!cadena.trim().equals("/salir"));

		try {
			// cerramos los objetos
			cliente.close();
		} catch (IOException e) {
			try {
				throw e;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	/**
	 * recive el mensaje del cliente, lo analiza para sacar los parametros y hace
	 * las llamadas en funcion del contenido
	 * 
	 * @param mensaje
	 */
	private void manejoMensajes(String mensaje) {
		String[] cadena = null;
		String opc;
		// si el mensaje contiene ':' se separan los parametros
		if (mensaje.contains("@")) {
			cadena = mensaje.split("@");
			// la opcion debe ir en primer lugar
			opc = cadena[0];
		} else
			opc = mensaje.trim();

		switch (opc) {
		case "/salir": // saca al cliente del servidor y emite un mensaje tanto en los clientes como en
						// el servidor
			String msg = "<SERVER> " + alias + " ha abandonado el chat.";
			listaClientes.emitirATodos(msg);
			servidor.imprimirMensajes(msg);
			servidor.sacarCliente(alias);

			break;
		case "lista": // manda la lista de clientes conectados
			salida.enviarMensaje("lista@" + new String(listaClientes.getListaClientes()));
			break;
		case "directo": // manda un mensaje de cliente a cliente
			// se imprime en el servidor
			servidor.imprimirMensajes(alias + ": " + cadena[1]);
			// se envian los parametros alias: para saber quien escribe, cadena[1]: contiene
			// el mensaje
			// cadena[2]: destinatario del mensaje
			listaClientes.emitirAUno(alias, cadena[1], cadena[2]);
			break;
		default:// si no se especifica comando se manda un mensaje a todos
			String msg2 = alias + ": " + mensaje;
			listaClientes.emitirATodos(msg2);
			servidor.imprimirMensajes(msg2);

			break;
		}
	}

	/**
	 * Establecemos el alias que nos debe venir en un mensaje desde el cliente.
	 * Indicamos al servidor que guarde el hilo en la lista con el alias de key. Por
	 * ultimo emitimos un mensaje tanto en el servidor como en los clientes
	 */
	private void iniciarCliente() {
		// establece el alias recibido
		alias = entrada.recibirMensaje();
		// pide al servidor que le inserte en la lista
		servidor.meterCliente(this);
		// emite el mensaje en el servidor y los clientes
		// listaClientes.emitirATodos("<SERVER> "+ alias + " se ha unido al chat.");
		servidor.imprimirMensajes("<SERVER> " + alias + " se ha unido al chat.");
	}

}
