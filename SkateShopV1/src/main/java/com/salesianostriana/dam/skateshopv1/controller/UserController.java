package com.salesianostriana.dam.skateshopv1.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user")
	public String indiceUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		model.addAttribute("usuario", userDetails.getUsername());
		return "user/index";
	}
	
	
}
