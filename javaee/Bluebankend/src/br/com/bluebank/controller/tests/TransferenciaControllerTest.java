package br.com.bluebank.controller.tests;

import static org.mockito.Mockito.doNothing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

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
		controller = new TransferenciaController();
		ReflectionTestUtils.setField(controller, "transferenciaBean", bean);
	}
	
	@Test
	public void obterCorrentistaLogadoTest() throws Exception {
		doNothing().when(bean).efetuarTransferencia(ArgumentMatchers.any());
		
		RetornoOperacaoVO retornoOperacaoVO = controller.transferirValor(1, 2, 10.32);
		
		Assert.assertNotNull(retornoOperacaoVO);
		Assert.assertNotNull(retornoOperacaoVO.getMensagem());
	}
}
