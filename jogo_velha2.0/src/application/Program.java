package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.HistoricoJogadas;
import entities.Jogador;
import entities.Jogo;
import exceptions.DomainException;

public class Program {

	
	static Scanner input = new Scanner(System.in);
	static HistoricoJogadas mj = new HistoricoJogadas();
	static String[] moves;
	static Jogo jogo;
	
	public static void main(String[] args) throws DomainException {
		String novoInicio = "S";
		
		while(novoInicio.contentEquals("S")) {
			
			boolean deuErro = false;
			
			do {
				try {
					jogo = new Jogo();
					System.out.println("\n JOGO DA VELHA");
					jogo.printarTabuleiro();
					
					System.out.print("\nJogador 1 digite seu nome: ");
					String nome1 = input.nextLine().toUpperCase();
					while(!(nome1.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]*"))) {
					     System.out.println(
					    		 "Nome inválido! Deve ser apenas um nome, o nome deve conter apenas letras e não pode conter espaços em branco!");
					     System.out.print("\nJogador 1 digite seu nome: ");
					     nome1 = input.nextLine().toUpperCase();
					}
					System.out.print("Jogador 1 escolha seu símbolo (O ou X): ");
					String simb1 = input.nextLine().toUpperCase();
					
					while(simb1.equals("O") == false && simb1.equals("X") == false) {
						System.out.println("Escolha inválida! Deve ser O ou X! Tente novamente!");
						System.out.print("Jogador 1 escolha seu símbolo (O ou X): ");
						simb1 = input.nextLine().toUpperCase();
					}
					Jogador jogador1 = new Jogador(nome1, simb1);
					System.out.print(jogador1.getNome() + " seu símbolo será o " + jogador1.getSimbolo());
					
					System.out.print("\nJogador 2 digite seu nome: ");
					String nome2 = input.nextLine().toUpperCase();
					while(!(nome2.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]*"))) {
					     System.out.println(
					    		 "Nome inválido! Deve ser apenas um nome, o nome deve conter apenas letras e não pode conter espaços em branco!");
					     System.out.print("\nJogador 2 digite seu nome: ");
					     nome2 = input.nextLine().toUpperCase();
					}
					String simb2 = "";
					if(jogador1.getSimbolo().contentEquals("O")) {
						simb2 = "X";
					}
					else {
						simb2 = "O";
					}
					Jogador jogador2 = new Jogador(nome2, simb2);
					System.out.print(jogador2.getNome() + " seu símbolo será o " + jogador2.getSimbolo() + "\n");
					
					System.out.println("\nBOM JOGO!");
					
					int rodadas = 0;
					
					while(rodadas < 9) {
						
						System.out.printf("%n%s digite o movimento 0 a 2,0 a 2: ", jogador1.getNome());
						String movString = input.nextLine();
						while(!(movString.matches("\\d{1},\\d{1}"))) {
							System.out.println(
						    		 "Entrada inválida! O movimento deve ser composto por dois números de 0 a 2, separados por vírgula e sem espaços em branco!");
							System.out.printf("%n%s digite o movimento 0 a 2,0 a 2: ", jogador1.getNome());
							movString = input.nextLine(); 
						}
						receberMovimento(jogador1, movString, rodadas);
						rodadas += 1;
						if(jogo.checaRodadas(rodadas)) {
							break;
						}
						if(jogo.checaVencedor(jogador1)) {
							System.out.println();
							System.out.println(jogador1.getNome() + " venceu!");
							break;
						};
						
						System.out.println("Rodadas: " + rodadas);
						
						System.out.printf("%n%s digite o movimento 0 a 2,0 a 2: ", jogador2.getNome());
						movString = input.nextLine();
						while(!(movString.matches("\\d{1},\\d{1}"))) {
							System.out.println(
						    		 "Entrada inválida! O movimento deve ser composto por dois números de 0 a 2, separados por vírgula e sem espaços em branco!");
							System.out.printf("%n%s digite o movimento 0 a 2,0 a 2: ", jogador2.getNome());
							movString = input.nextLine();
						}
						receberMovimento(jogador2, movString, rodadas);
						rodadas += 1;
						if(jogo.checaRodadas(rodadas)) {
							break;
						}
						if(jogo.checaVencedor(jogador2)) {
							System.out.println();
							System.out.println(jogador2.getNome() + " venceu!");
							break;
						};
						
						System.out.println("Rodadas: " + rodadas);
					}
					
					if(jogo.checaVencedor(jogador1) == false && jogo.checaVencedor(jogador2) == false) {
						System.out.println("\nNinguém venceu!");
					}
				}
				catch (InputMismatchException e) {
					System.out.println("Erro no preenchimento dos dados! Tente novamente!");
					deuErro = true;
					break;
				}
				catch (NumberFormatException e) {
					System.out.println("Erro no preenchimento dos dados! Tente novamente!");
					deuErro = true;
					break;
				}
				catch (NullPointerException e) {
					System.out.println("Algo deu errado! Contate o administrador!");
					System.exit(1);
				}
			} while(deuErro);
			
			mj.mostrarJogadas();
			
			System.out.print("Deseja iniciar um novo jogo? S/N: ");
			novoInicio = input.nextLine().toUpperCase();
			
			while(novoInicio.equals("S") == false && novoInicio.equals("N") == false) {
				System.out.println("Escolha inválida! Digite S ou N! Tente novamente!");
				System.out.print("\nDeseja iniciar um novo jogo? S/N: \n");
				novoInicio = input.nextLine().toUpperCase();
			}
		}
		
		System.out.println("Programa Finalizado!");
	}
	
