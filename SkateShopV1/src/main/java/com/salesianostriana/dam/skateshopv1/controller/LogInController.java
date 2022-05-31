package com.salesianostriana.dam.skateshopv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author Usuario
 * Controlador de peticiones referidas al login de usuario.
 */

@Controller
public class LogInController {
	
	/**
	 * Este método pinta la página de inicio de sesión.
	 * @param model
	 * @return String de la página de inicio de sesión.
	 */
	
	@GetMapping("/logIn")
	public String mostrarLogIn() {
		
		return "logIn";
	}
	
	/**
	 * Método que asigna el valor true a la variable logInError.
	 * @param model
	 * @return string de la página de inicio de sesión.
	 */
	
	@GetMapping("/logInError")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "logIn";
    }
	
}
