package entities;

public class Jogador extends Pessoa {
	
	private String simbolo;

	
	public Jogador() {
		
	}
	
	public Jogador(String nome, String simbolo) {
		super(nome);
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
}
