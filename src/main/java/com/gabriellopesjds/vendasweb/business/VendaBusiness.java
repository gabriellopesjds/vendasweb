package com.gabriellopesjds.vendasweb.business;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gabriellopesjds.vendasweb.domain.entity.Venda;
import com.gabriellopesjds.vendasweb.domain.exeptions.VendaNaoEncontradaException;
import com.gabriellopesjds.vendasweb.persistence.VendaRepository;

@Component
public class VendaBusiness {

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	@Autowired
	private ProdutoBusiness produtoBusiness;
	
	@Transactional
	public Venda save(Venda entity) {
		validarDados(entity);
		calcularTotais(entity);
		entity.setDataHora(LocalDateTime.now());
		return repository.save(entity);
	}

	private void validarDados(Venda entity) {
		validarDadosCliente(entity);
		validarDadosProdutos(entity);
	}

	private void calcularTotais(Venda entity) {
		calcularValorTotalItem(entity);
		calcularValorTotalVenda(entity);
	}

	private void calcularValorTotalVenda(Venda entity) {
		double valorTotal = entity
								.getItems()
								.stream()
								.mapToDouble(s -> s.getValorTotal().doubleValue())
								.sum();
		entity.setValorBruto(new BigDecimal(valorTotal));
		entity.setValorLiquido(entity.getValorBruto().subtract(entity.getValorDesconto()));
	}

	private void calcularValorTotalItem(Venda entity) {
		entity
			.getItems()
				.forEach( s -> {
					s.setValorUnitario(s.getProduto().getPrecoVenda());
					s.setValorTotal(s.getValorUnitario().multiply(new BigDecimal(s.getQuantidade())));
				});
	}

	private void validarDadosProdutos(Venda entity) {
		entity
			.getItems()
			.forEach( s -> s.setProduto(produtoBusiness.findById(s.getProduto().getId())));
	}

	private void validarDadosCliente(Venda entity) {
		entity
			.setCliente(clienteBusiness.findById(entity.getCliente().getId()));
	}

	public List<Venda> findAll() {
		return repository.findAll();
	}

	public Venda findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new VendaNaoEncontradaException());
	}

	@Transactional
	public void delete(Venda Venda) {
		repository.delete(Venda);
	}

}
