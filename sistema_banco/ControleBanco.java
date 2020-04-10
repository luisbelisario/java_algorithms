package application;

import java.util.Scanner;

import entities.BaseDeClientes;
import entities.Cliente;
import entities.ContaCorrente;
import entities.HistoricoTransacoes;
import entities.Transacao;

public class ControleBanco {

	static Scanner input = new Scanner(System.in);
	static BaseDeClientes bc = new BaseDeClientes();
	static HistoricoTransacoes ht = new HistoricoTransacoes();
	
	public static void main(String[] args) {
		 
		int opcao = 1;
		
		while(opcao != 0 ) {
			System.out.println("\nO banco tem as seguinte opções: "
					+ "\n[1] - Adicionar conta"
					+ "\n[2] - Remover conta"
					+ "\n[3] - Alterar conta"
					+ "\n[4] - Mostrar conta de um cliente"
					+ "\n[5] - Mostrar contas de todos os clientes"
					+ "\n[6] - Fazer saque"
					+ "\n[7] - Fazer depósito"
					+ "\n[8] - Mostrar transações"
					+ "\n[0] - Finalizar programa");
			
			System.out.print("\nDigite a opção desejada: ");
			opcao = input.nextInt();
			input.nextLine();
			
			if(opcao == 1) {
				System.out.print(
						"Digite o nome do cliente: ");
				String nome = input.nextLine();
				System.out.print("Digite o cpf do cliente: ");
				String cpf = input.nextLine();
				Cliente cliente = new Cliente(nome, cpf);
				System.out.print("Digite o número da agência do cliente: ");
				int agencia = input.nextInt();
				System.out.print("Digite o número da conta do cliente: ");
				int numero = input.nextInt();
				System.out.print("Digite o saldo inicial do cliente: ");
				double saldo = input.nextDouble();
				input.nextLine();
				
				ContaCorrente novaConta = new ContaCorrente(cliente, agencia, numero, saldo);
				bc.adicionarConta(novaConta);
				System.out.println("\nCONTA ADICIONADA COM SUCESSO!\n");
			}
			else if(opcao == 2) {
				System.out.print(
						"Digite o número da agência da conta que será removida: ");
				int agencia = input.nextInt();
				System.out.print(
						"Digite o número da conta que será removida: ");
				int numero = input.nextInt();
				bc.removerConta(agencia, numero);
				System.out.print("\nCONTA REMOVIDA COM SUCESSO!\n");
				
			}
			else if(opcao == 3) {
				System.out.print(
						"Digite o número da agência da conta que será alterada: ");
				int agencia = input.nextInt();
				System.out.print(
						"Digite o número da conta que será alterada: ");
				int numero = input.nextInt();
				input.nextLine();
				if(bc.validarConta(agencia, numero)) {
					bc.removerConta(agencia, numero);
					System.out.print(
							"Digite o nome do cliente para alteração: ");
					String nome = input.nextLine();
					System.out.print("Digite o cpf do cliente para alteração: ");
					String cpf = input.nextLine();
					Cliente cliente = new Cliente(nome, cpf);
					System.out.print("Digite o número da agência do cliente para alteração: ");
					agencia = input.nextInt();
					System.out.print("Digite o número da conta do cliente para alteração: ");
					numero = input.nextInt();
					System.out.print("Digite o saldo do cliente para alteração: ");
					double saldo = input.nextDouble();
					input.nextLine();
					
					ContaCorrente novaConta = new ContaCorrente(cliente, agencia, numero, saldo);
					bc.adicionarConta(novaConta);
					System.out.println("\nCONTA ALTERADA COM SUCESSO!\n");
				}
				else {
					System.out.println("\nCONTA NÃO LOCALIZADA!\n");
				}
			}
			else if(opcao == 4) {
				System.out.print(
						"Digite o número da agência da conta que será mostrada: ");
				int agencia = input.nextInt();
				System.out.print(
						"Digite o número da conta que será mostrada: ");
				int numero = input.nextInt();
				if(bc.validarConta(agencia, numero) ) {
					System.out.println("Dados do cliente solicitado: ");
					bc.mostrarConta(agencia, numero);
				}
				else {
					System.out.println("\nCONTA NÃO LOCALIZADA!\n");
				}
			}
			else if(opcao == 5) {
				System.out.println("\n====CLIENTES DA AGÊNCIA====\n");
				bc.mostrarContas();
			}
			else if(opcao == 6) {
				System.out.print(
						"Digite o número da agência da conta em que será realizado o saque: ");
				int agencia = input.nextInt();
				System.out.print("Digite o número da conta em que será realizado o saque: ");
				int numero = input.nextInt();
				System.out.print("Digite o valor do saque: ");
				double valor = input.nextDouble();
				System.out.print("\nVerificando informações...\n");
				if(bc.validarConta(agencia, numero)) {
					Transacao novaTransacao  = bc.fazerSaque(agencia, numero, valor);
					ht.adicionarTransacao(novaTransacao);
					System.out.println("\nSAQUE EFETUADO COM SUCESSO!\n");
				}
				else {
					System.out.println(
							"\nCONTA NÃO LOCALIZADA!\n");
				}
			}
			else if(opcao == 7) {
				System.out.print(
						"Digite o número da agência da conta em que será realizado o depósito: ");
				int agencia = input.nextInt();
				System.out.print("Digite o número da conta em que será realizado o depósito: ");
				int numero = input.nextInt();
				System.out.print("Digite o valor do depósito: ");
				double valor = input.nextDouble();
				System.out.println("\nVerificando informações...\n");
				if(bc.validarConta(agencia, numero)) {
					Transacao novaTransacao = bc.fazerDeposito(agencia, numero, valor);
					ht.adicionarTransacao(novaTransacao);
					System.out.println("\nDEPÓSITO EFETUADO COM SUCESSO!\n");
				}
				else {
					System.out.println(
							"\nCONTA NÃO LOCALIZADA!\n");
				}
			}
			else if(opcao == 8) {
				System.out.println("\nTRANSAÇÕES EFETUADAS NO BANCO\n");
				ht.mostrarTransacoes();
			}
			else if(opcao == 0) {
				System.out.println("\nPROGRAMA FINALIZADO!\n");
			}
			else {
				System.out.println("\nOPÇÃO INVÁLIDA! TENTE NOVAMENTE!\n");
			}
			
		}
	}

}
