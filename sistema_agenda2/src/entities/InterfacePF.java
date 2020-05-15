package entities;

public class InterfacePF implements InterfaceUsuario {

	BaseDeDadosF bdf = new BaseDeDadosF();
	
	@Override
	public void addPessoa(Pessoa pessoa) {
		bdf.addPessoa(pessoa);
		
	}

	@Override
	public void mostraContatos() {
		bdf.mostraContatos();
	}

	@Override
	public void buscarContato(String numDoc) {
		bdf.buscarContato(numDoc);
		
	}
	
	@Override
	public void removerContato(String numDoc) {
		bdf.removePessoa(numDoc);
	}
	
	public boolean validaAlterarContato(String numDoc) {
		return bdf.validaAlterarPessoa(numDoc);
	}

	@Override
	public String buscaTelefone(String numDoc) {
		return bdf.buscaTelefone(numDoc);
	}

	@Override
	public String buscaEndereco(String numDoc) {
		return bdf.buscaEndereco(numDoc);
	}

	@Override
	public String buscaCPF(String nome) {
		return bdf.buscaCPF(nome);
	}

	@Override
	public boolean validaCPF(String nome) {
		return bdf.validaCPF(nome);
	}

	@Override
	public String buscaCNPJ(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buscaResponsavel(String numDoc) {
		//TODO
		
	}

	@Override
	public boolean validaCNPJ(String nome) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
