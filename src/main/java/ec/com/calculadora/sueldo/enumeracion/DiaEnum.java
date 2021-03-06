package ec.com.calculadora.sueldo.enumeracion;

/**
 * @author jpatino
 * @version 1.0
 * 
 * Enumeracion que contiene el codigo de los dias de la semana y si el dia es o no fin de semana.
 */
public enum DiaEnum {
	
	MONDAY("MO", false),
	TUESDAY("TU", false),
	WEDNESDAY("WE", false),
	Thursday("TH", false),
	FRIDAY("FR", false),
	SATURDAY("SA", true),
	SUNDAY("SU", true);
	
	private String codigo;
	private boolean esFinDeSemana;
	
	private DiaEnum(String codigo, boolean esFinDeSemana) {
		this.codigo = codigo;
		this.esFinDeSemana = esFinDeSemana;
	}

	public String getCodigo() {
		return codigo;
	}

	public boolean esFinDeSemana() {
		return esFinDeSemana;
	}
	
	public static Boolean get(String codigoDia) { 
        for(DiaEnum dia : values()) {
            if(dia.getCodigo().equals(codigoDia)) { 
            	return dia.esFinDeSemana();
            }
        }
        return null;
    }
}
