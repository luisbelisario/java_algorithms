package entities;

public class Trabalhador {
	
	private String nome;
	private String ctps;
	protected Double salarioHora;
	
	public Trabalhador () {
		
	}

	public Trabalhador(String nome, String ctps, Double salarioHora) {
		this.nome = nome;
		this.ctps = ctps;
		this.salarioHora = salarioHora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
}
