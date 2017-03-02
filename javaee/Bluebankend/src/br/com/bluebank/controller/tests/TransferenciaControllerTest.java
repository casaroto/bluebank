package br.com.bluebank.controller.tests;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import br.com.bluebank.business.TransferenciaBean;
import br.com.bluebank.controller.TransferenciaController;
import br.com.bluebank.domain.RetornoOperacaoVO;

public class TransferenciaControllerTest {
	
	@Mock
	private TransferenciaBean bean;
	
	@Mock
	private TransferenciaController controller;
	
	@Before
	public void init(){
		bean = Mockito.mock(TransferenciaBean.class);
		controller = Mockito.mock(TransferenciaController.class);
		Whitebox.setInternalState(controller, "transferenciaBean", bean);
	}
	
	@Test
	public void obterCorrentistaLogadoTest() {
		when(controller.transferirValor(Matchers.anyInt(), Matchers.anyInt(), Matchers.anyDouble())).thenCallRealMethod();
		
		RetornoOperacaoVO retornoOperacaoVO = controller.transferirValor(1, 2, 10.32);
		
		Assert.assertNotNull(retornoOperacaoVO);
		Assert.assertNotNull(retornoOperacaoVO.getMensagem());
	}
	
	
	private RetornoOperacaoVO mock(){
		RetornoOperacaoVO retornoOperacaoVO = new RetornoOperacaoVO();
		retornoOperacaoVO.setSucesso(true);
		retornoOperacaoVO.setMensagem("Sucesso operação");
		return retornoOperacaoVO;
	}


}
