package entities;

public class PessoaFisica extends Pessoa {
	
	public PessoaFisica() {
		
	}

	public PessoaFisica(String nome, Documento numDocumento, String telefone, String endereco, String nomeResponsavel,
			Documento CPFResponsavel) {
		super(nome, numDocumento, telefone, endereco, nomeResponsavel, CPFResponsavel);
	}

}
