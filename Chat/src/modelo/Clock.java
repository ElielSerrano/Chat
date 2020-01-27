/**
 * 
 */
package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Maria Esther Serrano Bueno
 *
 */
public class Clock implements Runnable {
	Thread t;

	/**
	 * @param t
	 */
	public Clock(Thread t) {
		this.t = t;
	}

	@Override
	public void run() {
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

				/*
				 * String dia[] = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes",
				 * "Sabado", "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes",
				 * "Sabado", "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes",
				 * "Sabado", "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes",
				 * "Sabado", "Domingo", "Lunes", "Martes", "Miercoles" };
				 */

				String mes[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
						"Octubre", "Noviembre", "Diciembre" };

				// MODIFICAR LABEL RELOJ
				for (int i = 0; i < mes.length; i++) {
				vista.MenuChat.hora.setText(
							"<html>" + day + " " + mes[month] + "  " + " Hora  " + hours + ":" + minute + "</html>");
					// + day + dia[day - 1]
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
