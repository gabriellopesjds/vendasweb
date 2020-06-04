package com.gabriellopesjds.vendasweb.domain.exeptions;

public class ClienteJaCadastradoException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;

	public ClienteJaCadastradoException() {
		super("Cliente já cadastrado. Ação: Altere o registro já existente ou informe outro CNPJ/CPF");
	}
}
