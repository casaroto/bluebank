package br.com.bluebank.controller.tests;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import br.com.bluebank.business.CorrentistaBean;
import br.com.bluebank.controller.CorrentistaController;
import br.com.bluebank.domain.CorrentistaVO;

public class CorrentistaControllerTest {
	
	@Mock
	private CorrentistaBean correntistaBean;
	
	@Mock
	private CorrentistaController correntistaController;
	
	@Before
	public void init(){
		correntistaBean = Mockito.mock(CorrentistaBean.class);
		correntistaController = Mockito.mock(CorrentistaController.class);
		Whitebox.setInternalState(correntistaController, "correntistaBean", correntistaBean);
	}
	
	@Test
	public void obterCorrentistaLogadoTest() {
		CorrentistaVO usuario = null;
		
		when(correntistaBean.obterCorrentista(Matchers.anyString())).thenReturn(mock(true));
			
		when(correntistaController.obterCorrentistaLogado(Matchers.anyString())).thenCallRealMethod();
		
		usuario = correntistaController.obterCorrentistaLogado("38521876300");
		
		Assert.assertNotNull(usuario);
		Assert.assertTrue(usuario.isLogado());
		Assert.assertNotNull(usuario.getNome());
	}
	
	@Test
	public void listarCorrentistasCadastradosTransferenciaTest() {
		List<CorrentistaVO> usuario = null;
		
		when(correntistaBean.listarCorrentistasCadastradosTransferencia(Matchers.anyString())).thenReturn(mockLista());
			
		when(correntistaController.listarCorrentistasCadastradosTransferencia(Matchers.anyString())).thenCallRealMethod();
		
		usuario = correntistaController.listarCorrentistasCadastradosTransferencia("38521876300");
		
		Assert.assertNotNull(usuario);
		Assert.assertTrue(!usuario.isEmpty());
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

	
	private List<CorrentistaVO> mockLista(){
		List<CorrentistaVO>  lista = new ArrayList<CorrentistaVO>();
		CorrentistaVO correntista = new CorrentistaVO();
		
		correntista.setIdCorrentista(1);
		correntista.setNome("Nome Teste");
		correntista.setAgencia(100);
		correntista.setConta(3432);
		correntista.setLogado(false);
		
		lista.add(correntista);
		
		return lista;
	}

}
