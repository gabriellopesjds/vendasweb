package com.gabriellopesjds.vendasweb.domain.converters;

import org.springframework.stereotype.Component;

import com.gabriellopesjds.vendasweb.domain.dto.request.ProdutoRequest;
import com.gabriellopesjds.vendasweb.domain.dto.response.ProdutoResponse;
import com.gabriellopesjds.vendasweb.domain.entity.Produto;

@Component
public class ProdutoConverter extends BaseConverter<Produto, ProdutoRequest, ProdutoResponse>{

	public ProdutoConverter() {
		super(Produto.class, ProdutoResponse.class);
	}
	
}
