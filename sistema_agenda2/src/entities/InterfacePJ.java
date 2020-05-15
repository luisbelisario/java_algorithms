package entities;

public class InterfacePJ implements InterfaceUsuario {
	
	
	BaseDeDadosJ bdj = new BaseDeDadosJ();
	
	@Override
	public void addPessoa(Pessoa pessoa) {
		bdj.addPessoa(pessoa);
		
	}

	@Override
	public void mostraContatos() {
		bdj.mostraContatos();
		
	}

	@Override
	public void buscarContato(String num) {
		
		
	}

	@Override
	public void removerContato(String numDoc) {
		bdj.removePessoa(numDoc);
		
	}

	@Override
	public boolean validaAlterarContato(String numDoc) {
		return bdj.validaAlterarPessoa(numDoc);
	}

	@Override
	public String buscaTelefone(String numDoc) {
		return bdj.buscaTelefone(numDoc);
	}

	@Override
	public String buscaEndereco(String numDoc) {
		return bdj.buscaTelefone(numDoc);
	}

	public String buscaCNPJ(String nome) {
		return bdj.buscaCNPJ(nome);
	}

	@Override
	public boolean validaCPF(String nome) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public void buscaResponsavel(String numDoc) {
		bdj.buscaResponsavel(numDoc);
		
	}

	@Override
	public String buscaCPF(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validaCNPJ(String nome) {
		return bdj.validaCNPJ(nome);
	}

}
