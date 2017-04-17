package com.algaworks.brewer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.repository.Cidades;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

	@Autowired
	private Cidades cidades;
	
	@RequestMapping("/novo")
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
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cidade> pesquisarPorCodigoEstao(@RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {	}
		return cidades.findByEstadoCodigo(codigoEstado);
	}
	
}
