package entities;

public class TrabalhadorAutonomo extends Trabalhador {
	
	private int QtdVendas;
	
	
	public TrabalhadorAutonomo() {
		
	}


	public TrabalhadorAutonomo(String nome, String cpf, String ctps, Double salarioHora) {
		super(nome, cpf, ctps, salarioHora);
	}


	public int getQtdVendas() {
		return QtdVendas;
	}


	public void setQtdVendas(int qtdVendas) {
		QtdVendas = qtdVendas;
	}

	public Double calcularSalario() {
		return salarioHora * QtdVendas;
	}
}
