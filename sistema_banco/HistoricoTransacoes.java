package entities;

import java.util.ArrayList;
import java.util.List;

public class HistoricoTransacoes {
	
	List<Transacao> listaTransacoes;
	
	
	public HistoricoTransacoes() {
		listaTransacoes = new ArrayList<Transacao>();
		
	}
	
	public void adicionarTransacao(Transacao novaTransacao) {
		listaTransacoes.add(novaTransacao);
	}
	
	public void mostrarTransacao(int agencia, int numero) {
		
		
		for(Transacao transacao : listaTransacoes) {
			if(agencia == transacao.getAgencia() && numero == transacao.getNumero()) 
				if(transacao.getId() == Transacao.contador) {
					System.out.print("NENHUM TRANSAÇÃO ENCONTRADA PARA ESTE CLIENTE!");
				}
				else {
					System.out.printf("\nNome Cliente: %s", transacao.getNomeCliente());
					System.out.printf("\nCPF Cliente: %s", transacao.getCpfCliente());
					System.out.printf("\nAgência: %d", transacao.getAgencia());
					System.out.printf("\nNúmero da Conta: %d", transacao.getNumero());
					System.out.printf("\nTipo da transação: %s", transacao.getTipo());
					System.out.printf("\nValor da transação R$ %.2f", transacao.getValor());
				}
			}
		}
	
	public void mostrarTransacoes() {
		
		if(Transacao.contador == 0) {
			System.out.println("\nO BANCO AINDA NÃO TEM TRANSAÇÕES!");
		}
		else {
			for(Transacao transacao : listaTransacoes) {
				System.out.printf("\nId: %d", transacao.getId());
				System.out.printf("\nNome do cliente: %s", transacao.getNomeCliente());
				System.out.printf("\nCPF do cliente: %s", transacao.getCpfCliente());
				System.out.printf("\nAgência: %d", transacao.getAgencia());
				System.out.printf("\nNúmero da Conta: %d", transacao.getNumero());
				System.out.printf("\nTipo da transação: %s", transacao.getTipo());
				System.out.printf("\nValor da transação R$ %.2f%n", transacao.getValor());
			}
		}
	}
}
