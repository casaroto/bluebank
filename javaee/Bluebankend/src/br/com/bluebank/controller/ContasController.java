package br.com.bluebank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.domain.CorrentistaVO;

 
@RestController
@RequestMapping("/rest")
public class ContasController {
	
	@RequestMapping(value = "/contas/transferencias/{cpf}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<CorrentistaVO> contasCadastradas(@PathVariable String cpf) {
	
		List<CorrentistaVO> retorno = new ArrayList<CorrentistaVO>();
		CorrentistaVO correntista1 = new CorrentistaVO();
		CorrentistaVO correntista2 = new CorrentistaVO();
		
		correntista1.setNome("Adriana");
		correntista2.setNome("Carolina");
		
		retorno.add(correntista1);
		retorno.add(correntista2);
		
		return retorno;
	}

}
