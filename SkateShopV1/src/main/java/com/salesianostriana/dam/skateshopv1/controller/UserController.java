package com.salesianostriana.dam.skateshopv1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.skateshopv1.model.Venta;
import com.salesianostriana.dam.skateshopv1.seguridad.RepositorioUsuario;
import com.salesianostriana.dam.skateshopv1.seguridad.Usuario;
import com.salesianostriana.dam.skateshopv1.service.VentaService;

@Controller
public class UserController {
	
	@Autowired
	RepositorioUsuario repositorioUsuario;
	
	@Autowired
	VentaService ventaService;

	@GetMapping("/user")
	public String indiceUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		model.addAttribute("usuario", userDetails.getUsername());
		return "user/index";
	}
	
	@GetMapping("/user/compras")
	public String mostrarCompras(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		Usuario u = repositorioUsuario.findUsuarioByNombreUsuario(userDetails.getUsername()).get();
		
		List<Venta> listaVentas =  new ArrayList<>();
		
		for(Venta v : ventaService.findAll()) {
			
			if(userDetails.getUsername().equalsIgnoreCase(v.getNombreUsuario()))
				listaVentas.add(v);
		}
		
		model.addAttribute("nombreComprador", u.getNombre() +" "+ u.getApellidos());
		model.addAttribute("compras", listaVentas);
		
		return "tusVentas";

	}
	
	
}
