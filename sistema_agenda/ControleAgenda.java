package application;

import java.util.Scanner;

import entities.BaseDeDados1;
import entities.Contato;

public class ControleAgenda {

	static Scanner input = new Scanner(System.in);
	static BaseDeDados1 bd = new BaseDeDados1();
	
	
	public static void main(String[] args) {
		
		int n;
		System.out.print(
				"Digite o número de contatos que deseja adicionar: ");
		n = input.nextInt();
		input.nextLine();
		
		for(int i=0; i<n; i++) {
			Contato novoContato = criarContato();
			bd.adicionarContato(novoContato);
		}
		
		int opcao = 1;
		while(opcao != 0) {
			System.out.println("\nA agenda tem as seguintes opções: "
					+ "\n[1] - Adicionar contato"
					+ "\n[2] - Remover contato"
					+ "\n[3] - Consultar contato"
					+ "\n[4] - Alterar contato"
					+ "\n[5] - Mostrar contatos"
					+ "\n[0] - Finalizar Agenda");
			
			System.out.print("Digite a opção desejada: ");
			opcao = input.nextInt();
			input.nextLine();
			if (opcao < 0 || opcao > 5) {
				System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE!");
				continue;
			}
			else if(opcao == 1) {
				System.out.print(
						"Digite o nome para verificação: ");
				String nome = input.nextLine();
				if(bd.verificaContatoAdicao(nome)) {
					Contato novoContato = criarContato();
					bd.adicionarContato(novoContato);
				}
				else {
					System.out.println(
							"Impossível adicionar! Contato já existente!");
				}
			}
			else if(opcao == 2) {
				System.out.print(
						"Digite o nome para verificação: ");
				String nome = input.nextLine();
				if(bd.verificaContatoRemocao(nome)) {
					System.out.println(
							"NOME ENCONTRADO! EFETUANDO A REMOÇÃO...");
					bd.removerContato(nome);
					System.out.println("CONTATO REMOVIDO COM SUCESSO!");
				}
				else {
					System.out.println(
							"NOME NÃO ENCONTRADO! TENTE NOVAMENTE!");
				}
			}
			else if(opcao == 3) {
				System.out.print(
						"Digite o nome para verificação: ");
				String nome = input.nextLine();
				if(bd.verificaContatoRemocao(nome)) {
					System.out.println(
							"NOME ENCONTRADO!");
					bd.mostraContato(nome);
				}
				else {
					System.out.println(
							"NOME NÃO ENCONTRADO! TENTE NOVAMENTE!");
				}
			}
			else if(opcao == 4) {
				System.out.print(
						"Digite o nome para verificação: ");
				String nome = input.nextLine();
				if(bd.verificaContatoRemocao(nome)) {
					System.out.println(
							"NOME ENCONTRADO!");
					System.out.print(
							"Digite o novo nome do contato: ");
					nome = input.nextLine();
					System.out.print("Digite o telefone: ");
					String telefone = input.nextLine();
					System.out.print("Digite o endereço: ");
					String endereco = input.nextLine();
					
					bd.alterarContato(nome, telefone, endereco);
					System.out.println(
							"CONTATO ALTERADO COM SUCESSO!");
				}
			}
			else if(opcao == 5) {
				System.out.println("\n==CONTATOS DA AGENDA==");
				bd.mostrarContatos();
			}
			else if(opcao == 0) {
				System.out.println("AGENDA FINALIZADA!");
			}
			
		}
		
	}
	
	public static Contato criarContato() {
		System.out.print("Digite o nome para adicionar à agenda: ");
		String nome = input.nextLine();
		nome = nome.toLowerCase();
		System.out.print("Digite o telefone: ");
		String telefone = input.nextLine();
		System.out.print("Digite o endereço: ");
		String endereco = input.nextLine();
			
		return new Contato(nome, telefone, endereco);
	 }
		
		
	}
	
