package ChupiPandi;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;

public class MensajeOut implements Serializable {
	
	PrintWriter pw;
	
	public MensajeOut(Socket socket) throws IOException{
		pw = new PrintWriter(socket.getOutputStream(),true);
	}

	/**
	 * Recibe una cadena y la envia a los clientes
	 * 
	 * @param string
	 */
	public void enviarMensaje(String string) {
		//envia un mensaje
		pw.println(string);
	}
}
