package com.salesianostriana.dam.skateshopv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 
 * @author jimenez.inant22
 * Controlador que contiene todas las peticiones sin relación con entidades.
 */
@Controller
public class GeneralController {
	
	/**
	 * Este método solo pinta la página galeria.
	 * @param model
	 * @return String de la pagina galeria.
	 */
	
	@GetMapping("/galeria")
	public String mostrarGaleria(Model model) {
		
		return "galeria";
	}
	
	/**
	 * 
	 * @param model
	 * @return String de la página de error.
	 */
	
	@GetMapping("/error")
	public String mostrarError(Model model) {
		
		return "error";
	}
	
	
	

}
