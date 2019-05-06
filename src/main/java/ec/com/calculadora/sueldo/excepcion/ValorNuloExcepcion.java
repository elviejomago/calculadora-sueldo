package ec.com.calculadora.sueldo.excepcion;

/**
 * @author jpatino
 * @version 1.0
 * 
 * Excepcion que se lanza cuando existen valores nulos.
 */
public class ValorNuloExcepcion extends Exception{

	private static final long serialVersionUID = -5401498301486094378L;

    public ValorNuloExcepcion() {
    }

    public ValorNuloExcepcion(String message) {
        super(message);
    }

    public ValorNuloExcepcion(Throwable cause) {
        super(cause);
    }

    public ValorNuloExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

}
