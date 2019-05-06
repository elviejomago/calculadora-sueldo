package ec.com.calculadora.sueldo.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empleado {

	private String nombre;
	private Map<String, List<Horario>> horasTrabajadas;
	private Double sueldo;
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
		this.horasTrabajadas = new HashMap<String, List<Horario>>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, List<Horario>> getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(Map<String, List<Horario>> horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	
}
