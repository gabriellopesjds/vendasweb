package com.gabriellopesjds.vendasweb.integrationtest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gabriellopesjds.vendasweb.business.ClienteBusiness;
import com.gabriellopesjds.vendasweb.business.ProdutoBusiness;
import com.gabriellopesjds.vendasweb.business.VendaBusiness;
import com.gabriellopesjds.vendasweb.persistence.VendaRepository;

@ExtendWith(MockitoExtension.class)
class VendaTest extends AbstractIntegrationTest{
	
	@MockBean
	private VendaRepository repository;
	
	@MockBean
	private ClienteBusiness clienteBusiness;
	
	@MockBean
	private ProdutoBusiness produtoBusiness;
	
	@InjectMocks
	private VendaBusiness vendaBusiness;

	@Override
	protected String getBaseUrl() {
		return "/vendas";
	}

}
