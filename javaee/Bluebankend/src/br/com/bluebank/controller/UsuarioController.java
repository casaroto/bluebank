package br.com.bluebank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluebank.domain.CorrentistaVO;
 
@RestController
@RequestMapping("/rest")
public class UsuarioController {
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET,headers="Accept=application/json")
	public CorrentistaVO getUsuario() {
	
		CorrentistaVO usuario = new CorrentistaVO();
		
		usuario.setLogado(true);
		
		return usuario;
	}

}
