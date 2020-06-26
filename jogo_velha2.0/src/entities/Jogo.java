package entities;

import exceptions.DomainException;

public class Jogo extends Tabuleiro implements Regras {
	
	Tabuleiro t = new Tabuleiro();
	Jogador jogador = new Jogador();
	
	public Jogo() {
		
	}
	
	
	public Tabuleiro getT() {
		return t;
	}


	public void setT(Tabuleiro t) {
		this.t = t;
	}


	public Jogador getJogador() {
		return jogador;
	}


	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}


	public void printarTabuleiro() {
		t.printarTabuleiro();
	}
	
	public void fazerMovimento(Jogador jog, int pos1, int pos2) {
		t.tabuleiro[pos1][pos2] = jog.getSimbolo();
		t.printarTabuleiro();
	}
	
	@Override
	public boolean checaMovimentoValido(int mov1, int mov2) {
		if(mov1 < 0 || mov2 > 2) {
			return false;
		}
		if(mov1 > 2 || mov2 < 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean checaCasaVazia(int pos1, int pos2) {
		if(t.tabuleiro[pos1][pos2].equals(" ")) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean checaRodadas(int rodadas) throws DomainException {
		if(rodadas <= 0) {
			throw new DomainException("Algo deu errado! Contate o administrador!");
		}
		if(rodadas >= 9) {
			return true;
		}
		return false;
	}
	

	@Override
	public boolean checaVencedor(Jogador jog) {
		if((t.tabuleiro[0][0] == jog.getSimbolo() && t.tabuleiro[0][1] == jog.getSimbolo() && t.tabuleiro[0][2] == jog.getSimbolo()) || 
				(t.tabuleiro[0][0] == jog.getSimbolo() && t.tabuleiro[1][0] == jog.getSimbolo() && t.tabuleiro[2][0] == jog.getSimbolo())) {
			return true;
		}
		if((t.tabuleiro[1][0] == jog.getSimbolo() && t.tabuleiro[1][1] == jog.getSimbolo() && t.tabuleiro[1][2] == jog.getSimbolo()) || 
				(t.tabuleiro[0][1] == jog.getSimbolo() && t.tabuleiro[1][1] == jog.getSimbolo() && t.tabuleiro[2][1] == jog.getSimbolo())) {
			return true;
		}
		if((t.tabuleiro[2][0] == jog.getSimbolo() && t.tabuleiro[2][1] == jog.getSimbolo() && t.tabuleiro[2][2] == jog.getSimbolo()) || 
				(t.tabuleiro[0][2] == jog.getSimbolo() && t.tabuleiro[1][2] == jog.getSimbolo() && t.tabuleiro[2][2] == jog.getSimbolo())) {
			return true;
		}
		if((t.tabuleiro[0][0] == jog.getSimbolo() && t.tabuleiro[1][1] == jog.getSimbolo() && t.tabuleiro[2][2] == jog.getSimbolo()) || 
				(t.tabuleiro[0][2] == jog.getSimbolo() && t.tabuleiro[1][1] == jog.getSimbolo() && t.tabuleiro[2][0] == jog.getSimbolo())){
			return true;
		}
		return false;
	}
	
}
