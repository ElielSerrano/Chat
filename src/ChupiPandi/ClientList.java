package ChupiPandi;

import java.util.HashMap;
import java.util.Set;

public class ClientList {

	private static HashMap<String, HilosServer> mapaClientes;

	public ClientList() {
		mapaClientes = new HashMap<String, HilosServer>();
	}

	/**
	 * devuelve la cantidad de clientes conectados
	 * 
	 * @return mapaClientes.size()
	 */
	public static int getClientesConectados() {
		return mapaClientes.size();
	}

	/**
	 * guarda al cliente con el nombre como clave y el hilo como valor
	 * 
	 * @param nombre
	 * @param cliente
	 */
	public void add(String nombre, HilosServer cliente) {
		mapaClientes.put(nombre, cliente);
	}

	/**
	 * elimina al cliente por nombre
	 * 
	 * @param nombre
	 */
	public void remove(String nombre) {
		mapaClientes.remove(nombre);
	}

	/**
	 * envia un mensaje a todos los clientes
	 * 
	 * @param string
	 */
	public static void emitirATodos(String string) {
		// recorre el hashMap obteniendo el value y
		// enviando el mensaje a todos los clientes conectados
		for (HilosServer value : mapaClientes.values()) {
			value.salida.enviarMensaje(string);
		}
	}

	/**
	 * Se envia un mensaje directo entre dos clientes tando al emisor como al
	 * receptor
	 * 
	 * @param alias
	 * @param mensaje
	 * @param destinatario
	 */
	public static void emitirAUno(String alias, String mensaje, String destinatario) {
		// concatena el mensaje a enviar
		mensaje = alias + ": " + mensaje;
		// selecciona los clientes emisor y receptor y les envia el mensaje
		mapaClientes.get(destinatario).salida.enviarMensaje(mensaje);
		mapaClientes.get(alias).salida.enviarMensaje(mensaje);
	}

	/**
	 * concatena los nombres de usuario guardados como indices en una cadena y la
	 * devuelve para mostrarla
	 * 
	 * @return
	 */
	public static String getListaClientes() {
		// se usa StringBuilder para crear la cadena
		StringBuilder clientes = new StringBuilder();
		// hacemos un mapeo de las claves del hashmap
		Set<String> claves = mapaClientes.keySet();
		// recorremos el mapa y vamos añadiendo a la cadena las claves
		// ya que las claves son los nombres de usuario
		for (String key : claves) {
			clientes.append(key + ", ");
		}
		// elimino los 2 ultimos caracteres de la cadena
		clientes.setLength(clientes.length() - 2);
		// añado un punto al final
		// clientes.append(".");

		// devuelvo un string
		return clientes.toString();
	}

	public static void eliminar(String alias) {
		mapaClientes.remove(alias);
	}
}
