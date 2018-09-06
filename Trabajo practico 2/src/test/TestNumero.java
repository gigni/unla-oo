package test;

import modelo.Numero;

public class TestNumero {

	public static void main(String[] args) {
	
		Numero n1 = new Numero(6);
		Numero n2 = new Numero(0);

		System.out.println("El primer numero es: "+n1.getN());
		System.out.println("El segundo numero es: "+n2.getN());
		
		System.out.println("1) La suma entre el primer numero es: "+n2.sumarN());
		System.out.println("2) La multiplicacion entre el primer numero es: "+n1.multiplicarN());
		System.out.println("3) ¿El numero es par? "+n1.esPar());
		System.out.println("4) ¿El numero es primo? NO IMPLEMENTADO");
		System.out.println("5) Convertir el numero en caracter: "+n1.convertirAString());
		System.out.println("6) Convertir el numero en double: "+n1.convertirADouble());
		System.out.println("7) Calcular la potencia: "+n1.calcularPotencia(2));
		System.out.println("8) Pasar el numero a base 2: "+n1.pasarABase2());
		System.out.println("8) El factorial es: "+n1.calcularFactorial());
		
	}

}
