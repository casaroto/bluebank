package br.com.bluebank.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluebank.dao.CorrentistaDAO;
import br.com.bluebank.domain.CorrentistaVO;

@Component
public class CorrentistaBeanImpl implements CorrentistaBean {
	
	@Autowired
	private CorrentistaDAO correntistaDAO;
	
	public CorrentistaBeanImpl(){
		
	}
	
	public List<CorrentistaVO> listarCorrentistasCadastradosTransferencia(String cpfCnpj){
		List<CorrentistaVO> lista = null;
		
		lista = correntistaDAO.listarCorrentistasCadastradosTransferencia(cpfCnpj);
		
		return lista;
	}
	
	public CorrentistaVO obterCorrentista(String cpfCnpj){
		CorrentistaVO correntista = null;
		
		correntista = correntistaDAO.obterCorrentista(cpfCnpj);
		
		return correntista;
	}

}
