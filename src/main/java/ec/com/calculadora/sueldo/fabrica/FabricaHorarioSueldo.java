package ec.com.calculadora.sueldo.fabrica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

import ec.com.calculadora.sueldo.configuracion.ConfiguracionInicial;
import ec.com.calculadora.sueldo.enumeracion.DiaEnum;
import ec.com.calculadora.sueldo.excepcion.ValorNuloExcepcion;
import ec.com.calculadora.sueldo.modelo.Horario;
import ec.com.calculadora.sueldo.utilitario.ConstanteUtilitario;
import ec.com.calculadora.sueldo.utilitario.FechaUtilitario;
import ec.com.calculadora.sueldo.utilitario.ValidadorUtilitario;

public class FabricaHorarioSueldo {

	private FabricaHorarioSueldo() {
		super();
	}
	
	public static Double getSueldoEmpleado(String cadenaHorariosTrabajados, ConfiguracionInicial configuracionInicial) throws ValorNuloExcepcion {
		ValidadorUtilitario.validarCadenaVaciaNula(cadenaHorariosTrabajados);
		String[] horariosTrabajados = cadenaHorariosTrabajados.split(ConstanteUtilitario.SEPARADOR_SPLIT_HORARIOS_TRABAJADOS);
		Double sueldoTotal = new Double(0);
		for (String horarioTrabajado : horariosTrabajados) {
			String[] duplaDiaHorario = obtenerDuplaDiaHorario(horarioTrabajado);
			String codigoDia = duplaDiaHorario[0];
			ValidadorUtilitario.validarCadenaVaciaNula(duplaDiaHorario[1]);
			String[] duplaDeHorario = obtenerDuplaDeHorario(duplaDiaHorario[1]);
			Horario horario = new Horario(duplaDiaHorario[0], duplaDeHorario[0], duplaDeHorario[1]);
			horario.setFinDeSemana(DiaEnum.get(codigoDia));
			horario.setValorAPagar(obtenerValorSueldoHorario(horario, configuracionInicial));
			sueldoTotal += horario.getValorAPagar();
		}
		return sueldoTotal;
	}

	private static String[] obtenerDuplaDiaHorario(String horarioCadena) {
		String[] duplaDiaHorario = new String[2];
		duplaDiaHorario[0] = horarioCadena.substring(0, 2);
		duplaDiaHorario[1] = horarioCadena.substring(2);
		return duplaDiaHorario;
	}

	private static String[] obtenerDuplaDeHorario(String horarioCadena) {
		return horarioCadena.split(ConstanteUtilitario.SEPARADOR_SPLIT_HORARIO);
	}
	
	private static Double obtenerValorSueldoHorario(Horario horario, ConfiguracionInicial configuracionInicial) {
		Date horarioInicio = FechaUtilitario.obtenerFechaActualHora(horario.getHoraInicio());
		Date horarioFin = FechaUtilitario.obtenerFechaActualHora(horario.getHoraFin());
		Double sueldo = new Double(0);
		if(horario.isFinDeSemana()) {
			for (Horario horarioConfiguracion : configuracionInicial.getListaHorarioFinDeSemana()) {
				sueldo += calcularSueldoPorConfiguracion(horarioConfiguracion, horarioInicio, horarioFin);
			}
		}else {
			for (Horario horarioConfiguracion : configuracionInicial.getListaHorarioEntreSemana()) {
				sueldo += calcularSueldoPorConfiguracion(horarioConfiguracion, horarioInicio, horarioFin);
			}
		}
		
		return sueldo;
	}
	
	private static Double calcularSueldoPorConfiguracion(Horario horarioConfiguracion, Date horarioInicio, Date horarioFin) {
		Date inicioHorarioConfiguracion = FechaUtilitario.obtenerFechaActualHora(horarioConfiguracion.getHoraInicio());
		Date finHorarioConfiguracion = FechaUtilitario.obtenerFechaActualHora(horarioConfiguracion.getHoraFin());
		
		int minutosHorario = ConstanteUtilitario.MINUTOS_EN_UNA_HORA;
		Double sueldo = new Double(0);
		
		if(horarioInicio.compareTo(inicioHorarioConfiguracion) >=0 && horarioFin.compareTo(finHorarioConfiguracion)<=0) {
			sueldo = calcularValorPorMinuto(horarioInicio, horarioFin, horarioConfiguracion.getValorAPagar(), minutosHorario);
		}else if(horarioInicio.compareTo(inicioHorarioConfiguracion) < 0 && horarioFin.compareTo(finHorarioConfiguracion)>0) {
			sueldo = calcularValorPorMinuto(horarioInicio, horarioFin, horarioConfiguracion.getValorAPagar(), minutosHorario);
		}else if(horarioInicio.compareTo(inicioHorarioConfiguracion) <= 0 && horarioFin.compareTo(finHorarioConfiguracion)< 0
				&& horarioFin.compareTo(inicioHorarioConfiguracion) > 0) {
			sueldo = calcularValorPorMinuto(inicioHorarioConfiguracion, horarioFin, horarioConfiguracion.getValorAPagar(), minutosHorario);
		}else if(horarioInicio.compareTo(inicioHorarioConfiguracion) > 0 && horarioFin.compareTo(finHorarioConfiguracion)>= 0
				&& horarioInicio.compareTo(finHorarioConfiguracion) < 0) {
			sueldo = calcularValorPorMinuto(horarioInicio, finHorarioConfiguracion, horarioConfiguracion.getValorAPagar(), minutosHorario);
		}
		
		return sueldo;
	}
	
	private static Double calcularValorPorMinuto(Date inicio, Date fin, Double valor, int minutosHorario) {
		int diferencia = FechaUtilitario.deferenciaEnHoras(inicio, fin);
		int diferenciaAjustada = diferencia + ajusteMinutosAHorario(inicio, fin);
		BigDecimal temporalParaCalculo = new BigDecimal(diferenciaAjustada).multiply(new BigDecimal(valor)).setScale(2, RoundingMode.HALF_UP);
		return  temporalParaCalculo.divide(new BigDecimal(minutosHorario), 2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
	private static int ajusteMinutosAHorario(Date inicio, Date fin) {
		int ajuste = 0;
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(inicio);
		if(calendario.get(Calendar.MINUTE) == 1) {
			ajuste++;
		}

		calendario.setTime(fin);
		if(calendario.get(Calendar.MINUTE) == 59) {
			ajuste++;
		}

		return ajuste;
	}
}
