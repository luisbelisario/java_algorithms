package entities;

import exceptions.DomainException;

public interface Regras {

	boolean checaMovimentoValido(int mov1, int mov2);
	
	boolean checaRodadas(int rodadas) throws DomainException;
	
	boolean checaCasaVazia(int pos1, int pos2);

	boolean checaVencedor(Jogador jog);
}
