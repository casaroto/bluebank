package br.com.bluebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.business.TransferenciaBean;
import br.com.bluebank.domain.RetornoOperacaoVO;
import br.com.bluebank.domain.TransferenciaVO;


@RestController
@RequestMapping("/rest")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaBean transferenciaBean;
	
	@RequestMapping(value = "/transferencia", method = RequestMethod.POST,headers="Accept=application/json")
	public RetornoOperacaoVO listarCorrentistasCadastradosTransferencia(TransferenciaVO transferenciaVO) {
		 String mensagem = "";
		 boolean sucesso = false;
		 
		 RetornoOperacaoVO retorno =  new RetornoOperacaoVO();
		 
		 try {
			transferenciaBean.efetuarTransferencia(transferenciaVO);
			mensagem = "Operação efetuada com sucesso!";
			sucesso = true;
		} catch (Exception e) {
			mensagem = e.getMessage();
			e.printStackTrace();
		}
		
		 retorno.setMensagem(mensagem);
		 retorno.setSucesso(sucesso);
		 
		 return retorno;
	}

}
