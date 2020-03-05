package estruturaSequencial;

import java.util.Locale;
import java.util.Scanner;

public class CadastroPecas {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		double valor1, valor2, num1, num2, total;
		
		
		num1 = input.nextDouble();
		valor1 = input.nextDouble();
		num2 = input.nextDouble();
		valor2 = input.nextDouble();
		
		total = calcula_total(num1, valor1, num2, valor2);
		
		System.out.printf("VALOR A PAGAR: R$ %.2f", total);
		
		input.close();

	}
	
	public static double calcula_total(double num1, double valor1, double num2, double valor2) {
		double total;
		total = (num1 * valor1) + (num2*valor2);
		return total;
	}
}
