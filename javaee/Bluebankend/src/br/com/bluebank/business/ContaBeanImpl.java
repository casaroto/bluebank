package br.com.bluebank.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluebank.dao.ContaDAO;
import br.com.bluebank.domain.ContaVO;

@Component
public class ContaBeanImpl implements ContaBean {
	
	@Autowired
	private ContaDAO contaDAO;
	
	public ContaBeanImpl(){
		
	}
	
	public ContaVO obterConta(String cpfCnpj) throws Exception{
		ContaVO contaVO = null;
		
		contaVO = contaDAO.obterConta(cpfCnpj);
		
		return contaVO;
	}
	
	public ContaVO obterConta(int idConta) throws Exception{
		ContaVO contaVO = null;
		
		contaVO = contaDAO.obterConta(idConta);
		
		return contaVO;
	}
}
