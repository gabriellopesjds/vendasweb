package com.gabriellopesjds.vendasweb.integrationtest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import com.gabriellopesjds.vendasweb.utils.AbstractConfigurationTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractIntegrationTest extends AbstractConfigurationTest{
	
	@LocalServerPort
	protected int port;
	
	@BeforeEach
	public void setUp() {
		RestAssured.port = this.port;
	}
	
	protected abstract String getBaseUrl();
	
	protected Response deleteRequest(Map<String,Object> params) {
		return given()
					.pathParams(params)
					.log()
						.all()
			   .when()
			   		.delete(getBaseUrl() + "/{id}")
			   .thenReturn();
	}
	
	protected Response postRequest(String body) {
		return given()
					.spec(buildRequestSpecification(body))
					.log()
						.all()
			   .when()
			   		.post(getBaseUrl())
			   .thenReturn();
	}
	
	protected Response putRequest(String body, Map<String,Object> params) {
		return given()
					.pathParams(params)
					.spec(buildRequestSpecification(body))
					.log()
						.all()
			   .when()
			   		.put(getBaseUrl() + "/{id}")
			   .thenReturn();
	}
	
	protected void assertServiceException(Response response) {
		response
			.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.root("error")
					.body("status", equalTo(HttpStatus.BAD_REQUEST.value()))
					.body("title", equalTo("Service"))
					.body("details[0].field", notNullValue())
					.body("details[0].message", notNullValue());
	}
	
	private RequestSpecification buildRequestSpecification(String body) {
		return new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Accept", ContentType.JSON.toString())
				.setBody(getContentFromResource(body))
				.build();
	}
	
	private String getContentFromResource(String resourceName) {
		try {
			InputStream inputStream = ResourceUtils.class.getResourceAsStream(resourceName);
			return StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
