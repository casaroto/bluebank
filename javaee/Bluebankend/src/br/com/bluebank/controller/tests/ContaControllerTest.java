package br.com.bluebank.controller.tests;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bluebank.controller.ContaController;
import br.com.bluebank.domain.CorrentistaVO;


public class ContaControllerTest {
	
	@Test
	public void contasCadastradasRespostaValidaTest() {
		List<CorrentistaVO> contas = null;
		
		ContaController controller = new ContaController();
		
		contas = controller.contasCadastradas("191");
		
		Assert.assertNotNull(contas);
	}
	
	@Test
	public void contasCadastradaPossuiMaisdeUmaContaTest() {
		List<CorrentistaVO> contas = null;
		
		ContaController controller = new ContaController();
		
		contas = controller.contasCadastradas("191");
		
		Assert.assertTrue(contas.size() > 0);
	}

}