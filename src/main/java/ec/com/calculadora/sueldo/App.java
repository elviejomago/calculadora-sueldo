package ec.com.calculadora.sueldo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import ec.com.calculadora.sueldo.configuracion.ConfiguracionInicial;
import ec.com.calculadora.sueldo.excepcion.ValorNuloExcepcion;
import ec.com.calculadora.sueldo.fabrica.FabricaEmpleadoSueldo;
import ec.com.calculadora.sueldo.utilitario.ConstanteUtilitario;
import ec.com.calculadora.sueldo.utilitario.ValidadorUtilitario;

public class App {
	public static void main(String[] args) {
		try {
			ConfiguracionInicial configuracionInicial = ConfiguracionInicial.inicializar();
			Path path = Paths.get("empleados_horas_trabajadas.txt");
			File archivo = path.toFile();
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
	         while((linea=br.readLine())!=null) {
	        	 ValidadorUtilitario.validarCadenaVaciaNula(linea);
	        	 String[] duplaNombreHorario = linea.split(ConstanteUtilitario.SEPARADOR_SPLIT_NOMBRE_HORARIO);
	        	 Double sueldoEmpleado = FabricaEmpleadoSueldo.getSueldoEmpleado(duplaNombreHorario[1], configuracionInicial);
	        	 System.out.println("The amount to pay "+duplaNombreHorario[0]+" is: "+sueldoEmpleado+" USD");
	         }
			br.close();
		} catch (ValorNuloExcepcion | IOException e) {
			e.printStackTrace();
		}
	}
}
