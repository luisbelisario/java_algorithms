package entities;

public class TrabalhadorHora extends Trabalhador {
	
	
	public TrabalhadorHora() {
		
	}

	
	
	public TrabalhadorHora(String nome, String cpf, String ctps, Double salarioHora) {
		super(nome, cpf, ctps, salarioHora);
	}


	public Double horasAte40(int horas) {
		return salarioHora * horas;
	}
	
	public Double horasAcima40(int horas) {
		int horasExc = horas - 40;
		Double valorHoraExc = salarioHora + (salarioHora/2);
		Double salarioNormal = salarioHora * 40;
		Double salarioExc = horasExc * valorHoraExc;
		return salarioNormal + salarioExc;
	}
	
	public String toString(int horas) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nDADOS DO TRABALHADOR: \n");
		sb.append("Nome: ");
		sb.append(getNome() + "\n");
		sb.append("CTPS: ");
		sb.append(getCtps() + "\n");
		sb.append("Salário Hora: ");
		sb.append(salarioHora + "\n");
		sb.append("Salário Total: ");
		if(horas <= 40) {
			sb.append(horasAte40(horas));
		}
		else {
			sb.append(horasAcima40(horas));
		}
		return sb.toString();
	}
}
