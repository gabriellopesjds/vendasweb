package com.gabriellopesjds.vendasweb.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venda_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "venda")
	private List<VendaItem> items;
	
	@Column(name = "valor_bruto")
	public BigDecimal valorBruto;
	
	@Column(name = "valor_desconto")
	public BigDecimal valorDesconto;
	
	@Column(name = "valor_liquido")
	public BigDecimal valorLiquido;
	
	@Column(name = "data_hora")
	public LocalDateTime dataHora;

}
