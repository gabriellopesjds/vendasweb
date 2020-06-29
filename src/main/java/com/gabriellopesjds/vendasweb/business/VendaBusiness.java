package com.gabriellopesjds.vendasweb.business;

import com.gabriellopesjds.vendasweb.config.AmazonSnsConfig;
import com.gabriellopesjds.vendasweb.config.AmazonSnsProperties;
import com.gabriellopesjds.vendasweb.config.AmazonSnsTopic;
import com.gabriellopesjds.vendasweb.domain.entity.Venda;
import com.gabriellopesjds.vendasweb.domain.exeptions.VendaNaoEncontradaException;
import com.gabriellopesjds.vendasweb.persistence.VendaRepository;
import com.gabriellopesjds.vendasweb.utils.SNSSender;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

@Component
public class VendaBusiness {

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	@Autowired
	private ProdutoBusiness produtoBusiness;

	@Autowired
	private SNSSender snsSender;

	@Autowired
	private AmazonSnsTopic amazonSnsTopic;

	@Transactional
	public Venda save(Venda entity) {
		buscarDados(entity);
		calcularTotais(entity);
		entity.setDataHora(LocalDateTime.now());
		topicNotificationSales(entity);
		return repository.save(entity);
	}

	private void topicNotificationSales(Venda venda) {
		Gson gson = new Gson();
		String json = gson.toJson(venda);
		snsSender.publishMessage(amazonSnsTopic.getTopicSales(), json);
	}

	private void buscarDados(Venda entity) {
		entity
			.setCliente(clienteBusiness.findById(entity.getCliente().getId()));

		entity
			.getItems()
			.forEach( s -> s.setProduto(produtoBusiness.findById(s.getProduto().getId())));
	}

	public Venda calcularTotais(Venda entity) {
		calcularValorTotalItem(entity);
		calcularValorTotalVenda(entity);
		return entity;
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
