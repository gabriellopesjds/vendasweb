package com.gabriellopesjds.vendasweb.domain.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriellopesjds.vendasweb.domain.entity.Endereco;

public class ClienteRequest {
	
	@NotBlank
	@Size(min = 1, max = 14)
	@JsonProperty("inscricao")
	private String inscricao;
	
	@NotBlank
	@Size(min = 1, max = 200)
	private String nome;
	
	private Endereco endereco;

	public String getInscricao() {
		return inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
