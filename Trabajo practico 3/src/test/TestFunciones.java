package test;

import java.util.GregorianCalendar;

import modelo.Funciones;

public class TestFunciones {
	
	public static void main(String[] args) {
		
		GregorianCalendar fecha=new GregorianCalendar(); //Formato (aaaa,mm,dd,hh,mm,ss) Al mes descontar 1.
		GregorianCalendar fecha1=new GregorianCalendar(); // Se usa para comparar fechas.
		
		System.out.println("Es bisiesto?: "+Funciones.esBisiesto(fecha));
		System.out.println("Es el año: "+Funciones.traerAnio(fecha));
		System.out.println("Es el mes: "+Funciones.traerMes(fecha));
		System.out.println("Es el dia: "+Funciones.traerDia(fecha));
		System.out.println("Es fecha valida?:"+Funciones.esFechaValida(fecha)); // Parametros posibles: (fecha) para fecha actual, (aa, mm, aaaa) para fecha ingresada.
		System.out.println("Fecha corta:"+Funciones.traerFechaCorta(fecha));
		System.out.println("Fecha corta con hora:"+Funciones.traerFechaCortaHora(fecha));
		System.out.println("Fecha con dias sumados:"+Funciones.traerFechaCorta(Funciones.traerFechaProximo(fecha, 26))); // Cambia el valor en Calendar
		System.out.println("El dia es habil?: "+Funciones.esDiaHabil(fecha));
		System.out.println("El dia es: "+Funciones.traerNombreDia(fecha));
		System.out.println("El mes es: "+Funciones.traerNombreMes(fecha));
		System.out.println("Fecha larga: "+Funciones.traerFechaLarga(fecha));
		System.out.println("Son fechas iguales?: "+Funciones.sonFechasIguales(fecha,fecha1));
		System.out.println("Son fechas y horas iguales?: "+Funciones.sonFechasHorasIguales(fecha,fecha1));
		System.out.println("Cuantos dias tiene el mes?: "+Funciones.traerCantDiasDeUnMes(400,2)); 
		
		System.out.println("\n");
		System.out.println("Redondear valor: "+Funciones.aproximar2Decimal (5.5446));
		System.out.println("Es un numero?: "+Funciones.esNumero('0')); 
		System.out.println("Es una letra?: "+Funciones.esLetra('ú'));
		System.out.println("Es cadena de numeros?: "+Funciones.esCadenaNumeros("6546487"));
		System.out.println("Es cadena de letras?: "+Funciones.esCadenaLetras("sdbdfbsdb"));
		
		/* 
		+  esCadenaNros(String cadena) : boolean 
		+  esCandenaLetras(String cadena) : boolean */
	}
}