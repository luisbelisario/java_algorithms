package application;

import java.util.Locale;
import java.util.Scanner;

import entities.TrabalhadorAssalariado;
import entities.TrabalhadorHora;

public class ControleTrabalhador {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Locale.setDefault(Locale.US);
		input.useLocale(Locale.US);
		
		System.out.print("Digite o nome do trabalhador: ");
		String nome = input.nextLine();
		System.out.print("Digite a CTPS do trabalhador: ");
		String ctps = input.nextLine();
		
		System.out.print("Digite o valor do salário-hora do trabalhador: ");
		Double salarioHora = input.nextDouble();
		input.nextLine();
		
		System.out.print("O trabalhador é horista ou assalariado? ");
		String statusTrab = input.nextLine().toUpperCase();
		
		if(statusTrab.equals("ASSALARIADO")) {
			TrabalhadorAssalariado trabalhador = new TrabalhadorAssalariado(nome, ctps, salarioHora);
			System.out.println(trabalhador.toString());
		}
		else {
			TrabalhadorHora trabalhador = new TrabalhadorHora(nome, ctps, salarioHora);
			System.out.print("Digite o número de horas trabalhadas: ");
			int horas = input.nextInt();
			System.out.println(trabalhador.toString(horas));
		}
		
		input.close();
		
	}

}
