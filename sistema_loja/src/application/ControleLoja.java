package application;


import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import enums.StatusPedido;

public class ControleLoja {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.println("Digite os dados do cliente: ");
		System.out.print("Nome: ");
		String nome = input.nextLine();
		System.out.print("Email: ");
		String email = input.nextLine();
		System.out.print("Data de nascimento (DD/MM/YYYY): ");
		String dataNasc = input.nextLine();
		
		Cliente cliente = new Cliente(nome, email, dataNasc);
		
		System.out.println("Digite os dados do pedido: ");
		System.out.print("Status: ");
		String status = input.nextLine();
		
		StatusPedido sp = StatusPedido.valueOf(status);
		
		System.out.print(
				"Digite a quantidade de itens para esse pedido: ");
		int n = input.nextInt();
		input.nextLine();
		Date momento = new Date();
		
		Pedido pedido = new Pedido(momento, sp, cliente);
		
		for(int i=1; i<=n; i++) {
			System.out.printf("\nDigite os dados do %sº pedido: \n", i);
			System.out.print("Nome do produto: ");
			String nomeProduto = input.nextLine();
			System.out.print("Preço do produto: ");
			double precoProduto = input.nextDouble();
			input.nextLine();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			
			System.out.print("Quantidade: ");
			int quantidade = input.nextInt();
			input.nextLine();
			
			ItemPedido itemPedido = new ItemPedido(produto, quantidade);
			
			pedido.addPedido(itemPedido);
			
		}
		
		System.out.println(pedido.toString());
		
		input.close();
	}

}
