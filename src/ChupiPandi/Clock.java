/**
 * 
 */
package ChupiPandi;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Maria Esther Serrano Bueno
 *
 */
public class Clock implements Runnable {
	static Thread t;

	/**
	 * @param t
	 */
	public Clock() {
		this.t = t;
	}

	@Override
	public void run() {
		reloj();
	}

	public static void reloj() {
		try {
			while (true) {
				t.sleep(1000);

				Calendar cal = new GregorianCalendar();
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int month = cal.get(Calendar.MONTH);
				// int year = cal.get(Calendar.YEAR);
				// int second = cal.get(Calendar.SECOND);
				int minute = cal.get(Calendar.MINUTE);
				int hours = cal.get(Calendar.HOUR_OF_DAY);
				String mes[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
						"Octubre", "Noviembre", "Diciembre" };
				// MODIFICAR LABEL RELOJ
				for (int i = 0; i < mes.length; i++) {

					LoginVista.horaLoginVista.setText(
							"<html>" + day + " " + mes[month] + "  " + " Hora  " + hours + ":" + minute + "</html>");
					DatosServidorVista.horaServidor.setText(
							"<html>" + day + " " + mes[month] + "  " + " Hora  " + hours + ":" + minute + "</html>");
					UsuariosVista.horaUsuarios.setText(
							"<html>" + day + " " + mes[month] + "  " + " Hora  " + hours + ":" + minute + "</html>");
					ChatVista.horaChat.setText(
							"<html>" + day + " " + mes[month] + "  " + " Hora  " + hours + ":" + minute + "</html>");
					ServidorVista.horaServer.setText(
							"<html>" + day + " " + mes[month] + "  " + " Hora  " + hours + ":" + minute + "</html>");

				}
				t.start();
			}

		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

}
