package br.com.bluebank.dao;

import java.util.List;

import br.com.bluebank.domain.CorrentistaVO;

public interface CorrentistaDAO {
	
	public List<CorrentistaVO> listarCorrentistasCadastradosTransferencia(String cpfCnpj);
	
	public CorrentistaVO obterCorrentista(String cpfCnpj);

}
