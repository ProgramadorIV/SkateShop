package com.salesianostriana.dam.skateshopv1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.skateshopv1.model.BuscarBean;
import com.salesianostriana.dam.skateshopv1.service.ProductoService;

@Controller
public class AdminController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private ProductoService service;
	
	/**
	 * Método que permite mostrar la página de inicio y muestra que estas logeado como administrador.
	 * @param model
	 * @param userDetails
	 * @return String de la página de inicio.
	 */

	@GetMapping("/admin")
	public String indiceAdmin(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		model.addAttribute("usuario", userDetails.getUsername());
		return "index";
	}
	
	/**
	 * Método que añade todos los productos para ser mostrados.
	 * @param model
	 * @return String de la página de gestión.
	 */
	
	@GetMapping("/admin/gestion")
	public String gestion(Model model) {
		
		model.addAttribute("productos", service.findAll());
		
		model.addAttribute("buscarForm", new BuscarBean());
		return "gestion";
	}
	
	/**
	 * Método que permite al administrador buscar por nombre.
	 * @param buscarBean
	 * @param model
	 * @return String de la página de gestión.
	 */
	
	@PostMapping("/admin/search")
	  public String searchProductoAdmin(@ModelAttribute("buscarForm") BuscarBean buscarBean,
			 Model model){
	  	model.addAttribute("productos", service.findByNombre(buscarBean.getBusqueda()));
	  
	  return "gestion";
	  }
	
	//INCOMPLETO
	@GetMapping("/admin/nuevoProducto")
	public String nuevoProducto() {
		
		return"nuevoProducto";
	}
	
}
