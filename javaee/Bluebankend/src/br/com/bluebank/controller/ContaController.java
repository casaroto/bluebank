package br.com.bluebank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.dao.CorrentistaDAO;
import br.com.bluebank.domain.CorrentistaVO;

 
@RestController
@RequestMapping("/rest")
public class ContaController {
	
	@Autowired
	private CorrentistaDAO correntistaDAO;
	
	@RequestMapping(value = "/contas/cadastradas/transferencia/{cpfCnpjCorrentista}/", method = RequestMethod.GET,headers="Accept=application/json")
	public List<CorrentistaVO> contasCadastradas(@PathVariable String cpfCnpjCorrentista) {
	
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
