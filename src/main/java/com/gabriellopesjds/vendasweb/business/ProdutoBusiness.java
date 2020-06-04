package com.gabriellopesjds.vendasweb.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gabriellopesjds.vendasweb.domain.entity.Produto;
import com.gabriellopesjds.vendasweb.domain.exeptions.ProdutoNaoEncontradoException;
import com.gabriellopesjds.vendasweb.persistence.ProdutoRepository;

@Component
public class ProdutoBusiness {

	@Autowired
	private ProdutoRepository repository;
	
	@Transactional
	public Produto save(Produto entity) {
		return repository.save(entity);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException());
	}
	
	@Transactional
	public void delete(Produto produto) {
		repository.delete(produto);
	}

	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
