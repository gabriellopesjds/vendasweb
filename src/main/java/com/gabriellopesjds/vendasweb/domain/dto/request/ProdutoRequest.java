package com.gabriellopesjds.vendasweb.domain.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoRequest {
	
	@NotBlank
	private String nome;
	
	private double estoqueAtual;
	
	private BigDecimal precoCusto;
	
	@NotNull
	private BigDecimal precoVenda;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(double estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}
	
}
