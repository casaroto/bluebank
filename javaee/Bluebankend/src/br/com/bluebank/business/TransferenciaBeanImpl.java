package br.com.bluebank.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluebank.dao.TransferenciaDAO;
import br.com.bluebank.domain.ContaVO;
import br.com.bluebank.domain.TransferenciaVO;

@Component
public class TransferenciaBeanImpl implements TransferenciaBean {
	private static final String MENSAGEM_TRANSFERENCIA_NAO_EFETUADA = "Transferência não efetuada por insuficiência de fundos!";
	
	@Autowired
	private TransferenciaDAO transferenciaDAO;
	
	@Autowired
	private ContaBean contaBean;
	
	public TransferenciaBeanImpl(){
		
	}
	
	public void efetuarTransferencia(TransferenciaVO transferenciaVO) throws Exception{
		
		ContaVO contaVO = contaBean.obterConta(transferenciaVO.getIdCorrentistaOrigem()); 
		
		double saldo = contaVO.getSaldo();
		
       if ( (saldo - transferenciaVO.getValor() ) < 0){
        	throw new Exception(MENSAGEM_TRANSFERENCIA_NAO_EFETUADA);
       }
		
		transferenciaDAO.efetuarTransferencia(transferenciaVO);
	}

}
