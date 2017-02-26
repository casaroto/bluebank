package br.com.bluebank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/service/")
public class BoasVindasController {
	
	@RequestMapping(value = "/boasvindas", method = RequestMethod.GET,headers="Accept=application/json")
	public Mensagem getUser() {
		
		return new Mensagem();
	}
	
}
