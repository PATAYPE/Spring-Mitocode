package com.mitocode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {		
		return "login";
	}	
	
	@RequestMapping(value = "/saludar", method = RequestMethod.GET)
	public String saludar(ModelMap model) {
		model.addAttribute("nombres", "Mito");
		model.addAttribute("apellidos", "Code");
		return "persona";
	}
	
	@RequestMapping(value = "/mostrar", method = RequestMethod.POST)
	public ModelAndView saludar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("persona");
		mv.addObject("nombres", "Mito");
		mv.addObject("apellidos", "Code");			
		return mv;
	}

}
