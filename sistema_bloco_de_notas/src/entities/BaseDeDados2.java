package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDeDados2 {
	
	
	List<Nota> listaNotas;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public BaseDeDados2() {
		listaNotas = new ArrayList<Nota>();
	}
	
	public void adicionarNota(Nota novaNota) {
		listaNotas.add(novaNota);
	}
	
	public void removerNota(int id) {
		
		for(Nota nota : listaNotas) {
			if(id == nota.getId()) {
				listaNotas.remove(nota);
				break;
			}
		}
	}
	
	public void realizarTarefa(int id) {
		for(Nota nota : listaNotas) {
			if(id == nota.getId()) {
				nota.setRealizada(true);
				break;
			}
		}
	}
	
	public void alterarNota(int id, String desc, Date data) {
		for(Nota nota : listaNotas) {
			if(id == nota.getId()) {
				nota.setDescricao(desc);
				nota.setData(data);
				break;
			}
		}
	}
	
	public void mostrarNota(int id) {
		
		String feita = "";
		
		for(Nota nota : listaNotas) {
			if(id == nota.getId()) {
				System.out.printf("\nId: %d ", nota.getId());
				System.out.printf("\nTarefa: %s ", nota.getDescricao());
				System.out.printf("\nData limite: %s ", sdf.format(nota.getData()));
				if(nota.isRealizada()) {
					feita = "Sim";
				}
				else {
					feita = "Não";
				}
				System.out.printf("\nRealizada: %s%n", feita);
				break;
			}
		}
	}
	
	public void mostrarNotas() {
		
		String feita = "";
		
		if(!(listaNotas.contains(null))) {
		
			System.out.println(
					"\nTAREFAS DO BLOCO: ");
			for(Nota nota : listaNotas) {
				System.out.printf("\nId: %d ", nota.getId());
				System.out.printf("\nTarefa: %s ", nota.getDescricao());
				System.out.printf("\nData limite: %s ", sdf.format(nota.getData()));
				if(nota.isRealizada()) {
					feita = "Sim";
				}
				else {
					feita = "Não";
				}
				System.out.printf("\nRealizada: %s%n", feita);
			}
		}
		else {
			System.out.println();
		}
	}
}
