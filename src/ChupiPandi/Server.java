package ChupiPandi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author haruseky
 *
 */
public class Server {
	public static ServerSocket server;
	public static ClientList listaClientes;
	public static Server servidor;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//iniciamos instancia del servidor
		servidor = new Server();
		try {
			//iniciamos servidor
			servidor.iniciar();
			do {
				//controlamos los clientes
				manejarClientes();
			}while(!server.isClosed());
		} catch (Exception e) {
		}

	}// end main
	
	/**
	 * inicia el ServerSocket en el puerto expecificado
	 * 
	 * @throws IOException
	 */
	private void iniciar() throws IOException {
		System.out.println("Arrancado el servidor");
		server = new ServerSocket(60000);
		listaClientes = new ClientList();
	}
	
	/**
     * Acepta los clientes nuevos en un hilo que los gestiona.
     * Rechaza mediante un mensaje si el servidor est� lleno
     */
    private static void manejarClientes(){
    	try {
    		// Aceptamos el cliente.
	    	Socket cliente = server.accept();
	    	HilosServer hilo = new HilosServer(cliente,listaClientes,servidor);
			hilo.start();
			
			// Si est� lleno el server, lo rechazamos
			//el limite ser� de 5 en este caso
	    	if(listaClientes.getClientesConectados() >= 5) {
				//cerramos el cliente
				cliente.close();
				//eliminamos el hilo
				hilo = null;
				hilo.stop();
	    	}
    	}catch(IOException e) { /* Cuando no hay nadie intentando conectar */ }
    }

    /**
     * el servidor manda un mensaje a todos los clientes 
     * cuando un cliente se desconecte
     * 
     * @param string
     */
	public void imprimirMensajes(String mensaje) {
		System.out.println(mensaje);
		
	}

	/**
	 * saca a un cliente del servidor
	 * 
	 * @param alias
	 */
	public static void sacarCliente(String alias) {
		listaClientes.remove(alias);	

	}

	/**
	 * mete un cliente en el servidor
	 * 
	 * @param hilo
	 */
	public void meterCliente(HilosServer hilo) {
		listaClientes.add(hilo.getAlias(), hilo);
	}

}
