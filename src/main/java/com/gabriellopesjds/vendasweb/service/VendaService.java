package com.gabriellopesjds.vendasweb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gabriellopesjds.vendasweb.business.VendaBusiness;
import com.gabriellopesjds.vendasweb.domain.converters.VendaConverter;
import com.gabriellopesjds.vendasweb.domain.dto.request.VendaRequest;
import com.gabriellopesjds.vendasweb.domain.dto.response.VendaResponse;
import com.gabriellopesjds.vendasweb.domain.entity.Venda;

@Service
public class VendaService {
	
	@Autowired
	private VendaBusiness business;
	
	@Autowired
	private VendaConverter converter;
	

	public VendaResponse save(VendaRequest resquestDto) {
		return converter.toModel(business.save(converter.toEntity(resquestDto)));
	}


	public List<VendaResponse> findAll() {
		return business
				.findAll()
				.stream()
				.map(s -> converter.toModel(s))
				.collect(Collectors.toList());
	}


	public VendaResponse update(@Validated VendaRequest requestDTO, Long id) {
		Venda Venda = business.findById(id);
		Venda VendaRequest = converter.toEntity(requestDTO);
		VendaRequest.setId(Venda.getId());
		return converter.toModel(business.save(VendaRequest));
	}


	public VendaResponse findById(Long id) {
		return converter.toModel(business.findById(id));
	}


	public void delete(Long id) {
		business.delete(business.findById(id));
	}
}
