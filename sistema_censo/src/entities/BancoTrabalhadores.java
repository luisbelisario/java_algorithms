package entities;

import java.util.ArrayList;
import java.util.List;

public class BancoTrabalhadores {
	
	List<Trabalhador> listaTrabalhadores;
	
	public BancoTrabalhadores() {
		listaTrabalhadores = new ArrayList<Trabalhador>();
	}
	
	public void addTrabalhador(Trabalhador trabalhador) {
		listaTrabalhadores.add(trabalhador);
	}
	
	public void removerTrabalhador(String nome) {
		for(Trabalhador trabalhador : listaTrabalhadores) {
			if(nome == trabalhador.getNome()) {
				listaTrabalhadores.remove(trabalhador);
				break;
			}
		}
	}
	
	public void mostrarTrabalhadores() {
		System.out.printf("%nDADOS DE TRABALHADORES%n");
		for(Trabalhador trabalhador : listaTrabalhadores) {
			
			System.out.printf("Nome: %s%n", trabalhador.getNome());
			System.out.printf("CPF: %s%n", trabalhador.getCpf());
			System.out.printf("CTPS: %s%n", trabalhador.getCtps());
			System.out.printf("Salário Hora: %.2f%n%n", trabalhador.getSalarioHora());	
		}
	}
	
}
