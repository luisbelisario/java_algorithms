package entities;

import java.util.ArrayList;
import java.util.List;

public class BancoPessoas {
	
	
	List<Pessoa> listaPessoas;
 	
	
	public BancoPessoas() {
		// construtor não pode ter void
		listaPessoas = new ArrayList<Pessoa>();
	}
	
	public void addPessoa(Pessoa pessoa) {
		listaPessoas.add(pessoa);
	}
	
	public void removerPessoa(String nome) {
		for(Pessoa pessoa : listaPessoas) {
			if(nome == pessoa.getNome()) {
				listaPessoas.remove(pessoa);
				break;
			}
		}
	}
	
	public void mostrarPessoas() {
		System.out.printf("%nDADOS DE NÃO TRABALHADORES%n");
		for(Pessoa pessoa : listaPessoas) {
			
			System.out.printf("Nome: %s%n", pessoa.getNome());
			System.out.printf("CPF: %s%n%n", pessoa.getCpf());
				
		}
	}
}
