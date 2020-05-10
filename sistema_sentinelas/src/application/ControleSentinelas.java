package application;

import java.util.Scanner;

import entities.DataSentinelas;
import entities.Sentinela1;
import entities.Sentinela2;
import entities.Sentinela3;
import entities.Sentinela4;

public class ControleSentinelas {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		DataSentinelas dataSentinelas = new DataSentinelas();
		
		dataSentinelas.addSentinela(new Sentinela1());
		dataSentinelas.addSentinela(new Sentinela2());
		dataSentinelas.addSentinela(new Sentinela3());
		dataSentinelas.addSentinela(new Sentinela4());
		
		System.out.print("Deseja ativar algum sentinela? Sim/Não: ");
		String opString = input.nextLine().toUpperCase();
		
		
		while(opString.contentEquals("SIM")) {
			
			System.out.print("\nDeseja ativar um sentinela ou todos os sentinelas? Um/Todos: ");
			String op1 = input.nextLine().toUpperCase();
			
			
			if(op1.contentEquals("TODOS")) {
				dataSentinelas.alertarTodosSentinelas();
				break;
			}
			else if(op1.contentEquals("UM")) {
				System.out.print(
						"\nDigite o número do sentinela que deseja ativar 1, 2, 3 ou 4: ");
				int op2 = input.nextInt();
				input.nextLine();
				
				if(op2 == 1) {
					dataSentinelas.alertarUmSentinela(op2-1);
				}
				else if(op2 == 2) {
					dataSentinelas.alertarUmSentinela(op2-1);
				}
				else if(op2 == 3) {
					dataSentinelas.alertarUmSentinela(op2-1);
				}
				else if(op2 == 4) {
					dataSentinelas.alertarUmSentinela(op2-1);
				}
				else {
					System.out.print(
							"\nSentinela não localizado no sistema! Tente novamente!\n");
				}
				
				System.out.print("\nDeseja ativar mais algum sentinela? Sim/Não: ");
				opString = input.nextLine().toUpperCase();
				
				if(opString.equals("NÃO")) {
					break;
				}
			}
			else {
				System.out.println("Opção inválida! Tente Novamente!");
			}
			
		}
		
		System.out.print("\nSISTEMA SENTINELA FINALIZADO!");
		
		input.close();
	}

}
