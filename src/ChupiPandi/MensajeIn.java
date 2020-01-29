package ChupiPandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.Socket;

public class MensajeIn implements Serializable {
	BufferedReader br;
	InputStreamReader is;
	
	public MensajeIn(Socket socket) throws IOException {
		is = new InputStreamReader(socket.getInputStream());
		br = new BufferedReader(is);
	}
	
	/**
	 * lee el mensaje recibido, lo guarda en 
	 * una cadena y lo devuelve para mostrarlo
	 * 
	 * @return
	 */
	public String recibirMensaje() {
		//cadena para el mensaje
		String cadenaRecibida = null;
		do {
			try {
				//se lee la cadena
				cadenaRecibida = br.readLine();
			} catch (IOException e) { cadenaRecibida = null; }
		} while(cadenaRecibida == null);
		
		//se retorna la cadena
		return cadenaRecibida;
	}

}
