package ec.com.calculadora.sueldo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import ec.com.calculadora.sueldo.configuracion.ConfiguracionInicial;
import ec.com.calculadora.sueldo.excepcion.ValorNuloExcepcion;
import ec.com.calculadora.sueldo.fabrica.FabricaHorarioSueldo;
import ec.com.calculadora.sueldo.utilitario.ConstanteUtilitario;
import ec.com.calculadora.sueldo.utilitario.ValidadorUtilitario;

/**
 * @author jpatino
 * @version 1.0
 * 
 *          Clase inicial que lanza la aplicacion de calculo de sueldos.
 */
public class App {
	public static void main(String[] args) {
		try {
			ConfiguracionInicial configuracionInicial = ConfiguracionInicial.inicializar();

			Reader fr = new InputStreamReader(App.class.getClassLoader().getResourceAsStream(ConstanteUtilitario.EMPLEADOS_HORAS_TRABAJADAS_TXT));
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				ValidadorUtilitario.validarCadenaVaciaNula(linea);
				String[] duplaNombreHorario = linea.split(ConstanteUtilitario.SEPARADOR_SPLIT_NOMBRE_HORARIO);
				Double sueldoEmpleado = FabricaHorarioSueldo.getSueldoEmpleado(duplaNombreHorario[1], configuracionInicial);
				System.out.println("The amount to pay " + duplaNombreHorario[0] + " is: " + sueldoEmpleado + " USD");
			}
			br.close();
		} catch (ValorNuloExcepcion | IOException e) {
			e.printStackTrace();
		}
	}

}
