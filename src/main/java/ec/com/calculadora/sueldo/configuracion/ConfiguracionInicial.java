package ec.com.calculadora.sueldo.configuracion;

import java.util.ArrayList;
import java.util.List;

import ec.com.calculadora.sueldo.modelo.Horario;

public class ConfiguracionInicial {

	public List<Horario> listaHorarioEntreSemana;
	public List<Horario> listaHorarioFinDeSemana;
	
	private ConfiguracionInicial() {
		super();
	}
	
	public static ConfiguracionInicial inicializar(){
		ConfiguracionInicial configuracionInicial = new ConfiguracionInicial();
		configuracionInicial.listaHorarioEntreSemana = new ArrayList<Horario>();
		configuracionInicial.listaHorarioEntreSemana.add(new Horario("00:00", "09:00", new Double(25)));
		configuracionInicial.listaHorarioEntreSemana.add(new Horario("09:01", "18:00", new Double(15)));
		configuracionInicial.listaHorarioEntreSemana.add(new Horario("18:01", "23:59", new Double(20)));

		configuracionInicial.listaHorarioFinDeSemana = new ArrayList<Horario>();
		configuracionInicial.listaHorarioFinDeSemana.add(new Horario("00:00", "09:00", new Double(30)));
		configuracionInicial.listaHorarioFinDeSemana.add(new Horario("09:01", "18:00", new Double(20)));
		configuracionInicial.listaHorarioFinDeSemana.add(new Horario("18:01", "23:59", new Double(25)));
		
		return configuracionInicial;
	}

	public List<Horario> getListaHorarioEntreSemana() {
		return listaHorarioEntreSemana;
	}

	public List<Horario> getListaHorarioFinDeSemana() {
		return listaHorarioFinDeSemana;
	}
	
}
