package entities;

public class PessoaJuridica extends Pessoa {

	public PessoaJuridica(String nome, Documento numDocumento, String telefone, String endereco, String nomeResponsavel,
			Documento CPFResponsavel) {
		super(nome, numDocumento, telefone, endereco, nomeResponsavel, CPFResponsavel);
	}
	
}
