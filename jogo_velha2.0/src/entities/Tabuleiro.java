package entities;



public class Tabuleiro {
	
	String[][] tabuleiro = {{" ", " ", " "},
			{" " , " ", " "},
			{" ", " ", " "}};
	
	public Tabuleiro() {
	
	}
	
	
	public String[][] getTabuleiro() {
		return tabuleiro;
	}


	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void printarTabuleiro() {
		
		System.out.println();
		
		for(int linha=0; linha<3; linha++) {
			for(int coluna=0; coluna<3; coluna++) {
				System.out.print(" " + tabuleiro[linha][coluna] + " ");
				System.out.print('|');
			}
			System.out.println();
			if(linha != 2 ) {
				System.out.println("  -----------");
			}
		}
	}
	
	public String pegarElemento(int linha, int coluna) {
		return tabuleiro[linha][coluna];
	}
}
