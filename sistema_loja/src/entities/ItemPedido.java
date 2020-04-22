package entities;

public class ItemPedido {
	
	private Produto produto;
	private Integer quantidade;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Double subTotal() {
		return quantidade * produto.getPreco();
	}
}
