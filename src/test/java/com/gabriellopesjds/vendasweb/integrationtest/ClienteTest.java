package com.gabriellopesjds.vendasweb.integrationtest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ClienteTest extends AbstractIntegrationTest {

	@Override
	protected String getBaseUrl() {
		return "/clientes";
	}
	
	@Test
	public void cadastrarClienteComSucessoTest() {
		postRequest("/json/cadastrar_cliente_com_sucesso.json")
			.then()
				.statusCode(HttpStatus.CREATED.value())
				.root("data")
					.body("inscricao", equalTo("53342569034"))
					.body("nome", containsString("Gabriel Lopes"));
	}
	
	public void alterarClienteComSucessoTest() {
		var idClienteSave = postRequestAndReturnId("/json/cadastrar_cliente_com_sucesso.json");
		
		Map<String,Object> params = new HashMap<>();
		params.put("id", idClienteSave);
		putRequest("/json/cadastrar_cliente_com_sucesso.json", params)
			.then()
				.statusCode(HttpStatus.OK.value())
				.root("data")
				.body("id", equalTo(idClienteSave))
					.body("inscricao", containsString("20123467071"))
					.body("nome", containsString("Gabriel Lopes Alterado"));
	}
	
	@Test
	public void deleteClienteComSucesso() {
		var idClienteSave = postRequestAndReturnId("/json/cadastrar_cliente_com_sucesso.json");
		Map<String,Object> params = new HashMap<>();
		params.put("id", idClienteSave);
		
		deleteRequest(params)
			.then()
				.statusCode(HttpStatus.NO_CONTENT.value());
	}
}
