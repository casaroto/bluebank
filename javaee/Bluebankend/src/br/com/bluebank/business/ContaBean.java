package br.com.bluebank.business;

import br.com.bluebank.domain.ContaVO;

public interface ContaBean {
	
	public ContaVO obterConta(String cpfCnpj) throws Exception;

	public ContaVO obterConta(int idConta) throws Exception;
}
