package modelo;

public class Numero {
	private int n;
	
	//Constructor
	public Numero(int n) {
		this.n = n;
	}
	
	//Getters y setters
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	//Metodos
	
	public int sumarN() {
		return n+n;
	}
	
	public int multiplicarN() {
		return n*n;
	}
	
	public String esPar() {
		if (n%2 == 0) {
			return "Si";
		}
		else {
			return "No";
			}
		}
	// ACA ME FALTA LA DE LOS NUMEROS PRIMOS
	
	public String convertirAString() {
		return String.valueOf(n);
	}
	
	public double convertirADouble() { //Esto no puede pasar de Int a Double, pero sí de String a Double.(Requiere el metodo anterior)
		return Double.parseDouble(convertirAString());
	}
	
	public double calcularPotencia (int exp) {
		return Math.pow(n, exp);
	}
	
	public String pasarABase2() {
		return Integer.toBinaryString(n);
	}

	
	public int calcularFactorial() {
	int n= getN();
	int res = 1;
	do {
		res = res*n;
		n--;
	} while (n > 1);
	return res;
	
	}
}
