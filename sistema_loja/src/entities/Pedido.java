package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.StatusPedido;

public class Pedido {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yyyy HH:MM:SS");
	
	static List<ItemPedido> listaItens = new ArrayList<ItemPedido>();
	
	
	private Date momento;
	private StatusPedido status;
	private Cliente cliente;
	
	
	public Pedido() {
		
	}
	
	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		super();
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getListaPedidos() {
		return listaItens;
	}
	
	public void addPedido(ItemPedido item) {
		listaItens.add(item);
	}
	
	public void removeItem(String nome) {
		for(ItemPedido i : listaItens) {
			if(i.getProduto().getNome().contentEquals(nome)) {
				listaItens.remove(i);
			}
		}
	}
	
	public Double Total() {
		Double soma = 0.0;
		for(ItemPedido i : listaItens) {
			soma += i.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nSUMÁRIO PEDIDO: \n");
		sb.append("Instante pedido: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Status do Pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente.mostraCliente() + "\n");
		sb.append("\nITENS DO PEDIDO:\n");
		for(ItemPedido i : listaItens) {
			sb.append("\nNome: ");
			sb.append(i.getProduto().getNome() + "\n");
			sb.append("Valor unitário: ");
			sb.append("R$ " + String.format("R$ %.2f", i.getProduto().getPreco()) + "\n");
			sb.append("Quantidade: " + i.getQuantidade() + "\n");
			sb.append("Subtotal: " + "R$ " + String.format("R$ %.2f", i.subTotal()));
		}
		sb.append("\nVALOR TOTAL DO PEDIDO: " + "R$ " + String.format("R$ %.2f", Total()));
		return sb.toString();
	}
	
}
