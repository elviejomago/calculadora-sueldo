package ec.com.calculadora.sueldo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ec.com.calculadora.sueldo.configuracion.ConfiguracionInicial;
import ec.com.calculadora.sueldo.excepcion.ValorNuloExcepcion;
import ec.com.calculadora.sueldo.fabrica.FabricaEmpleadoSueldo;

public class AppTest {

	@Test
	public void pruebaSueldoEmpleado() {
		ConfiguracionInicial configuracionInicial = ConfiguracionInicial.inicializar();
		try {
			Double sueldo = FabricaEmpleadoSueldo.getSueldoEmpleado("MO10:00-12:00", configuracionInicial);
			assertTrue("El sueldo del empleado es 30", sueldo == 30.00);
		} catch (ValorNuloExcepcion e) {}
		
	}

}
