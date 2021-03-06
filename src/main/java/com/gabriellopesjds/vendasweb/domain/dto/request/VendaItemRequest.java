package com.gabriellopesjds.vendasweb.domain.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendaItemRequest {

	@NotNull
	@Valid
	private ProdutoIdRequest produto;
	
	@NotNull
	private double quantidade;
}
