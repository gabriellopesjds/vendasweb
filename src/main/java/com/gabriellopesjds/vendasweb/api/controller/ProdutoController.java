package com.gabriellopesjds.vendasweb.api.controller;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriellopesjds.vendasweb.domain.dto.request.ProdutoRequest;
import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ProdutoResponse;
import com.gabriellopesjds.vendasweb.service.ProdutoService;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;

	@PostMapping
	public ResponseEntity<BaseResponse<ProdutoResponse>> create(@Valid @RequestBody ProdutoRequest requestDTO) {
		
		ProdutoResponse responseDTO = service.save(requestDTO);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(responseDTO.getId())
					.toUri();
		
		return ResponseEntity.created(uri)
					.body(BaseResponse.withData(responseDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BaseResponse<ProdutoResponse>> update(@Valid @RequestBody ProdutoRequest requestDTO, @PathVariable  Long id) {
		
		ProdutoResponse responseDTO = service.update(requestDTO, id);
		
		return ResponseEntity
					.ok()
					.body(BaseResponse.withData(responseDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity
					.noContent()
					.build();
	}
	
	@GetMapping
	public ResponseEntity<BaseResponse<List<ProdutoResponse>>> findAll(){
		return ResponseEntity
				.ok()
				.body(BaseResponse.withData(service.findAll()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<ProdutoResponse>> find(@PathVariable Long id){
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity
				.ok()
				.cacheControl(cacheControl)
				.body(BaseResponse.withData(service.findById(id)));
	}
	
}
