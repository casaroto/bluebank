package br.com.bluebank.business;

import java.util.List;

import br.com.bluebank.domain.CorrentistaVO;

public interface CorrentistaBean {
	
	public List<CorrentistaVO> listarCorrentistasCadastradosTransferencia(String cpfCnpj);
	
	public CorrentistaVO obterCorrentista(String cpfCnpj);

}
