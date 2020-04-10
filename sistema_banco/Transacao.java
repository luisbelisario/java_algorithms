package entities;

import java.util.Date;

public class Transacao {
	
	public static int contador = 0;
	
	private int id;
	private String tipo;
	private ContaCorrente conta;
	private double valor;
	private Date data;
	
	public Transacao() {
		
	}
	
	public Transacao(String tipo, ContaCorrente conta, double valor, Date data) {
		this.id = contador + 1;
		this.tipo = tipo;
		this.conta = conta;
		this.valor = valor;
		this.data = data;
		Transacao.contador = this.id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNomeCliente() {
		return this.conta.getNomeCliente();
	}
	
	public String getCpfCliente() {
		return this.conta.getCpfCliente();
	}
 
	public int getAgencia() {
		return this.conta.getAgencia();
	}
	
	public int getNumero() {
		return this.conta.getNumero();
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}

	
	public ContaCorrente getCliente() {
		return conta;
	}
}
