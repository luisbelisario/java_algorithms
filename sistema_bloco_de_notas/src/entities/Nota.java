package entities;

import java.util.Date;

import exceptions.DomainException;

public class Nota {
	
	private int id;
	private String descricao;
	private Date data;
	private boolean realizada;
	
	
	
	
	public Nota(int id, String descricao, Date data, boolean realizada) throws DomainException {
		Date now = new Date();
		if(data.before(now)) {
			throw new DomainException(
					"A data deve ser futura! Nota não adicionada! Tente novamente!");
		}
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



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public boolean isRealizada() {
		return realizada;
	}



	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}
	
	
	
}
