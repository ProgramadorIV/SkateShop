package com.salesianostriana.dam.skateshopv1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.skateshopv1.model.Busqueda;
import com.salesianostriana.dam.skateshopv1.service.ProductoService;



@Controller
public class ProductoController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private ProductoService service;
	
	@GetMapping("/tienda")
	public String mostrarCarrito(Model model) {
		model.addAttribute("productos", service.findAll());
		model.addAttribute("buscarForm", new Busqueda());
		return "tienda";
	}
	
	@PostMapping("/search")
	  public String searchProducto(@ModelAttribute("buscarForm") Busqueda busqueda,
			 Model model){
	  	model.addAttribute("productos", service.findByNombre(busqueda.getBusqueda()));
	  
	  return "tienda";
	 }
	
//	@PostMapping("/mixedSearch")
//	  public String searchProductoV2(@ModelAttribute("buscarForm") BuscarBean buscarBean,
//			 Model model){
//	  	model.addAttribute("productos", service.findByNombre(buscarBean.getBusqueda()));
//	  
//	  return "tienda";
//	  }
	
}
