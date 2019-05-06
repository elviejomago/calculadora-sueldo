package ec.com.calculadora.sueldo.utilitario;

import ec.com.calculadora.sueldo.excepcion.ValorNuloExcepcion;

public class ValidadorUtilitario {

	public static boolean validarCadenaVaciaNula(String horarioCadena) throws ValorNuloExcepcion {
		if(horarioCadena == null || horarioCadena.isEmpty()) {
			throw new ValorNuloExcepcion();
		}else {
			return true;
		}
	}

}
