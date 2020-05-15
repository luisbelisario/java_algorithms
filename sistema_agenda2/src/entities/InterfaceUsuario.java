package entities;


public interface InterfaceUsuario {
	
	public void addPessoa(Pessoa pessoa);
	
	public void mostraContatos();

	public void buscarContato(String numDoc);
	
	public void removerContato(String numDoc);
	
	public boolean validaAlterarContato(String numDoc);
	
	public boolean validaCPF(String nome);
	
	public boolean validaCNPJ(String nome);
	
	public String buscaTelefone(String numDoc);
	
	public String buscaEndereco(String numDoc);
	
	public String buscaCPF(String nome);
	
	public String buscaCNPJ(String nome);
	
	public void buscaResponsavel(String numDoc);
	
}
