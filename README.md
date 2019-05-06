### Clonar el proyecto

```sh
    git clone https://github.com/elviejomago/calculadora-sueldo.git
```

### Construir el aplicativo

Para construir el aplicativo utilizaremos `maven`, para lo cual nos ubicamos dentro de la carpeta donde se clono el proyecto y ejecutamos el comando

```sh
    mvn install
```

### Datos de entrada

El aplicativo toma como datos de entrada la informacion que se encuentra en el archivo `empleados_horas_trabajadas.txt`, cada linea debe tener el siguiente formato

```sh
    NOMBRE_EMPLEADO=CODIGO_DIA09:00-12:00
```

a continuación un ejemplo

```sh
    JORGE=TU09:00-12:00,SA13:00-15:00,SU08:00-21:00
```

### CÓdigo de dias

```sh
    LUNES 	- MO
    MARTES 	- TU
    MIERCOLES 	- WE
    JUEVES 	- TH
    VIERNES 	- FR
    SABADO 	- SA
    DOMINGO 	- SU
```

### Valor hora para calculo de sueldo

```sh
    ENTRE SEMANA

	00:00 - 09:00 - $25 USD
	09:01 - 18:00 - $15 USD
	18:01 - 23:59 - $20 USD

    FIN DE SEMANA

	00:00 - 09:00 - $30 USD
	09:01 - 18:00 - $20 USD
	18:01 - 23:59 - $25 USD
```

### Ejecutar el aplicativo

Ingresar a la carpeta `target` que se crea dentro de la carpeta del proyecto al contruir el aplicativo `<DIR_PROYECTO>/target` y ejecutar la siguiente sentencia

```sh
    java -jar calculadora-sueldo-1.0.jar
```



