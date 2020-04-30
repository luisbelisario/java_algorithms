package application;

import java.util.Locale;
import java.util.Scanner;

import entities.BancoPessoas;
import entities.BancoTrabalhadores;
import entities.Pessoa;
import entities.Trabalhador;
import entities.TrabalhadorAssalariado;
import entities.TrabalhadorAutonomo;
import entities.TrabalhadorHora;

public class ControleSenso {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		input.useLocale(Locale.US);
		BancoPessoas novaPessoa = null;
		BancoTrabalhadores novoTrab = null;
		
		System.out.println("SISTEMA CENSO");
		System.out.print("Deseja cadastrar uma nova família? Sim/Não: ");
		String respWhile = input.nextLine().toUpperCase();
		
		while(respWhile.equals("SIM")) {
			System.out.println("Cadastre a família: ");
			System.out.print("Quantas pessoas na família? ");
			int n = input.nextInt();
			input.nextLine();
			
			novaPessoa = new BancoPessoas(); 
			novoTrab = new BancoTrabalhadores();
			for(int i=1; i<=n; i++) {
				System.out.printf("Cadastre a %dª pessoa: %n", i);
				System.out.print("Digite o nome: ");
				String nome = input.nextLine();
				System.out.print("Digite o número do CPF: ");
				String cpf = input.nextLine();
				
				System.out.print("Essa pessoa tem trabalho? SIM/NÃO: ");
				String respFor = input.nextLine().toUpperCase();
				
				if(respFor.equals("SIM")) {
					System.out.print("Digite o número da CTPS: ");
					String ctps = input.nextLine();
					System.out.print("Digite o valor do Salário Hora: ");
					Double salarioHora = input.nextDouble();
					input.nextLine();
					System.out.print("É Assalariado, Horista ou Autonomo: ");
					respFor = input.nextLine().toUpperCase();
					if(respFor.equals("ASSALARIADO")) {
						Trabalhador trabalhador = new TrabalhadorAssalariado(nome, cpf, ctps, salarioHora);
						novoTrab.addTrabalhador(trabalhador);
					}
					else if(respFor.equals("HORISTA")) {
						Trabalhador trabalhador = new TrabalhadorHora(nome, cpf, ctps, salarioHora);
						novoTrab.addTrabalhador(trabalhador);
					}
					else if(respFor.equals("AUTONOMO")) {
						Trabalhador trabalhador = new TrabalhadorAutonomo(nome, cpf, ctps, salarioHora);
						novoTrab.addTrabalhador(trabalhador);
					}
				}
				else {
					Pessoa pessoa = new Pessoa(nome, cpf);
					novaPessoa.addPessoa(pessoa);
				}
			}
			System.out.print("Deseja cadastrar uma nova família? Sim/Não: ");
			respWhile = input.nextLine().toUpperCase();
		}
		
		System.out.print("Deseja mostrar os não trabalhadores? Sim/Não: ");
		String resp = input.nextLine().toUpperCase();
		if(resp.equals("SIM")) {
			novaPessoa.mostrarPessoas();
		}
		
		System.out.printf("Deseja mostrar os trabalhadores? Sim/Não: ");
		resp = input.nextLine().toUpperCase();
		if(resp.equals("SIM")) {
			novoTrab.mostrarTrabalhadores();
		}
		
		System.out.println("Programa Finalizado!");
		input.close();
		
	}

}
