package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDeClientes {
	
	List<ContaCorrente> listaClientes;
	
	public BaseDeClientes() {
		listaClientes = new ArrayList<ContaCorrente>();
		
	}
	
	public void adicionarConta(ContaCorrente novaConta) {
		listaClientes.add(novaConta);
	}
	
	public void removerConta(int agencia, int numero) {
		for(ContaCorrente cliente : listaClientes) {
			if(agencia == cliente.getAgencia() && numero == cliente.getNumero()) {
				listaClientes.remove(cliente);
				break;
			}
		}
	}
	
	public boolean validarConta(int agencia, int numero) {
		boolean controle = false;
		
		for(ContaCorrente cliente : listaClientes) {
			if(agencia == cliente.getAgencia() && numero == cliente.getNumero()) {
				controle = true;
				break;
			}
		}
		return controle;
	}
	
	public Transacao fazerSaque(int agencia, int numero, double valor) {
		
		Transacao transacao = new Transacao();
		
		for(ContaCorrente cliente : listaClientes) {
			if(agencia == cliente.getAgencia() && numero == cliente.getNumero()) {
				cliente.fazerSaque(valor);
				Date data = new Date();
				
				transacao = new Transacao("Saque", cliente, valor, data);
			}
		}
		return transacao;
	}
	
	public Transacao fazerDeposito(int agencia, int numero, double valor) {
		
		Transacao transacao = new Transacao();
		
		for(ContaCorrente cliente : listaClientes) {
			if(agencia == cliente.getAgencia() && numero == cliente.getNumero()) {
				cliente.fazerDeposito(valor);
				Date data = new Date();
				
				transacao = new Transacao("Depósito", cliente, valor, data);
			}
		}
		return transacao;
	}
	
	public void mostrarConta(int agencia, int numero) {
		
		for(ContaCorrente cliente : listaClientes) {
			if(agencia == cliente.getAgencia() && numero == cliente.getNumero()) {
				System.out.printf("\nNome: %s", cliente.getNomeCliente());
				System.out.printf("\nCPF: %s", cliente.getCpfCliente());
				System.out.printf("\nAgência: %s", cliente.getAgencia());
				System.out.printf("\nNúmero da conta: %s", cliente.getNumero());
				System.out.printf("\nSaldo: R$ %.2f%n", cliente.getSaldo());
			}
		}
	}
	
	public void mostrarContas() {
		for(ContaCorrente cliente : listaClientes) {
			System.out.printf("\nNome: %s", cliente.getNomeCliente());
			System.out.printf("\nCPF: %s", cliente.getCpfCliente());
			System.out.printf("\nAgência: %s", cliente.getAgencia());
			System.out.printf("\nNúmero da conta: %s", cliente.getNumero());
			System.out.printf("\nSaldo: R$ %.2f%n", cliente.getSaldo());
		}
	}
}
