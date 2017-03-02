package br.com.bluebank.business.tests;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import br.com.bluebank.business.ContaBean;
import br.com.bluebank.business.TransferenciaBeanImpl;
import br.com.bluebank.dao.TransferenciaDAO;
import br.com.bluebank.domain.ContaVO;
import br.com.bluebank.domain.TransferenciaVO;

public class TransferenciaBeanImplTest {
	
	@Mock
	private TransferenciaDAO dao;
	
	@Mock
	private ContaBean contaBean;
	
	@Mock
	private TransferenciaBeanImpl bean;
	
	@Before
	public void init(){
		dao = Mockito.mock(TransferenciaDAO.class);
		contaBean = Mockito.mock(ContaBean.class);
		bean = new TransferenciaBeanImpl();
		Whitebox.setInternalState(bean, "transferenciaDAO", dao);
		Whitebox.setInternalState(bean, "contaBean", contaBean);
	}
	
	@Test
	public void obterCorrentistaLogadoTest() throws Exception {
			
	    when(contaBean.obterConta(Matchers.anyInt())).thenReturn(mock(true));
		
		bean.efetuarTransferencia(new TransferenciaVO());
	
	}
	
	private ContaVO mock(boolean logado){
		ContaVO conta = new ContaVO();

		conta.setAgencia(100);
		conta.setConta(3432);
		conta.setLogado(logado);
		
		return conta;
	}


}
