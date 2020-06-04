package com.gabriellopesjds.vendasweb.domain.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class VendaResponse {
	
	private Long id;
	
	private ClienteResponse cliente;
	
	private List<VendaItemResponse> items;
	
	public BigDecimal valorBruto;
	
	public BigDecimal valorDesconto;
	
	public BigDecimal valorLiquido;
	
	public LocalDateTime dataHora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteResponse getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResponse cliente) {
		this.cliente = cliente;
	}

	public List<VendaItemResponse> getItems() {
		return items;
	}

	public void setItems(List<VendaItemResponse> items) {
		this.items = items;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
}
