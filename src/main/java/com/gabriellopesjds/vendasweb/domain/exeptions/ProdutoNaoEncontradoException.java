package com.gabriellopesjds.vendasweb.domain.exeptions;

public class ProdutoNaoEncontradoException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException() {
		super("Produto não encontrado. Ação: Informe um ID previamente cadastrado no sistema.");
	}
}
