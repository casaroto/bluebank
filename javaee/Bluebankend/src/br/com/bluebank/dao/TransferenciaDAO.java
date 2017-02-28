package br.com.bluebank.dao;

import br.com.bluebank.domain.TransferenciaVO;

public interface TransferenciaDAO {
	
	public void efetuarTransferencia(TransferenciaVO transferenciaVO) throws Exception;

}
