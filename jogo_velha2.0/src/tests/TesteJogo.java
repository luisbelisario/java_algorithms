package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Jogador;
import entities.Jogo;
import entities.Tabuleiro;

public class TesteJogo {
	
	public Jogo j;

	
	@Before
	public void testPrepararJogo() {
		j = new Jogo();
	}
	
	
	@Test
	public void testFazerMovimento1() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 0, 0);
		
		Tabuleiro tabuleiro = this.j.getT();
		
		String teste = tabuleiro.pegarElemento(0, 0);
		Assert.assertEquals(teste, jog.getSimbolo());
	}
	
	@Test
	public void testFazerMovimento2() {
		Jogador jog = new Jogador("jogadorteste", "O");
		
		j.fazerMovimento(jog, 0, 1);
		
		Tabuleiro tabuleiro = this.j.getT();
		
		String teste = tabuleiro.pegarElemento(0, 1);
		Assert.assertEquals(teste, jog.getSimbolo());
	}
	
	
	@Test
	public void testChecaMovimentoInvalido1() {
		Assert.assertFalse(j.checaMovimentoValido(-1, 0));
	}
	
	@Test
	public void testChecaMovimentoInvalido2() {
		Assert.assertFalse(j.checaMovimentoValido(0, -1));
	}
	
	@Test
	public void testChecaMovimentoInvalido3() {
		Assert.assertFalse(j.checaMovimentoValido(-1, -1));
	}
	
	@Test
	public void testChecaMovimentoValido1() {
		Assert.assertTrue(j.checaMovimentoValido(0, 2));
	}
	
	@Test
	public void testChecaMovimentoValido2() {
		Assert.assertTrue(j.checaMovimentoValido(2, 2));
	}
	
	@Test
	public void testChecaMovimentoValido3() {
		Assert.assertTrue(j.checaMovimentoValido(1, 0));
	}
	
	@Test
	public void testTestaCasaVazia() {
		
		String[][] tabuleiro = j.getTabuleiro();
		
		boolean teste;
		
		j.checaCasaVazia(0, 0);
		if(tabuleiro[0][0].contentEquals(" ")) {
			teste = true;
		}
		else {
			teste = false;
		}
		Assert.assertTrue(teste);
	}
	
	@Test
	public void testVitoriaHorizontal0() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 0, 0);
		j.fazerMovimento(jog, 0, 1);
		j.fazerMovimento(jog, 0, 2);
		
		Assert.assertTrue(j.checaVencedor(jog));
	}
	
	@Test
	public void testVitoriaHorizontal1() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 1, 0);
		j.fazerMovimento(jog, 1, 1);
		j.fazerMovimento(jog, 1, 2);
		
		Assert.assertTrue(j.checaVencedor(jog));
	}
	
	@Test
	public void testVitoriaHorizontal2() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 2, 0);
		j.fazerMovimento(jog, 2, 1);
		j.fazerMovimento(jog, 2, 2);
		
		Assert.assertTrue(j.checaVencedor(jog));
	}
	
	@Test
	public void testVitoriaVertical0() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 0, 0);
		j.fazerMovimento(jog, 1, 0);
		j.fazerMovimento(jog, 2, 0);
		
		Assert.assertTrue(j.checaVencedor(jog));
	}
	
	@Test
	public void testVitoriaVertical1() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 0, 1);
		j.fazerMovimento(jog, 1, 1);
		j.fazerMovimento(jog, 2, 1);
		
		Assert.assertTrue(j.checaVencedor(jog));
	}
	
	@Test
	public void testVitoriaVertical2() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 0, 2);
		j.fazerMovimento(jog, 1, 2);
		j.fazerMovimento(jog, 2, 2);
		
		Assert.assertTrue(j.checaVencedor(jog));
	}
	
	@Test
	public void testVitoriaDiagonal1() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 0, 0);
		j.fazerMovimento(jog, 1, 1);
		j.fazerMovimento(jog, 2, 2);
		
		Assert.assertTrue(j.checaVencedor(jog));
	}
	
	@Test
	public void testVitoriaDiagonal2() {
		Jogador jog = new Jogador("jogadorteste", "X");
		
		j.fazerMovimento(jog, 0, 2);
		j.fazerMovimento(jog, 1, 1);
		j.fazerMovimento(jog, 2, 0);
		
		Assert.assertTrue(j.checaVencedor(jog));
	}
}
