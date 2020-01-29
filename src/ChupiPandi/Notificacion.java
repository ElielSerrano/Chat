/**
 * 
 */
package ChupiPandi;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.File;

/**
 * @author Maria Esther Serrano Bueno
 *
 */
public class Notificacion {
	private static AudioClip clip;

	public static void main(String[] args) throws AWTException {
		if (SystemTray.isSupported()) {
			Notificacion nt = new Notificacion();
			nt.displayTray();
		} else {
			System.err.println("System tray not supported!");
		}
	}

	public void displayTray() throws AWTException {
		// Obtain only one instance of the SystemTray object
		SystemTray tray = SystemTray.getSystemTray();

		// If the icon is a file
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		// Alternative (if the icon is on the classpath):
		// Image image =
		// Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

		TrayIcon trayIcon = new TrayIcon(image, "Notificacion");
		// Let the system resize the image if needed
		trayIcon.setImageAutoSize(true);
		// Set tooltip text for the tray icon
		trayIcon.setToolTip("System tray icon demo");
		tray.add(trayIcon);

		trayIcon.displayMessage("Chat La Chupi Pandi", "Nuevo Mensaje: " +DatosServidorVista.alias, MessageType.INFO);
		sound();

	}

	public static void sound() {
		try {

			File Url = new File("src/sound/sound.wav");
			clip = Applet.newAudioClip(Url.toURI().toURL());
			//clip.loop();
			clip.play();

		} catch (Exception ex) {

			System.err.println(ex + " error");

		}
	}

	public static void parar(AudioClip clip) {

		clip.stop();
	}
}
