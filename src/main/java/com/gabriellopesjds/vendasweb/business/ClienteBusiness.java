package com.gabriellopesjds.vendasweb.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gabriellopesjds.vendasweb.domain.entity.Cliente;
import com.gabriellopesjds.vendasweb.domain.exeptions.ClienteNaoEncontradoException;
import com.gabriellopesjds.vendasweb.persistence.ClienteRepository;

@Component
public class ClienteBusiness {

	@Autowired
	private ClienteRepository repository;
	
	@Transactional
	public Cliente save(Cliente entity) {
		return repository.save(entity);
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException());
	}

	@Transactional
	public void delete(Cliente cliente) {
		repository.delete(cliente);
	}

}