	public static void receberMovimento(Jogador jogador, String movString, int rodadas) {
		moves = movString.split(",");
		
		int mov1 = Integer.parseInt(moves[0]);
		int mov2 = Integer.parseInt(moves[1]);
		
		boolean deuErro = false;
		do {
			try {
				while(jogo.checaMovimentoValido(mov1, mov2) == false) {
					System.out.println("Movimento inválido! Ambas as casas devem ser números de 0 a 2!");
					System.out.printf("%n%s digite o movimento 0 a 2,0 a 2: ", jogador.getNome());
					movString = input.nextLine();
					while(!(movString.matches("\\d{1},\\d{1}"))) {
						System.out.println(
					    		 "Entrada inválida! O movimento deve ser composto por dois números de 0 a 2, separados por vírgula e sem espaços em branco!");
						System.out.printf("%n%s digite o movimento 0 a 2,0 a 2: ", jogador.getNome());
						movString = input.nextLine();
					}
					moves = movString.split(",");
					mov1 = Integer.parseInt(moves[0]);
					mov2 = Integer.parseInt(moves[1]);
		
				};
				
				while(jogo.checaCasaVazia(mov1, mov2) == false) {
					System.out.println("Movimento inválido! Casa já ocupada!");
					System.out.printf("%n%s digite o movimento 0 a 2,0 a 2: ", jogador.getNome());
					movString = input.nextLine();
					while(!(movString.matches("\\d{1},\\d{1}"))) {
						System.out.println(
					    		 "Entrada inválida! O movimento deve ser composto por dois números de 0 a 2, separados por vírgula e sem espaços em branco!");
						System.out.printf("%n%s digite o movimento 0 a 2,0 a 2: ", jogador.getNome());
						movString = input.nextLine();
					}
					moves = movString.split(",");
					mov1 = Integer.parseInt(moves[0]);
					mov2 = Integer.parseInt(moves[1]);
				};
				
				if(jogo.checaMovimentoValido(mov1, mov2) && jogo.checaCasaVazia(mov1, mov2)) {
					jogo.fazerMovimento(jogador, mov1, mov2);
					String movString1 = Integer.toString(mov1);
					String movString2 = Integer.toString(mov2);
					String rodString = Integer.toString(rodadas);
					
					mj.addJogada("Jogada " + rodString + ": " + jogador.getSimbolo(), "em " + movString1 + "," + movString2);
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Erro no preenchimento dos dados! Tente novamente!");
				deuErro = true;
				break;
			}
			catch (NumberFormatException e) {
				System.out.println("Erro no preenchimento dos dados! Tente novamente!");
				deuErro = true;
				break;
			}
			catch (NullPointerException e) {
				System.out.println("Algo deu errado! Contate o administrador!");
				System.exit(1);
			}
		} while(deuErro);
	}
}
