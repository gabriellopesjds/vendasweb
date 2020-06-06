package com.gabriellopesjds.vendasweb.domain.dto.request;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaRequest {

	@Valid
	@NotNull
	private ClienteIdRequest cliente;
	
	@NotEmpty
	private List<VendaItemRequest> items;
	
	public BigDecimal valorDesconto;
	
}
