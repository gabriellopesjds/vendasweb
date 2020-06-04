package com.gabriellopesjds.vendasweb.domain.dto.request;

public class VendaItemRequest {

	private Long produtoId;
	
	private double quantidade;
	
	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

}
