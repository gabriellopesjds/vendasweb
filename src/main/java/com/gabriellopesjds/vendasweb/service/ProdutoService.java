package com.gabriellopesjds.vendasweb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.gabriellopesjds.vendasweb.business.ProdutoBusiness;
import com.gabriellopesjds.vendasweb.domain.converters.ProdutoConverter;
import com.gabriellopesjds.vendasweb.domain.dto.request.ProdutoRequest;
import com.gabriellopesjds.vendasweb.domain.dto.response.ProdutoResponse;
import com.gabriellopesjds.vendasweb.domain.entity.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoBusiness business;
	
	@Autowired
	private ProdutoConverter converter;
	

	public ProdutoResponse save(ProdutoRequest resquestDto) {
		return converter.toModel(business.save(converter.toEntity(resquestDto)));
	}


	public List<ProdutoResponse> findAll() {
		return business
				.findAll()
				.stream()
				.map(s -> converter.toModel(s))
				.collect(Collectors.toList());
	}


	public ProdutoResponse update(@Validated ProdutoRequest requestDTO, Long id) {
		Produto Produto = business.findById(id);
		Produto ProdutoRequest = converter.toEntity(requestDTO);
		ProdutoRequest.setId(Produto.getId());
		return converter.toModel(business.save(ProdutoRequest));
	}


	public ProdutoResponse findById(Long id) {
		return converter.toModel(business.findById(id));
	}


	public void delete(Long id) {
		business.delete(business.findById(id));
	}
}
