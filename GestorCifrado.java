package ChupiPandi;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * 
 */

/**
 * @author alu01-dam2
 *
 */
public class GestorCifrado {

	KeyPair claves; // clave publica y privada
	KeyPairGenerator generadorclaves;
	Cipher cifrador;

	public GestorCifrado() throws NoSuchAlgorithmException, NoSuchPaddingException {
		generadorclaves = KeyPairGenerator.getInstance("RSA");
		// como santa ha dicho el de 1024 ya no es tan seguro por eso pongo el de 2048
		generadorclaves.initialize(2048);
		claves = generadorclaves.generateKeyPair();
		cifrador = Cipher.getInstance("RSA");
	}

	public PublicKey getPublica() {
		return claves.getPublic();
	}

	public PrivateKey getPrivadaKey() {
		return claves.getPrivate();
	}

	public byte[] cifrar(byte[] paraCifrar, Key claveCifrado)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// los mensajes a cifrar son array de byte[] siempre!
		cifrador.init(Cipher.ENCRYPT_MODE, claveCifrado);
		byte[] resultado = cifrador.doFinal(paraCifrar);
		return resultado;

	}

	public byte[] descifrar(byte[] paraDesCifrar, Key claveDesCifrado)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		cifrador.init(Cipher.DECRYPT_MODE, claveDesCifrado);
		byte[] resultado = cifrador.doFinal(paraDesCifrar);
		return resultado;
	}

	public static void main(String[] args) {

		GestorCifrado gestorCifrado;
		try {
			gestorCifrado = new GestorCifrado();
			Key clavePublica = gestorCifrado.getPublica();
			String mensajeOriginal = "HolaMundo!";
			byte[] mensajeCifrado = gestorCifrado.cifrar(mensajeOriginal.getBytes(), clavePublica);
			String cadCifrada = new String(mensajeCifrado, "UTF-8");
			System.out.println("Cadena Original " + mensajeOriginal);
			System.out.println("Cadena Cifrada " + mensajeCifrado);

			Key clavePrivada = gestorCifrado.getPrivadaKey();
			byte[] descifrada = gestorCifrado.descifrar(mensajeCifrado, clavePrivada);

			String mensajeDescifrado = new String(descifrada, "UTF-8");
			System.out.println("El mensaje Cifrado es " + mensajeDescifrado);

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
