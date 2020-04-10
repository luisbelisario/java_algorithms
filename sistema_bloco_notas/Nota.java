package entities;

public class Nota {
	
	private int id;
	private String descricao;
	private String data;
	private boolean realizada;
	
	
	
	
	public Nota(int id, String descricao, String data, boolean realizada) {
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.realizada = realizada;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public boolean isRealizada() {
		return realizada;
	}



	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
	
	
	
}
