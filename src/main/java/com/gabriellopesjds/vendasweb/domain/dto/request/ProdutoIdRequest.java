package com.gabriellopesjds.vendasweb.domain.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoIdRequest {
	
	@NotNull
	private Long id;

}
