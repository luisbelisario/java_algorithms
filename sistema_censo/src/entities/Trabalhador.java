package entities;

public abstract class Trabalhador extends Pessoa {
	
	
	private String ctps;
	protected Double salarioHora;
	
	public Trabalhador () {
		
	}

	public Trabalhador(String nome, String cpf, String ctps, Double salarioHora) {
		super(nome, cpf);
		this.ctps = ctps;
		this.salarioHora = salarioHora;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public Double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(Double salarioHora) {
		this.salarioHora = salarioHora;
	}
	
	

}
