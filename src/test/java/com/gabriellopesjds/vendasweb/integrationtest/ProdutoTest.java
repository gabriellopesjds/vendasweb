package com.gabriellopesjds.vendasweb.integrationtest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.gabriellopesjds.vendasweb.domain.dto.response.BaseResponse;
import com.gabriellopesjds.vendasweb.domain.dto.response.ProdutoResponse;

import io.restassured.mapper.TypeRef;

class ProdutoTest extends AbstractIntegrationTest{
	
	@Override
	protected String getBaseUrl() {
		return "/produtos";
	}
	
	@Test
	public void produtoCadastradaComSucessoTest() {
		BaseResponse<ProdutoResponse> as = postRequest("/json/cadastrar_produto_com_sucesso.json")
			.then()
				.statusCode(HttpStatus.CREATED.value())
				.root("data")
					.body("nome", equalTo("Celular Iphone 10"))
			.extract()
			.body()
			.as(new TypeRef<BaseResponse<ProdutoResponse>>() {});
		ProdutoResponse produtoResponse = as.getData();
		assertEquals(produtoResponse.getNome(), "Celular Iphone 10");
	}
	
	@Test
	public void produtoSemCamposObrigatoriosErrorTest() {
		var response = postRequest("/json/cadastrar_produto_sem_campos_obrigatorios.json");
		assertServiceException(response);
	}
	
	@Test
	public void removeProdutoComSucessoTest() {
		Long idProdutoSave = postRequestAndReturnId("/json/cadastrar_produto_com_sucesso.json");
		
		Map<String, Object> pathParams = new HashMap<>();
		pathParams.put("id", idProdutoSave );
		deleteRequest(pathParams)
			.then()
				.statusCode(HttpStatus.NO_CONTENT.value());
	}
	
	@Test
	public void alteraProdutoComSucesso() {
		Long idProdutoSave = postRequestAndReturnId("/json/cadastrar_produto_com_sucesso.json");
		Map<String, Object> pathParams = new HashMap<>();
		pathParams.put("id", idProdutoSave);
		
		putRequest("/json/alterar_produto_com_sucesso.json", pathParams)
			.then()
				.statusCode(HttpStatus.OK.value())
				.root("data")
					.body("id", equalTo(idProdutoSave.intValue()))
					.body("nome", equalTo("Celular Iphone 11"));
	}
}
