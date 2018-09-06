package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funciones {
	
	// Es bisiesto? Para comprobar si funciona, cambiar el return en traerAnio.
	public static boolean esBisiesto(GregorianCalendar f) {
		int check;
		boolean torf = false;
		check = traerAnio(f)%4;
		if (check==0) {
			check = 0;
			check = traerAnio(f)%100;
			if (check!=0) {
				torf = true;
				}
			else {
				check = 0;
				check = traerAnio(f)%400;
				if (check==0) {
					torf = true;
						}
					}
				}
		return torf;
	}
	// Sobrecarga para que funcione con fechas ingresadas manualmente.
	public static boolean esBisiesto(int anio) {
		int check;
		boolean torf = false;
		check = anio%4;
		if (check==0) {
			check = 0;
			check = anio%100;
			if (check!=0) {
				torf = true;
				}
			else {
				check = 0;
				check = anio%400;
				if (check==0) {
					torf = true;
						}
					}
				}
		return torf;
	}
	
	// Entrega año actual.
	public static int traerAnio(GregorianCalendar f) {
		return f.get(Calendar.YEAR);
	}
	
	// Entrega mes actual. (Se le suma 1 por que empieza a contar desde 0)
	public static int traerMes(GregorianCalendar f) {	
		return f.get(Calendar.MONTH)+1;
	}
	// Entrega numero de dia de la semana 1=Domingo 2=Lunes etc.
	public static int traerDiaSemana(GregorianCalendar f) {
		return f.get(Calendar.DAY_OF_WEEK);
	}
	
	// Entrega dia actual.
	public static int traerDia(GregorianCalendar f) {
		return f.get(Calendar.DATE);
	}
	
	// Entrega hora actual.
	public static int traerHora (GregorianCalendar f) {
		return f.get(Calendar.HOUR_OF_DAY);
	}
	
	// Entrega minuto actual.
	public static int traerMinuto (GregorianCalendar f) {
		return f.get(Calendar.MINUTE);
	}
	
	// Entrega segundo actual.
	public static int traerSegundo (GregorianCalendar f) {
		return f.get(Calendar.SECOND);
	}
	
	//Fecha Valida actual? (no era lo que pedia, pero lo dejo igual como feature)
	public static boolean esFechaValida(GregorianCalendar f) {
		boolean valido = false;
		int cdias = 0;
			if (0<traerAnio(f)&&traerAnio(f)<3000) {
				if (1<=traerMes(f)&&traerMes(f)<=12) {
					if (traerMes(f)==1||traerMes(f)==3||traerMes(f)==5||traerMes(f)==7||traerMes(f)==8||traerMes(f)==10||traerMes(f)==12) {
						cdias = 31;
					}
					if (traerMes(f)==4||traerMes(f)==6||traerMes(f)==9||traerMes(f)==11) {
						cdias = 30;
					}
					if (traerMes(f)==2) {
						if (esBisiesto(f)==true) {
							cdias = 29;
						}
						else {cdias = 28;}
					}
					if (1<=traerDia(f)&&traerDia(f)<=cdias) {
						valido = true;
					}
				}
			}
			return valido;
	}
	
	//Es fecha valida? Se ingresan parametros en el test.
	public static boolean esFechaValida(int dia,int mes,int anio) {
		boolean valido = false;
		int cdias = 0;
			if (0<anio&&anio<3000) {
				if (1<=mes&&mes<=12) {
					if (mes==1||mes==3|mes==5||mes==7||mes==8||mes==10||mes==12) {
						cdias = 31;
					} 
					if (mes==4||mes==6||mes==9||mes==11) {
						cdias = 30;
					}
					if (mes==2) {
						if (esBisiesto(anio)==true) {
							cdias = 29;
						}
						else {cdias = 28;}
					}
					if (1<=dia&&dia<=cdias) {
						valido = true;
					}
				}
			}
			return valido;
	}
	
	// Entrega fecha en formato dd/mm/aaaa.
	public static String traerFechaCorta(GregorianCalendar f) {
		return traerDia(f)+"/"+traerMes(f)+"/"+traerAnio(f);
	} 
	
	// Entrega fecha en formato dd/mm/aaaa.
	public static String traerFechaCortaHora(GregorianCalendar f) {
		return traerDia(f)+"/"+traerMes(f)+"/"+traerAnio(f)+" "+traerHora(f)+":"+traerMinuto(f)+":"+traerSegundo(f);
	}

	public static GregorianCalendar traerFechaProximo (GregorianCalendar f, int diasplus) {
		GregorianCalendar proximo = new GregorianCalendar(traerAnio(f), traerMes(f)-1, traerDia(f));
		proximo.add(Calendar.DAY_OF_MONTH, diasplus);
		return proximo;
	}
	
	// Devuelve una fecha agregandole cierta cantidad de dias (BUG: Siempre me toma el mismo mes inicial, no cambia cantidad de dias)
	/*public static String traerFechaProximo (GregorianCalendar f, int diasplus) {
		int dia = traerDia(f);
		int mes = traerMes(f);
		int anio = traerAnio(f);
		int cdias = 0;
		int acumes = 0;
		int acuanio = 0;
		int diasum = 0;
		int messum = 0;

		if (mes==1||mes==3|mes==5||mes==7||mes==8||mes==10||mes==12) {
			cdias = 31;
		}
		if (mes==4||mes==6||mes==9||mes==11) {
			cdias = 30;
		}
		if (mes==2) {
			if (esBisiesto(anio)==true) {
				cdias = 29;
			}
			else {cdias = 28;}
		}
		while (diasplus>cdias) {
			diasplus = diasplus - cdias;
			acumes = acumes +1;
		}
		
		diasum = dia + diasplus;
		if (diasum>cdias) {
			diasum = diasum - cdias;
			acumes = acumes +1;
		}
		
		while (acumes>12) {
			acumes = acumes - 12;
			acuanio = acuanio +1;
		}
		
		messum = mes + acumes ;
		if (messum>12) {
			messum = messum - 12;
			acuanio = acuanio +1;
		}
		anio = anio + acuanio;
		return diasum+"/"+messum+"/"+anio;
	}*/
	
	// Dice si el dia es laboral o no.
	public static boolean esDiaHabil (GregorianCalendar f) {
		int numdia = traerDiaSemana(f);
		boolean torf = false;
		if(numdia>=2&&numdia<=6) {
			torf = true;
		}
		return torf;
	}
	
	// Trae el nombre del dia.
	public static String traerNombreDia (GregorianCalendar f) {
		int numdia = traerDiaSemana(f);
		String nombre = "Error";
		switch (numdia) {
		case 1:nombre = "Domingo"; break;
		case 2:nombre = "Lunes"; break;
		case 3:nombre = "Martes"; break;
		case 4:nombre = "Miercoles"; break;
		case 5:nombre = "Jueves"; break;
		case 6:nombre = "Viernes"; break;
		case 7:nombre = "Sabado"; break;
		}
		return nombre;
	}
	
	// Trae el nombre del mes.
	public static String traerNombreMes (GregorianCalendar f) {
		int nummes = traerMes(f);
		String nombre = "Error";
		switch (nummes) {
		case 1:nombre = "Enero"; break;
		case 2:nombre = "Febrero"; break;
		case 3:nombre = "Marzo"; break;
		case 4:nombre = "Abril"; break;
		case 5:nombre = "Mayo"; break;
		case 6:nombre = "Junio"; break;
		case 7:nombre = "Julio"; break;
		case 8:nombre = "Agosto"; break;
		case 9:nombre = "Septiembre"; break;
		case 10:nombre = "Octubre"; break;
		case 11:nombre = "Noviembre"; break;
		case 12:nombre = "Diciembre"; break;
		}
		return nombre;
	}
	
	//Trae fecha en formato ej: Domingo 20 de Septiembre del 1994.
	public static String traerFechaLarga (GregorianCalendar f) {
		return traerNombreDia(f)+" "+traerDia(f)+" de "+traerNombreMes(f)+" del "+traerAnio(f);
	}
	
	// Compara 2 fechas ingresadas.
	public static boolean sonFechasIguales(GregorianCalendar f , GregorianCalendar f2) {
		boolean torf = false;
		int dia1 = f.get(Calendar.DAY_OF_MONTH);
		int mes1 = f.get(Calendar.MONTH);
		int anio1 = f.get(Calendar.YEAR);
		int dia2 = f2.get(Calendar.DAY_OF_MONTH);
		int mes2 = f2.get(Calendar.MONTH);
		int anio2 = f2.get(Calendar.YEAR);
		if (anio1 == anio2) {
			if (mes1 == mes2) {
				if (dia1 == dia2) {
					torf = true;
				}
			}
		}
		return torf;
	}
	// Compara 2 fechas y horarios ingresados. 
	public static boolean sonFechasHorasIguales(GregorianCalendar f , GregorianCalendar f2) {
		boolean fechaigual = sonFechasIguales(f,f2);
		boolean torf = false;
		int seg1 = f.get(Calendar.SECOND);
		int min1 = f.get(Calendar.MINUTE);
		int hora1 = f.get(Calendar.HOUR);
		int seg2 = f2.get(Calendar.SECOND);
		int min2 = f2.get(Calendar.MINUTE);
		int hora2 = f2.get(Calendar.HOUR);
		if (fechaigual == true) {
			if (hora1 == hora2) {
				if (min1 == min2) {
					if (seg1 == seg2) {
						torf = true;
					}
				}
			}
		}
		return torf;
	}
	
	// Devuelve la cantidad de dias que tiene un mes, tiene en cuenta los bisiestos.
	public static int traerCantDiasDeUnMes (int anio, int mes) {
		int cdias = 0;
		if (mes==1||mes==3|mes==5||mes==7||mes==8||mes==10||mes==12) {
			cdias = 31;
		}
		if (mes==4||mes==6||mes==9||mes==11) {
			cdias = 30;
		}
		if (mes==2) {
			if (esBisiesto(anio)==true) {
				cdias = 29;
			}
			else {cdias = 28;}
		}
		return cdias;
	}
	

	
	
	
	
	// Redondea un numero ej: 5,26 = 5,3
	public static double aproximar2Decimal (double v) {
		double res = 0;
		res = Math.round(v*100)/100d;
		return res;
	}
	/*
	public static boolean esNumero (char c) {
		boolean torf = false;
		if (c == '0'||c == '1'||c == '2'||c == '3'||c == '4'||c == '5'||c == '6'||c == '7'||c =='8'||c == '9') {
			torf = true;
		}
		return torf;
	}
	
	public static boolean esLetra (char c) {
		boolean torf = false;
		if (c == 'a'||c == 'b'||c == 'c'||c == 'd'||c == 'e'||c == 'f'||c == 'g'||c == 'h'||c == 'i'||c == 'j'||c == 'k'||c == 'l'||c == 'm'||c == 'n'||c == 'ñ'||c == 'o'||c == 'p'||c == 'q'||c == 'r'||c == 's'||c == 't'||c == 'u'||c == 'v'||c == 'w'||c == 'x'||c == 'y'||c == 'z') {
			torf = true;
		}
		return torf;
	}*/
	
	// Verifica si un caracter es un numero.
	public static boolean esNumero (char c) {
		boolean torf = false;
		int ascii;
		ascii = Character.getNumericValue(c);
		if (ascii>=0&&ascii<=9) {
			torf = true;
		}
		return torf;
	}
	
	// Verifica si un caracter es una letra.
	public static boolean esLetra (char c) {
		boolean torf = false;
		int ascii;
		ascii = Character.getNumericValue(c);
		if (ascii>=10&&ascii<=35) {
			torf = true;
		}
		if (c == 'ñ'||c == 'Ñ'||c == 'Ü'||c == 'ü'||c == 'é'||c == 'á'||c == 'í'||c == 'ó'||c == 'ú'||c == 'Á'||c == 'É'||c == 'Í'||c == 'Ó'||c == 'Ú') {
			torf = true;
		}
		return torf;
	}
	
	//Comprueba que una cadena de caracteres sean todos numeros.
	public static boolean esCadenaNumeros (String c) {
		boolean torf = false;
		boolean scan = false;
		int largo;
		int acu=0;
		int i;
		char[] indiv= c.toCharArray(); 
		largo= c.length();
		for(i=0;i<largo;i++) {
			scan = esNumero(indiv[i]);
			if(scan == true) {
				acu++;
			}
		}
		if(largo == acu) {
			torf = true;
		}
		return torf;
	}
	
	
	//Comprueba que una cadena de caracteres sean todas letras.
	public static boolean esCadenaLetras (String c) {
		boolean torf = false;
		boolean scan = false;
		int largo;
		int acu=0;
		int i;
		char[] indiv= c.toCharArray(); 
		largo= c.length();
		for(i=0;i<largo;i++) { 
			scan = esLetra(indiv[i]);
			if(scan == true) {
					acu++;
			}
		}
		if(largo == acu) {
			torf = true;
		}
			return torf;
	}
	
	
}// Fin clase Funciones