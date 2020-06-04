package com.gabriellopesjds.vendasweb.domain.dto.response;

import java.math.BigDecimal;

public class VendaItemResponse {

	private ProdutoResponse produto;
	
	private double quantidade;
	
	private BigDecimal valorUnitario;
	
	private BigDecimal valorTotal;

	public ProdutoResponse getProduto() {
		return produto;
	}

	public void setProduto(ProdutoResponse produto) {
		this.produto = produto;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
