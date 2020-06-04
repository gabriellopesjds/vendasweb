package com.gabriellopesjds.vendasweb.domain.exeptions;

public class ClienteNaoEncontradoException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException() {
		super("Cliente não encontrado. Ação: Informe um ID previamente cadastrado no sistema.");
	}
}
