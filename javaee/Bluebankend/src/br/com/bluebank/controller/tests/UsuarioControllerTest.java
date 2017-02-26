package br.com.bluebank.controller.tests;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import org.junit.Test;

import br.com.bluebank.controller.UsuarioController;
import br.com.bluebank.domain.UsuarioVO;

 

public class UsuarioControllerTest {
	
	@Test(expected=AssertionFailedError.class)
	public void getUsuarioNaoLogadoTest() {
		UsuarioVO usuario = null;
		
		UsuarioController controller = new UsuarioController();
		
		usuario = controller.getUsuario();
		
		Assert.assertFalse(usuario.isLogado());
	}

}
