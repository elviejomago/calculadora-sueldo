package ec.com.calculadora.sueldo.modelo;

/**
 * @author jpatino
 * @version 1.0
 * 
 * Objeto que abstrae los atributos del horario.
 */
public class Horario {
	private String codigoDia;
	private String horaInicio;
	private String horaFin;
	private Double valorAPagar;
	private boolean finDeSemana;
	
	public Horario(String codigoDia, String horaInicio, String horaFin) {
		super();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.codigoDia = codigoDia;
	}

	public Horario(String horaInicio, String horaFin, Double valorAPagar) {
		super();
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.valorAPagar = valorAPagar;
	}


	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public Double getValorAPagar() {
		return valorAPagar;
	}

	public void setValorAPagar(Double valorAPagar) {
		this.valorAPagar = valorAPagar;
	}

	public String getCodigoDia() {
		return codigoDia;
	}

	public void setCodigoDia(String codigoDia) {
		this.codigoDia = codigoDia;
	}

	public boolean isFinDeSemana() {
		return finDeSemana;
	}

	public void setFinDeSemana(boolean finDeSemana) {
		this.finDeSemana = finDeSemana;
	}
	
}

