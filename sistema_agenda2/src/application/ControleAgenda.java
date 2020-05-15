package application;

import java.util.Scanner;

import entities.CNPJ;
import entities.CPF;
import entities.Documento;
import entities.InterfacePF;
import entities.InterfacePJ;
import entities.InterfaceUsuario;
import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class ControleAgenda {
	
	
	static Scanner input = new Scanner(System.in);
	static InterfaceUsuario iPF = new InterfacePF();
	static InterfaceUsuario iPJ = new InterfacePJ();
	
	public static void main(String[] args) {
		
		System.out.print(
				"Deseja cadastrar Pessoas Físicas? S/N: ");
		String resp = input.nextLine().toUpperCase();
		if(resp.equals("S")) {
			cadastrarPF();
		}
		
		System.out.print(
				"Deseja cadastrar Pessoas Jurídicas? S/N: ");
		resp = input.nextLine().toUpperCase();
		if(resp.equals("S")) {
			cadastrarPJ();
		}
		
		System.out.print("Deseja executar mais alguma operação? S/N: ");
		resp = input.nextLine().toUpperCase();
		
		while(resp.equals("S")) {
			System.out.print("Deseja executar alguma operação com Pessoa Física? S/N: ");
			resp = input.nextLine().toUpperCase();
			if(resp.equals("S")) {
				System.out.println("A agenda possui as seguintes opções para Pessoa Física"
						+ "\n[1] - Adicionar Pessoa Física"
						+ "\n[2] - Mostrar todas as Pessoas Físicas"
						+ "\n[3] - Buscar uma Pessoa Física"
						+ "\n[4] - Remover uma Pessoa Física"
						+ "\n[5] - Alterar uma Pessoa Física"
						+ "\n[6] - Buscar telefone de uma Pessoa Física"
						+ "\n[7] - Buscar endereço de uma Pessoa Física"
						+ "\n[8] - Buscar CPF de uma Pessoa Física");
				System.out.print("Digite a opção desejada: ");
				int opcao = input.nextInt();
				input.nextLine();
				
				if(opcao == 1) {
					cadastrarPF();
				}
				else if(opcao == 2) {
					iPF.mostraContatos();
				}
				else if(opcao == 3) {
					System.out.print(
							"Digite o número do CPF da pessoa que deseja buscar: ");
					String numDoc = input.nextLine();
					iPF.buscarContato(numDoc);
				}
				else if(opcao == 4) {
					System.out.print(
							"Digite o número do CPF da pessoa que deseja remover: ");
					String numDoc = input.nextLine();
					iPF.removerContato(numDoc);
				}
				else if(opcao == 5) {
					alterarPF();
				}
				else if(opcao == 6) {
					System.out.print(
							"Digite o número do CPF da pessoa que deseja buscar o telefone: ");
					String numDoc = input.nextLine();
					if(iPF.validaAlterarContato(numDoc)) {
						System.out.printf("O endereço da pessoa buscada é: %s%n", iPF.buscaTelefone(numDoc));
					}
					else {
						System.out.println("Contato não localizado!");
					}
				}
				else if(opcao == 7) {
					System.out.print(
							"Digite o número do CPF da pessoa que deseja buscar o endereço: ");
					String numDoc = input.nextLine();
					if(iPF.validaAlterarContato(numDoc)) {
						System.out.printf("O endereço da pessoa buscada é: %s%n", iPF.buscaEndereco(numDoc));
						
					}
					else {
						System.out.println("Contato não localizado!");
					}
				}
				else if(opcao == 8) {
					System.out.print(
							"Digite o nome da pessoa que deseja buscar o CPF: ");
					String nome = input.nextLine();
					if(iPF.validaCPF(nome)) {
						System.out.printf("O CPF da pessoa buscada é: %s%n", iPF.buscaCPF(nome));
						
					}
					else {
						System.out.println("Contato não localizado!");
					}
				}
				
			}
			
			System.out.print("Deseja executar alguma operação com Pessoa Jurídica? S/N: ");
			resp = input.nextLine().toUpperCase();
			if(resp.equals("S")) {
				System.out.println("A agenda possui as seguintes opções para Pessoa Jurídica"
						+ "\n[1] - Adicionar Pessoa Jurídica"
						+ "\n[2] - Mostrar todas as Pessoas Jurídicas"
						+ "\n[3] - Buscar uma Pessoa Jurídica"
						+ "\n[4] - Buscar o responsável por uma Pessoa Jurídica"
						+ "\n[5] - Remover uma Pessoa Jurídica"
						+ "\n[6] - Alterar uma Pessoa Jurídica"
						+ "\n[7] - Buscar telefone de uma Pessoa Jurídica"
						+ "\n[8] - Buscar endereço de uma Pessoa Jurídica"
						+ "\n[9] - Buscar CNPJ de uma Pessoa Jurídica");
			}
			System.out.print("Digite a opção desejada: ");
			int opcao = input.nextInt();
			input.nextLine();
			
			if(opcao == 1) {
				cadastrarPJ();
			}
			else if(opcao == 2) {
				iPJ.mostraContatos();
			}
			else if(opcao == 3) {
				System.out.print(
						"Digite o número do CNPJ da pessoa que deseja buscar: ");
				String numDoc = input.nextLine();
				iPJ.buscarContato(numDoc);
			}
			else if(opcao == 4) {
				System.out.print(
						"Digite o número do CNPJ da pessoa que deseja buscar o responsável: ");
				String numDoc = input.nextLine();
				iPJ.buscaResponsavel(numDoc);
			}
			else if(opcao == 5) {
				System.out.print(
						"Digite o número do CNPJ da pessoa que deseja remover: ");
				String numDoc = input.nextLine();
				iPJ.removerContato(numDoc);
			}
			else if(opcao == 6) {
				alterarPJ();
			}
			else if(opcao == 7) {
				System.out.print(
						"Digite o número do CNPJ da pessoa que deseja buscar o telefone: ");
				String numDoc = input.nextLine();
				if(iPJ.validaAlterarContato(numDoc)) {
					System.out.printf("O endereço da pessoa buscada é: %s%n", iPJ.buscaTelefone(numDoc));
				}
				else {
					System.out.println("Contato não localizado!");
				}
			}
			else if(opcao == 8) {
				System.out.print(
						"Digite o número do CNPJ da pessoa que deseja buscar o endereço: ");
				String numDoc = input.nextLine();
				if(iPJ.validaAlterarContato(numDoc)) {
					System.out.printf("O endereço da pessoa buscada é: %s%n", iPJ.buscaEndereco(numDoc));
					
				}
				else {
					System.out.println("Contato não localizado!");
				}
			}
			else if(opcao == 9) {
				System.out.print(
						"Digite o nome da pessoa que deseja buscar o CNPJ: ");
				String nome = input.nextLine();
				if(iPJ.validaCNPJ(nome)) {
					System.out.printf("O CNPJ da pessoa buscada é: %s%n", iPJ.buscaCPF(nome));
					
				}
				else {
					System.out.println("Contato não localizado!");
				}
			}
			else {
				System.out.println("Opção inválida!");
			}
			System.out.print("Deseja executar mais alguma operação? S/N: ");
			resp = input.nextLine().toUpperCase();
		}
		System.out.println("Programa Finalizado!");
	}
	
	public static void cadastrarPF() {
		System.out.print(
				"Quantas pessoas físicas deseja cadastar? ");
		int n = input.nextInt();
		input.nextLine();
		
		for(int i=0; i<n; i++) {
			System.out.print("Digite o nome: ");
			String nome = input.nextLine();
			System.out.print("Digite o número do CPF: ");
			String num = input.nextLine();
			Documento numCPF = new CPF(num);
			System.out.print("Digite o telefone: ");
			String telefone = input.nextLine();
			System.out.print("Digite o endereço: ");
			String endereco = input.nextLine();
			
			Pessoa pessoaFisica = new PessoaFisica(nome, numCPF, telefone, endereco, null, null);
			iPF.addPessoa(pessoaFisica);
		}
	}
	
	public static void cadastrarPJ() {
		System.out.print("Quantas Pessoas Jurídicas deseja cadastrar? ");
		int n = input.nextInt();
		input.nextLine();
		
		for(int i=0; i<n; i++) {
			System.out.println("\nDIGITE OS DADOS DA EMPRESA");
			System.out.print("Nome: ");
			String nomePJ = input.nextLine();
			System.out.print("Número do CNPJ: ");
			String numPJ = input.nextLine();
			Documento numCNPJ = new CNPJ(numPJ);
			System.out.print("Telefone: ");
			String telefonePJ = input.nextLine();
			System.out.print("Endereço: ");
			String enderecoPJ = input.nextLine();
			
			System.out.println("\nDIGITE OS DADOS DO RESPONSÁVEL PELA EMPRESA");
			System.out.print("Nome: ");
			String nomePF = input.nextLine();
			System.out.print("Número do CPF: ");
			String numPF = input.nextLine();
			Documento numCPF = new CNPJ(numPF);
			
			
			Pessoa pessoaJuridica = new PessoaJuridica(nomePJ, numCNPJ, telefonePJ, enderecoPJ, nomePF, numCPF);
			iPJ.addPessoa(pessoaJuridica);
		}
	}
	
	public static void alterarPF() {
		System.out.print(
				"Digite o CPF da pessoa que deseja alterar: ");
		String numDoc = input.nextLine();
		if(iPF.validaAlterarContato(numDoc)) {
			iPF.removerContato(numDoc);
			cadastrarPF();
			
		}
		else {
			System.out.println("Contato não localizado!");
		}
	}
	
	public static void alterarPJ() {
		System.out.print(
				"Digite o CNPJ da pessoa que deseja alterar: ");
		String numDoc = input.nextLine();
		if(iPF.validaAlterarContato(numDoc)) {
			iPJ.removerContato(numDoc);
			cadastrarPJ();
			
		}
		else {
			System.out.println("Contato não localizado!");
		}
	}
}
