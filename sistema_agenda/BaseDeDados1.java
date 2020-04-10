package entities;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDados1 {
	
	List<Contato> listaContatos;
 	
	
	public BaseDeDados1() {
		// construtor não pode ter void
		listaContatos = new ArrayList<Contato>();
	}
	
	public void adicionarContato(Contato novoContato) {
		listaContatos.add(novoContato);
	}
	
	public boolean verificaContatoAdicao(String nome) {
		
		boolean controle = true;
		nome = nome.toLowerCase();
		
		for(Contato contato : listaContatos) {
			String nomeLista = contato.getNome();
			nomeLista = nomeLista.toLowerCase();
			if(nome.equals(nomeLista)) {
				controle = false;
			}
		}
		return controle;
	}
	
	public boolean verificaContatoRemocao(String nome) {
		
		boolean controle = false;
		nome = nome.toLowerCase();
		
		for(Contato contato : listaContatos) {
			String nomeLista = contato.getNome();
			nomeLista = nomeLista.toLowerCase();
			if(nome.equals(nomeLista)) {
				controle = true;
			}
		}
		return controle;
	}
	
	public void removerContato(String nome) {
		
		nome = nome.toLowerCase();
		
		for(Contato contato : listaContatos) {
			String nomeLista = contato.getNome();
			nomeLista = nomeLista.toLowerCase();
			if(nome.equals(nomeLista)) {
				listaContatos.remove(contato);
				break;
			}
		}
	}
	
	public void alterarContato(String nome, String telefone, String endereco) {
		
		nome = nome.toLowerCase();
		
		for(Contato contato : listaContatos) {
			String nomeLista = contato.getNome();
			nomeLista = nomeLista.toLowerCase();
			if(nome.contentEquals(nomeLista)) {
				contato.setNome(nome);
				contato.setTelefone(telefone);
				contato.setEndereco(endereco);
				break;
			}
		}
	}
	
	public void mostraContato(String nome) {
		
		nome = nome.toLowerCase(); 
		
		for(Contato contato : listaContatos) {
			String nomeLista = contato.getNome();
			nomeLista = nomeLista.toLowerCase();
			if(nomeLista.equals(nome)) {
				nome = nome.toUpperCase();
				String endereco = contato.getEndereco().toUpperCase();
				System.out.printf("\nNome: %s", nome);
				System.out.printf("\nTelefone: %s", contato.getTelefone());
				System.out.printf("\nEndereço: %s%n", endereco);
			}
		}
	}
	
	public void mostrarContatos() {
		for(Contato contato : listaContatos) {
			String nome = contato.getNome().toUpperCase();
			String endereco = contato.getEndereco().toUpperCase();
			System.out.printf("\nNome: %s", nome);
			System.out.printf("\nTelefone: %s", contato.getTelefone());
			System.out.printf("\nEndereço: %s%n", endereco);
		}
	}
}
