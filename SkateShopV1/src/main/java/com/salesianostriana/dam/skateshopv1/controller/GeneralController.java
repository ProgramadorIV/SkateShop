package com.salesianostriana.dam.skateshopv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class GeneralController {
	
	
	@GetMapping("/galeria")
	public String mostrarGaleria(Model model) {
		
		return "galeria";
	}
	

	@GetMapping("/error")
	public String mostrarError(Model model) {
		
		return "error";
	}
	
	
	

}
