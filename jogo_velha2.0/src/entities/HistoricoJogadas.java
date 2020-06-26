package entities;

import java.util.LinkedHashMap;
import java.util.Map;

public class HistoricoJogadas {
	
	
	Map<String, String> mapaJogadas;
	
	public HistoricoJogadas() {
		mapaJogadas = new LinkedHashMap<>();
	}
	
	
	public Map<String, String> getMapaJogadas() {
		return mapaJogadas;
	}


	public void setMapaJogadas(Map<String, String> mapaJogadas) {
		this.mapaJogadas = mapaJogadas;
	}


	public void addJogada(String jogador, String posicao) {
		mapaJogadas.put(jogador, posicao);
	}
	
	public void mostrarJogadas() {
		
		System.out.println("\nHISTÓRICO DE JOGADAS");
		for(String key : mapaJogadas.keySet()) {
			System.out.println(key + " " + mapaJogadas.get(key));
		}
	}
}
