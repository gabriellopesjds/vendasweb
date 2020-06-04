package com.gabriellopesjds.vendasweb.domain.exeptions;

public class VendaNaoEncontradaException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;

	public VendaNaoEncontradaException() {
		super("Venda não encontrado. Ação: Informe um ID previamente cadastrado no sistema.");
	}
}
