package entities;

public class TrabalhadorAssalariado extends Trabalhador {
	
	public static final Integer horas = 40;
	
	public TrabalhadorAssalariado() {
		
	}

	public TrabalhadorAssalariado(String nome, String ctps, Double salarioHora) {
		super(nome, ctps, salarioHora);
	}
	
	public Double getSalario() {
		return salarioHora * horas;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nDADOS DO TRABALHADOR: \n");
		sb.append("Nome: ");
		sb.append(getNome() + "\n");
		sb.append("CTPS: ");
		sb.append(getCtps() + "\n");
		sb.append("Salário Hora: ");
		sb.append(salarioHora + "\n");
		sb.append("Salário Total: ");
		sb.append(getSalario());
		return sb.toString();
	}
}
