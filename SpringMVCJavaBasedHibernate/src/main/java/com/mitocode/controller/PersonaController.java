package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Controller
public class PersonaController {
	
	@Autowired
	private IPersonaService service;

	@RequestMapping(value ="/personas", method = RequestMethod.GET)
	public ModelAndView redireccion() throws Exception {
		return new ModelAndView("listaPersonas", "personas", service.listarTodos());
	}
	
	@RequestMapping(value = "/irEditar", method = RequestMethod.GET)
	public ModelAndView irEditar(@RequestParam(value = "id") String id) throws Exception {
		return new ModelAndView("persona", "command", service.listarPorId(Integer.parseInt(id)));
	}
	
	@RequestMapping(value = "/irRegistrar", method = RequestMethod.GET)
	public ModelAndView irEditar() throws Exception {
		return new ModelAndView("persona", "command", new Persona());
	}
	
	@RequestMapping(value = "/remover", method = RequestMethod.GET)
	public ModelAndView remover(@RequestParam(value = "id") String id) throws Exception {
		if (id != null && Integer.parseInt(id) > 0) {
			Persona per = service.listarPorId(Integer.parseInt(id));
			if (per != null) {
				service.eliminar(per);
			}
		}
		return new ModelAndView("listaPersonas", "personas", service.listarTodos());
	}
	
	@RequestMapping(value = "operar", method = RequestMethod.POST)
	public ModelAndView operar(Persona per, ModelMap model) throws Exception{
		try {
			if(per.getId() == 0) {
				service.registrar(per);
			}else {
				service.modificar(per);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView("listaPersonas", "personas", service.listarTodos());
	}
}
