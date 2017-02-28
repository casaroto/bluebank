package br.com.bluebank.dao;

import br.com.bluebank.domain.ContaVO;

public interface ContaDAO {
	
	public ContaVO obterConta(String cpfCnpj);

	public ContaVO obterConta(int idConta);
	
}
