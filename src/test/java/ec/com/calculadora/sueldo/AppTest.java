package ec.com.calculadora.sueldo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ec.com.calculadora.sueldo.configuracion.ConfiguracionInicial;
import ec.com.calculadora.sueldo.excepcion.ValorNuloExcepcion;
import ec.com.calculadora.sueldo.fabrica.FabricaHorarioSueldo;

/**
 * @author jpatino
 * @version 1.0
 * 
 * Clase de prueba que contiene metodos para probar diferentes funcionalidades del aplicativo.
 */
public class AppTest {

	@Test
	public void pruebaSueldoEmpleadoEntreSemana() {
		ConfiguracionInicial configuracionInicial = ConfiguracionInicial.inicializar();
		try {
			Double sueldo = FabricaHorarioSueldo.getSueldoEmpleado("MO10:00-12:00", configuracionInicial);
			assertTrue("El sueldo del empleado es 30", sueldo == 30.00);
		} catch (ValorNuloExcepcion e) {}
		
	}

	@Test
	public void pruebaSueldoEmpleadoFinSemana() {
		ConfiguracionInicial configuracionInicial = ConfiguracionInicial.inicializar();
		try {
			Double sueldo = FabricaHorarioSueldo.getSueldoEmpleado("SA08:00-12:00", configuracionInicial);
			assertTrue("El sueldo del empleado es 90", sueldo == 90);
		} catch (ValorNuloExcepcion e) {}
		
	}

	@Test
	public void pruebaSueldoEmpleadoEnTresRangos() {
		ConfiguracionInicial configuracionInicial = ConfiguracionInicial.inicializar();
		try {
			Double sueldo = FabricaHorarioSueldo.getSueldoEmpleado("SA06:00-20:00", configuracionInicial);
			assertTrue("El sueldo del empleado es 420", sueldo == 420);
		} catch (ValorNuloExcepcion e) {}
		
	}

}
