package br.com.bluebank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class BoasVindasController {


	@RequestMapping(value = "/boasvindas", method = RequestMethod.GET)
	public @ResponseBody String ola() {
 
		String message = "ola";
	
		
		return message;
	}
}
