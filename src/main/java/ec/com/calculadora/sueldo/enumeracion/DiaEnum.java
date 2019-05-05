package ec.com.calculadora.sueldo.enumeracion;

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
}
