package com.gabriellopesjds.vendasweb.domain.exeptions;

public class ProdutoJaCadastradoException extends RegraNegocioException {

	private static final long serialVersionUID = 1L;

	public ProdutoJaCadastradoException() {
		super("Produto já cadastrado. Ação: Altere o registro já existente ou informe outro CNPJ/CPF");
	}
}
