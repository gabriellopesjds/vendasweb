package com.gabriellopesjds.vendasweb.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	public Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "estoque_atual")
	private double estoqueAtual;
	
	@Column(name = "preco_custo")
	private BigDecimal precoCusto;
	
	@Column(name =  "preco_venda")
	private BigDecimal precoVenda;
	
	public Produto() {};
}
