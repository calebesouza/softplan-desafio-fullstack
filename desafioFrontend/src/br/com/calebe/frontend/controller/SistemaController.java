package br.com.calebe.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SistemaController {
	
	@RequestMapping(value = "/principal", method = RequestMethod.GET)
	public ModelAndView principal() {
		ModelAndView modelAndView = new ModelAndView("principal/dashboard");
		return modelAndView;
	}
	
	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET)
	public ModelAndView listarUsuarios() {
		ModelAndView modelAndView = new ModelAndView("usuario/listar");
		return modelAndView;
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.GET)
	public ModelAndView cadastrarUsuario() {
		ModelAndView modelAndView = new ModelAndView("usuario/cadastrar");
		return modelAndView;
	}
	
	@RequestMapping(value = "/alterarUsuario", method = RequestMethod.GET)
	public ModelAndView alterarUsuario(String id) {
		ModelAndView modelAndView = new ModelAndView("usuario/alterar");
		modelAndView.addObject("id", id);
		return modelAndView;
	}

	@RequestMapping(value = "/listarProcessos", method = RequestMethod.GET)
	public ModelAndView listarProcessos() {
		ModelAndView modelAndView = new ModelAndView("processo/listar");
		return modelAndView;
	}
	
	@RequestMapping(value = "/cadastrarProcesso", method = RequestMethod.GET)
	public ModelAndView cadastrarProcesso() {
		ModelAndView modelAndView = new ModelAndView("processo/cadastrar");
		return modelAndView;
	}
	
	@RequestMapping(value = "/visualizarProcesso", method = RequestMethod.GET)
	public ModelAndView visualizarProcesso(String id) {
		ModelAndView modelAndView = new ModelAndView("processo/visualizar");
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	@RequestMapping(value = "/atribuirUsuariosProcesso", method = RequestMethod.GET)
	public ModelAndView atribuirUsuariosProcesso(String id) {
		ModelAndView modelAndView = new ModelAndView("processo/atribuir-usuarios");
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	@RequestMapping(value = "/cadastrarParecer", method = RequestMethod.GET)
	public ModelAndView cadastrarParecer(String id) {
		ModelAndView modelAndView = new ModelAndView("processo/parecer");
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
}