package com.gabriellopesjds.vendasweb.domain.dto.request;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VendaRequest {

	@NotNull
	private Long clienteId;
	
	@NotEmpty
	private List<VendaItemRequest> items;
	
	public BigDecimal valorDesconto;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<VendaItemRequest> getItems() {
		return items;
	}

	public void setItems(List<VendaItemRequest> items) {
		this.items = items;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
}
