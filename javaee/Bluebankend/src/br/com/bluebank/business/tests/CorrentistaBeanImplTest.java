package br.com.bluebank.business.tests;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import br.com.bluebank.business.CorrentistaBeanImpl;
import br.com.bluebank.dao.CorrentistaDAO;
import br.com.bluebank.domain.CorrentistaVO;

public class CorrentistaBeanImplTest {
	
	@Mock
	private CorrentistaDAO dao;
	
	@Mock
	private CorrentistaBeanImpl bean;
	
	@Before
	public void init(){
		dao = Mockito.mock(CorrentistaDAO.class);
		bean = Mockito.mock(CorrentistaBeanImpl.class);
		Whitebox.setInternalState(bean, "correntistaDAO", dao);
	}
	
	@Test
	public void obterCorrentistaLogadoTest() throws Exception {
		CorrentistaVO correntistaVO = null;
		
		when(dao.obterCorrentista(Matchers.anyString())).thenReturn(mock(true));
			
		when(bean.obterCorrentista(Matchers.anyString())).thenCallRealMethod();
		
		correntistaVO = bean.obterCorrentista("38521876300");
		
		Assert.assertNotNull(correntistaVO);
		Assert.assertTrue(correntistaVO.isLogado());
	}
	
	private CorrentistaVO mock(boolean logado){
		CorrentistaVO correntista = new CorrentistaVO();
		
		correntista.setIdCorrentista(1);
		correntista.setNome("Nome Teste");
		correntista.setAgencia(100);
		correntista.setConta(3432);
		correntista.setLogado(logado);
		
		return correntista;
	}


}
