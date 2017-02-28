package br.com.bluebank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.business.CorrentistaBean;
import br.com.bluebank.domain.CorrentistaVO;


@RestController
@RequestMapping("/rest")
public class CorrentistaController {
	
	@Autowired
	private CorrentistaBean correntistaBean;
	
	@RequestMapping(value = "/correntista/{cpfCnpjCorrentista}", method = RequestMethod.GET,headers="Accept=application/json")
	public CorrentistaVO obterCorrentistaLogado(@PathVariable String cpfCnpjCorrentista) {
		CorrentistaVO usuario = new CorrentistaVO();
		
		 usuario = correntistaBean.obterCorrentista(cpfCnpjCorrentista);
		
		 usuario.setLogado(true);
		 
		return usuario;
	}
	
	@RequestMapping(value = "/correntistas/cadastrados/transferencia/{cpfCnpjCorrentista}", method = RequestMethod.GET,headers="Accept=application/json")
	public List<CorrentistaVO> listarCorrentistasCadastradosTransferencia(@PathVariable String cpfCnpjCorrentista) {
		
		 List<CorrentistaVO> listaCorrentistas = new ArrayList<CorrentistaVO>();
		
		 listaCorrentistas = correntistaBean.listarCorrentistasCadastradosTransferencia(cpfCnpjCorrentista);
		
		return listaCorrentistas;
	}

}
