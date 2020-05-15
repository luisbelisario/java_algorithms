package entities;

public abstract class Pessoa {
	
	
	private String nome;
	private Documento numDocumento;
	private String telefone;
	private String endereco;
	private String nomeResponsavel;
	private Documento CPFResponsavel;
	
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, Documento numDocumento, String telefone, String endereco, String nomeResponsavel, Documento CPFResponsavel) {
		this.nome = nome;
		this.numDocumento = numDocumento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.nomeResponsavel = nomeResponsavel;
		this.CPFResponsavel = CPFResponsavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Documento getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(Documento numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	
	public Documento CPFResponsavel() {
		return CPFResponsavel;
	}
}
