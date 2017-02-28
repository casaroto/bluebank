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
		
		ContaVO contaOrigemVO = contaBean.obterConta(transferenciaVO.getIdCorrentistaOrigem()); 
		ContaVO contaDestinoVO = contaBean.obterConta(transferenciaVO.getIdCorrentistaDestino()); 
		
		double saldoOrigem = contaOrigemVO.getSaldo();
		double saldoDestino = contaDestinoVO.getSaldo();
		
		saldoOrigem = saldoOrigem - transferenciaVO.getValor();
		
		if ( saldoOrigem < 0){
			throw new Exception(MENSAGEM_TRANSFERENCIA_NAO_EFETUADA);
		}
       
       TransferenciaVO transferenciaOrigem = new TransferenciaVO();
       TransferenciaVO transferenciaDestino = new TransferenciaVO();
		
       transferenciaOrigem.setIdCorrentistaDestino(transferenciaVO.getIdCorrentistaOrigem());
       transferenciaOrigem.setValor(saldoOrigem);
       
       transferenciaDAO.efetuarTransferencia(transferenciaOrigem);
		
       saldoDestino = saldoDestino + transferenciaVO.getValor();
       transferenciaDestino.setIdCorrentistaDestino(transferenciaVO.getIdCorrentistaDestino());
       transferenciaDestino.setValor(saldoDestino);
       
       transferenciaDAO.efetuarTransferencia(transferenciaDestino);
	  
	}

}
