package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.BaseDeDados2;
import entities.Nota;
import exceptions.DomainException;

public class ControleNotas {

	static Scanner input = new Scanner(System.in);
	static BaseDeDados2 bd = new BaseDeDados2();
	static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) throws ParseException, DomainException {
		
		boolean deuErro = false;		
		
		do {
			try {
				System.out.print(
						"Digite quantas notas deseja adicionar: ");
				int n = input.nextInt();
				
				while(n<0) {
					System.out.println(
							"A quantidade de notas deve ser maior que zero!");
					System.out.print(
							"Digite quantas notas deseja adicionar: ");
					n = input.nextInt();
				}
				
				for(int i=0; i<n; i++) {
					Nota novaNota = criarNovaNota();
					bd.adicionarNota(novaNota);
				}
				
				
				bd.mostrarNotas();
				
				int opcao = 1;
				while(opcao != 0) {
					System.out.println("\nO bloco de notas tem as seguintes opções: "
							+ "\n[1] - Adicionar tarefa"
							+ "\n[2] - Remover tarefa"
							+ "\n[3] - Consultar tarefa"
							+ "\n[4] - Realizar tarefa"
							+ "\n[5] - Alterar tarefa"
							+ "\n[6] - Mostrar tarefas"
							+ "\n[0] - Finalizar Bloco de Notas");
					
					System.out.print("Digite a opção desejada: ");
					opcao = input.nextInt();
					input.nextLine();
					
					
					if (opcao < 0 || opcao > 6) {
						System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE!");
						continue;
					}
					else if(opcao == 1) {
						Nota novaNota = criarNovaNota();
						bd.adicionarNota(novaNota);
					}
					else if(opcao == 2) {
						System.out.print(
								"Digite o Id da tarefa que deseja remover: ");
						int id = input.nextInt();
						bd.removerNota(id);
						System.out.print("\nTAREFA REMOVIDA COM SUCESSO!\n");
					}
					else if(opcao == 3) {
						System.out.print("Digite o id da tarefa que deseja consultar: ");
						int id = input.nextInt();
						bd.mostrarNota(id);
					}
					else if(opcao == 4) {
						System.out.print("Digite o id da tarefa que deseja realizar: ");
						int id = input.nextInt();
						bd.realizarTarefa(id);
						System.out.println("\nTAREFA REALIZADA COM SUCESSO!\n");
					}
					else if(opcao == 5) {
						System.out.print("Digite o id da tarefa que deseja alterar: ");
						int id = input.nextInt();
						input.nextLine();
						System.out.print("Digite a nova tarefa: ");
						String desc = input.nextLine();
						System.out.print("Digite a nova data limite da tarefa: ");
						Date data = sdf1.parse(input.next());
						bd.alterarNota(id, desc, data);
						System.out.println("\nTAREFA ALTERADA COM SUCESSO!\n");
					}
					else if(opcao == 6) {
						bd.mostrarNotas();
					}
					else {
						System.out.println("\nBLOCO DE NOTAS FINALIZADO!");
					}
					
				}
			}
			catch (InputMismatchException e) {
				System.out.println(
						"Erro no preenchimento dos dados! Tente novamente!");
				deuErro = true;
			}
			catch (NullPointerException e) {
				System.out.println(
						"Dados incorretos! Tente novamente!");
				deuErro = true;
			}
		} while(deuErro);
	}
	
	public static Nota criarNovaNota() throws ParseException, DomainException {
			boolean deuErro = false;
			do {
				try {
					System.out.print("Digite o id da tarefa: ");
					int id = input.nextInt();
					input.nextLine();
					System.out.print("Digite a descrição da tarefa: ");
					String desc = input.nextLine();
					System.out.print("Digite a data limite da tarefa: ");
					Date data = sdf1.parse(input.next());
					boolean realizada = false;
					
					return new Nota(id, desc, data, realizada);
				}
				catch (InputMismatchException e) {
					System.out.println(
							"Erro no preenchimento dos dados! Tente novamente!");
					input.nextLine();
					deuErro = true;
					return null;
				}
				catch (DomainException e) {
					System.out.println(e.getMessage());
					input.nextLine();
					deuErro = true;
					return null;
				}
			} while(deuErro);
	}

}
