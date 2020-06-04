package com.gabriellopesjds.vendasweb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gabriellopesjds.vendasweb.business.ClienteBusiness;
import com.gabriellopesjds.vendasweb.domain.converters.ClienteConverter;
import com.gabriellopesjds.vendasweb.domain.dto.request.ClienteRequest;
import com.gabriellopesjds.vendasweb.domain.dto.response.ClienteResponse;
import com.gabriellopesjds.vendasweb.domain.entity.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteBusiness business;
	
	@Autowired
	private ClienteConverter converter;
	

	public ClienteResponse save(ClienteRequest resquestDto) {
		return converter.toModel(business.save(converter.toEntity(resquestDto)));
	}


	public List<ClienteResponse> findAll() {
		return business
				.findAll()
				.stream()
				.map(s -> converter.toModel(s))
				.collect(Collectors.toList());
	}


	public ClienteResponse update(@Validated ClienteRequest requestDTO, Long id) {
		Cliente cliente = business.findById(id);
		Cliente clienteRequest = converter.toEntity(requestDTO);
		clienteRequest.setId(cliente.getId());
		return converter.toModel(business.save(clienteRequest));
	}


	public ClienteResponse findById(Long id) {
		return converter.toModel(business.findById(id));
	}


	public void delete(Long id) {
		business.delete(business.findById(id));
	}
}
