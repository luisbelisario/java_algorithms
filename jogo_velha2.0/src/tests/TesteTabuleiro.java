package tests;

import entities.Jogo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TesteTabuleiro {
	
	
	public Jogo j;
	
	@Before
	public void testPrepararJogo() {
		j = new Jogo();
	}
	
	@Test
	public void testTabuleiroVazio() {
		String[][] tabuleiro = j.getTabuleiro();
		
		boolean teste;
		
		for(String[] linha : tabuleiro) {
			for(String c : linha) {
				if(c.contentEquals(" ")) {
					teste = true;
				}
				else {
					teste = false;
				}
				Assert.assertTrue(teste);
			}
		}
	}
}
