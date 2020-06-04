package com.gabriellopesjds.vendasweb.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private Long id;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name =  "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	public Endereco(String rua, String numero, String bairro, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}	
}
