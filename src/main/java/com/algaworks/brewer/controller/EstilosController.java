package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.service.CadastroEstiloService;

@Controller
public class EstilosController {

	private CadastroEstiloService cadastroEstiloService;
	
	@RequestMapping("/estilos/novo")
	public ModelAndView novo(Estilo estilo){
		ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
		return mv;
	}
	
	
	public ModelAndView salvar(@Valid Estilo estilo, RedirectAttributes attributes, BindingResult result){
		if(result.hasErrors()){
			return novo(estilo);
		}
		
		cadastroEstiloService.salvar(estilo);
		attributes.addFlashAttribute("mensagem","Estilo salvo com sucesso.");
		
		 return new ModelAndView("redirect:/estilos/novo");
	}
}
