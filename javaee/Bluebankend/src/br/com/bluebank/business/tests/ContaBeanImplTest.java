package br.com.bluebank.business.tests;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

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
		bean = new ContaBeanImpl();
		ReflectionTestUtils.setField(bean, "contaDAO", dao);
	}
	
	@Test
	public void obterCorrentistaLogadoTest() throws Exception {
		ContaVO conta = null;
		
		when(dao.obterConta(ArgumentMatchers.anyString())).thenReturn(mock(true));
		
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
