package br.com.bluebank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.domain.MensagemVO;
 
@RestController
@RequestMapping("/rest/")
public class BoasVindasController {
	
	@RequestMapping(value = "/boasvindas", method = RequestMethod.GET,headers="Accept=application/json")
	public MensagemVO getUser() {
		
		return new MensagemVO();
	}
	
}
