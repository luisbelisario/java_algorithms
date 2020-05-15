package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BaseDeDadosJ {
	
private static Integer id = 1;
	
	List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	Map<Integer, List<Pessoa>> mapaPessoas = new HashMap<Integer, List<Pessoa>>();
	
	public void addPessoa(Pessoa pessoa) {
		listaPessoas.add(pessoa);
		mapaPessoas.put(id, listaPessoas);
		BaseDeDadosJ.id++;
	}
	
	public void mostraContatos() {
		for(Entry<Integer, List<Pessoa>> entry : mapaPessoas.entrySet()) {
			Integer id = entry.getKey();
			List<Pessoa> listaPessoas = entry.getValue();
			System.out.printf("Id contato: %d%n", id);
			for(Pessoa p : listaPessoas) {
				System.out.printf("Nome contato: %s%n", p.getNome());
				System.out.printf("Nº CNPJ: %s%n", p.getNumDocumento().getNumero());
				System.out.printf("Nº do Telefone: %s%n", p.getTelefone());
				System.out.printf("Endereço: %s%n", p.getEndereco());
				System.out.printf("Nome do responsável: %s%n", p.getNomeResponsavel());
			}
		}
	}
	
	public void buscarContato(String num) {
		boolean valida = false;
		for(Pessoa p : listaPessoas) {
			if(num.equals((String) p.getNumDocumento().getNumero())) {
				valida = true;
				System.out.println("Dados da pessoa buscada");
				System.out.printf("Nome contato: %s%n", p.getNome());
				System.out.printf("Nº CNPJ: %s%n", p.getNumDocumento().getNumero());
				System.out.printf("Nº do Telefone: %s%n", p.getTelefone());
				System.out.printf("Endereço: %s%n", p.getEndereco());
				System.out.printf("Nome do responsável: %s%n", p.getNomeResponsavel());
			}
		}
		if(valida == false) {
			System.out.println("Documento não encontrado na base de dados");
		}
	}
	
	public void removePessoa(String numDoc) {
		for(Entry<Integer, List<Pessoa>> entry : mapaPessoas.entrySet()) {
			List <Pessoa> pessoa = entry.getValue();
			Integer id = entry.getKey();
			for(Pessoa p : pessoa) {
				String numDocInterno = (String) p.getNumDocumento().getNumero();
				if(numDoc.equals(numDocInterno)) {
					mapaPessoas.remove(id);
					mapaPessoas.remove(pessoa);
					System.out.println("Contato removido com sucesso!");
				}
			}
		}
	}
	
	public boolean validaAlterarPessoa(String numDoc) {
		boolean controle = false;
		for(Entry<Integer, List<Pessoa>> entry : mapaPessoas.entrySet()) {
			List <Pessoa> pessoa = entry.getValue();
			for(Pessoa p : pessoa) {
				String numDocInterno = p.getNumDocumento().getNumero();
				if(numDoc.equals(numDocInterno)) {
					controle = true;
				}
			}
		}
		return controle;
	}
	
	public boolean validaCNPJ(String nome) {
		boolean controle = false;
		for(Entry<Integer, List<Pessoa>> entry : mapaPessoas.entrySet()) {
			List <Pessoa> pessoa = entry.getValue();
			for(Pessoa p : pessoa) {
				String nomeInterno = p.getNome();
				if(nome.equals(nomeInterno)) {
					controle = true;
				}
			}
		}
		return controle;
	}
	
	public String buscaTelefone(String numDoc) {
		String tel = "";
		for(Entry<Integer, List<Pessoa>> entry : mapaPessoas.entrySet()) {
			List <Pessoa> pessoa = entry.getValue();
			for(Pessoa p : pessoa) {
				String numDocInterno = p.getNumDocumento().getNumero();
				if(numDoc.equals(numDocInterno)) {
					tel = p.getTelefone();
				}
			}
		}
		return tel;
	}
	
	public String buscaEndereco(String numDoc) {
		String end = "";
		for(Entry<Integer, List<Pessoa>> entry : mapaPessoas.entrySet()) {
			List <Pessoa> pessoa = entry.getValue();
			for(Pessoa p : pessoa) {
				String numDocInterno = p.getNumDocumento().getNumero();
				if(numDoc.equals(numDocInterno)) {
					end = p.getEndereco();
				}
			}
		}
		return end;
	}
	
	public String buscaCNPJ(String nome) {
		String cnpj = "";
		for(Entry<Integer, List<Pessoa>> entry : mapaPessoas.entrySet()) {
			List <Pessoa> pessoa = entry.getValue();
			for(Pessoa p : pessoa) {
				String nomeInterno = p.getNome();
				if(nome.equals(nomeInterno)) {
					cnpj = p.getNumDocumento().getNumero();
				}
			}
		}
		return cnpj;
	}
	
	public void buscaResponsavel(String numDoc) {
		for(Entry<Integer, List<Pessoa>> entry : mapaPessoas.entrySet()) {
			List<Pessoa> pessoa = entry.getValue();
			for(Pessoa p : pessoa) {
				if(numDoc.equals(p.getNumDocumento().getNumero())) {
					System.out.println(p.getNomeResponsavel());
				}
			}
		}
	}
}
