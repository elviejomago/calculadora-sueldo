package ec.com.calculadora.sueldo.utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jpatino
 * @version 1.0
 * 
 * Utilitario de que contiene metodos para el manejo de fechas.
 */
public class FechaUtilitario {

	public static SimpleDateFormat formatoSinHora = new SimpleDateFormat("dd-MM-yyyy");
	public static SimpleDateFormat formatoConHora = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public static String formatearFechaAString(Date fecha) {
		return formatoSinHora.format(fecha);
	}

	public static Date formatearStringAFecha(String fecha) {
		try {
			return formatoSinHora.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date formatearStringAFechaConHora(String fecha) {
		try {
			return formatoConHora.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date obtenerFechaActualHora(String hora) {
		String fechaActual = formatearFechaAString(new Date());
		return formatearStringAFechaConHora(fechaActual+" "+hora);
	}
	
	public static int deferenciaEnHoras(Date fechaInicio, Date fechaFin){
		long milisegundos = fechaFin.getTime() - fechaInicio.getTime();
		int segundos = (int) (milisegundos / 1000);
	    int minutos = (int) (segundos / 60);
	    return minutos;
	}
}
