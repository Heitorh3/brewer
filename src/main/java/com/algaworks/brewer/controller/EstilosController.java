package com.algaworks.brewer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.controller.page.PageWrapper;
import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.repository.Estilos;
import com.algaworks.brewer.repository.filter.EstiloFilter;
import com.algaworks.brewer.service.CadastroEstiloService;
import com.algaworks.brewer.service.exception.ImpossivelExcluirEntidadeException;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;

@Controller
@RequestMapping("/estilos")
public class EstilosController {

	@Autowired
	private CadastroEstiloService cadastroEstiloService;
	
	@Autowired
	private Estilos estilos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Estilo estilo){
		return new ModelAndView("estilo/CadastroEstilo");
	}
	
	@PostMapping({"/novo", "{\\+d}"})
	public ModelAndView salvar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes, Model model){
		if(result.hasErrors()){
			model.addAttribute(estilo);
			return novo(estilo);
		}
		
		try {
			cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastradoException e){
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		
		attributes.addFlashAttribute("mensagem","Estilo salvo com sucesso.");
		
		 return new ModelAndView("redirect:/estilos/novo");
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result){
	
		if(result.hasErrors()){
			return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage());
		}
		
		estilo = cadastroEstiloService.salvar(estilo);
		return ResponseEntity.ok(estilo);
	}
	
	@GetMapping
	public ModelAndView pesquisar(EstiloFilter estiloFilter,BindingResult result, @PageableDefault(size = 2 )Pageable pageable, HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("estilo/PesquisaEstilos");
		
		PageWrapper<Estilo> pagina = new PageWrapper<Estilo>(estilos.filtra(estiloFilter, pageable), httpServletRequest);
		
		mv.addObject("pagina", pagina);
		return mv;
	}
	
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo")Estilo estilo){
		
		try {
			cadastroEstiloService.excluir(estilo);
		}catch(ImpossivelExcluirEntidadeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo")Long codigo) {
		Estilo estilo = estilos.findOne(codigo);
		ModelAndView mv = novo(estilo);
		mv.addObject(estilo);
		
		return mv;
	}
}
