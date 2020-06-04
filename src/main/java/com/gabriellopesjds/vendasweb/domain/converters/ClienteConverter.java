package com.gabriellopesjds.vendasweb.domain.converters;

import org.springframework.stereotype.Component;

import com.gabriellopesjds.vendasweb.domain.dto.request.ClienteRequest;
import com.gabriellopesjds.vendasweb.domain.dto.response.ClienteResponse;
import com.gabriellopesjds.vendasweb.domain.entity.Cliente;

@Component
public class ClienteConverter extends BaseConverter<Cliente, ClienteRequest, ClienteResponse>{

	public ClienteConverter() {
		super(Cliente.class, ClienteResponse.class);
	}
	
}
