package com.gabriellopesjds.vendasweb.api.controller;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriellopesjds.vendasweb.domain.dto.request.ClienteRequest;
import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ClienteResponse;
import com.gabriellopesjds.vendasweb.service.ClienteService;

@Controller
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<BaseResponse<ClienteResponse>> create(@Validated @RequestBody ClienteRequest requestDTO) {
		
		ClienteResponse responseDTO = service.save(requestDTO);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(responseDTO.getId())
					.toUri();
		
		return ResponseEntity.created(uri)
					.body(BaseResponse.withData(responseDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BaseResponse<ClienteResponse>> update(@Validated @RequestBody ClienteRequest requestDTO, @PathVariable  Long id) {
		
		ClienteResponse responseDTO = service.update(requestDTO, id);
		
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
	public ResponseEntity<BaseResponse<List<ClienteResponse>>> findAll(){
		return ResponseEntity
				.ok()
				.body(BaseResponse.withData(service.findAll()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse<ClienteResponse>> find(@PathVariable Long id){
		
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity
				.ok()
				.cacheControl(cacheControl)
				.body(BaseResponse.withData(service.findById(id)));
	}
	
}
