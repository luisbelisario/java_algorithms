package entities;

public class ContaCorrente {
	
	private Cliente cliente;
	private int agencia;
	private int numero;
	private double saldo;
	
	
	public ContaCorrente(Cliente cliente, int agencia, int numero, double saldo) {
		this.cliente = cliente;
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNomeCliente() {
		return this.cliente.getNome();
	}
	
	public String getCpfCliente() {
		return this.cliente.getCpf(); 
	}
 
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void fazerSaque(double valor) {
		this.saldo -= valor;
	}
	
	public void fazerDeposito(double valor) {
		this.saldo += valor;
	}
	
}
