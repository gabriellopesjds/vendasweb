package com.gabriellopesjds.vendasweb.domain.converters;

import org.springframework.stereotype.Component;

import com.gabriellopesjds.vendasweb.domain.dto.request.VendaRequest;
import com.gabriellopesjds.vendasweb.domain.dto.response.VendaResponse;
import com.gabriellopesjds.vendasweb.domain.entity.Venda;

@Component
public class VendaConverter extends BaseConverter<Venda, VendaRequest, VendaResponse>{

	public VendaConverter() {
		super(Venda.class, VendaResponse.class);
	}
	
}
