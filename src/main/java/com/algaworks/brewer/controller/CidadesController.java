package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cidade;

@Controller
public class CidadesController {

	@RequestMapping("/cidades/novo")
	public String novo(Cidade cidade){
		return "cidade/CadastrarCidade";
	}
	
	public String salvar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return novo(cidade);
		}
		
		attributes.addFlashAttribute("mensagem","Cidade cadastrada com sucesso");
		
		return "redirect:cidades/novo";
	}
	
}
