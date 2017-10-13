package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboradController {

	@GetMapping("/")
	public ModelAndView bashboard(){
		ModelAndView mv = new ModelAndView("Dashboard");
		
		return mv;
	}
}
