package br.com.bluebank.controller;
/*
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;*/

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/service/")
public class BoasVindasController {
	
	@RequestMapping(value = "/boasvindas", method = RequestMethod.GET,headers="Accept=application/json")
	public Mensagem getUser() {
		//User user=userService.getUserById(id);
		
		return new Mensagem();
	}
	
	//@RequestMapping("/boasvindas", produces="application/json")
	//@RequestMapping("/boasvindas")
	//public @ResponseBody Mensagem ola() {
	//@RequestMapping(value = "/boasvindas", method = RequestMethod.GET, produces = "application/json")
	/*@RequestMapping(value = "/boasvindas", method = RequestMethod.GET)
	public String ola() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>OLá</h3>**********</div><br><br>";
		//return new ModelAndView("boasvindas", "message", message);
		
		return message;
	}*/

	//@RequestMapping(value = "/boasvindas", method = RequestMethod.GET, produces = "application/json")
	/*@RequestMapping(value="/rest", produces = "application/json")
	public String ola() {
 
		
		//String message = "ola";
		System.out.print("testeer $$$$$$$$$$$$$");
		
		//return new Mensagem();
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>OLá</h3>**********</div><br><br>";
		return "{\"teste\";10}";
	}
	
	
	@RequestMapping("/bova")
	public ModelAndView ola2() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>OLá</h3>**********</div><br><br>";
		return new ModelAndView("boasvindas", "message", message);
	}*/
}
