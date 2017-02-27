package br.com.bluebank.controller.tests;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Test;

import br.com.bluebank.controller.CorrentistaController;
import br.com.bluebank.domain.CorrentistaVO;

 

public class CorrentistaControllerTest {
	
	@Test(expected=AssertionFailedError.class)
	public void getUsuarioNaoLogadoTest() {
		CorrentistaVO usuario = null;
		
		CorrentistaController controller = new CorrentistaController();
		
		usuario = controller.obterCorrentistaLogado("191");
		
		Assert.assertFalse(usuario.isLogado());
	}

}
