package entities;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDados2 {
	
	
	List<Nota> listaNotas;
	
	
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
	
	public void alterarNota(int id, String desc, String data) {
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
				System.out.printf("\nData limite: %s ", nota.getData());
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
		
		System.out.println(
				"\nTAREFAS: ");
		for(Nota nota : listaNotas) {
			System.out.printf("\nId: %d ", nota.getId());
			System.out.printf("\nTarefa: %s ", nota.getDescricao());
			System.out.printf("\nData limite: %s ", nota.getData());
			if(nota.isRealizada()) {
				feita = "Sim";
			}
			else {
				feita = "Não";
			}
			System.out.printf("\nRealizada: %s%n", feita);
		}
	}
}
