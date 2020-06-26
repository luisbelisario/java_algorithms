package tests;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.HistoricoJogadas;


public class TesteHistoricoJogadas {
	
	
	public HistoricoJogadas h;
	
	@Before
	public void testPreparaJogador() {
		String jogadorTeste = "jogadorteste";
		String posicaoteste = "0,0";
		h = new HistoricoJogadas();
		h.addJogada(jogadorTeste, posicaoteste);
	}
	
	@Test
	public void testAddJogadorEJogada() {
		Map<String, String> mapaTeste = h.getMapaJogadas();
		
		boolean testeKey;
		boolean testeValue;
		
		
		if(mapaTeste.containsKey("jogadorteste")) {
			testeKey = true;
		}
		else {
			testeKey = false;
		}
		
		if(mapaTeste.containsValue("0,0")) {
			testeValue = true;
		}
		else {
			testeValue = false;
		}
		Assert.assertTrue(testeKey);
		Assert.assertTrue(testeValue);
	}
}
