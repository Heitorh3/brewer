package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Usuario;

@Controller
public class UsuariosController {

	@RequestMapping("/usuarios/novo")
	public String novo(Usuario usuario){
		return "usuario/CadastroUsuario";
	}
	
	@RequestMapping("/usuarios/salvar")
	public String salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return novo(usuario);
		}
		
		attributes.addFlashAttribute("mensagem","Usuário salvo com sucesso.");
		
		return "redirect:/usuarios/novo";
	}
}
