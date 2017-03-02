package br.com.bluebank.business.tests;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import br.com.bluebank.business.ContaBeanImpl;
import br.com.bluebank.dao.ContaDAO;
import br.com.bluebank.domain.ContaVO;

public class ContaBeanImplTest {
	
	@Mock
	private ContaDAO dao;
	
	@Mock
	private ContaBeanImpl bean;
	
	@Before
	public void init(){
		dao = Mockito.mock(ContaDAO.class);
		bean = Mockito.mock(ContaBeanImpl.class);
		Whitebox.setInternalState(bean, "contaDAO", dao);
	}
	
	@Test
	public void obterCorrentistaLogadoTest() throws Exception {
		ContaVO conta = null;
		
		when(dao.obterConta(Matchers.anyString())).thenReturn(mock(true));
			
		when(bean.obterConta(Matchers.anyString())).thenCallRealMethod();
		
		conta = bean.obterConta("38521876300");
		
		Assert.assertNotNull(conta);
		Assert.assertTrue(conta.isLogado());
	}
	
	private ContaVO mock(boolean logado){
		ContaVO conta = new ContaVO();

		conta.setAgencia(100);
		conta.setConta(3432);
		conta.setLogado(logado);
		
		return conta;
	}


}
