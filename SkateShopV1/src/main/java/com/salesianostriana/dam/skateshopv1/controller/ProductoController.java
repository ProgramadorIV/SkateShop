package com.salesianostriana.dam.skateshopv1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.skateshopv1.model.BuscarBean;
import com.salesianostriana.dam.skateshopv1.service.ProductoService;

/**
 * 
 * @author jimenez.inant22
 * Controlador de todo lo relacionado con productos
 */

@Controller
public class ProductoController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private ProductoService service;
	
	/**
	 * 
	 * @param model
	 * @return String de la pagina tienda.
	 */	
//	@GetMapping("/tienda")
//	public String mostrarProductos(Model model) {
//		
//		model.addAttribute("productos", service.findAll());
//
//		model.addAttribute("buscarForm", new BuscarBean());
//		return "tienda";
//	}
//	
//	/**
//	 * 
//	 * @param buscarBean
//	 * @param model
//	 * @return String de la pagina tienda.
//	 */	
//	@PostMapping("/search")
//	  public String searchProducto(@ModelAttribute("buscarForm") BuscarBean buscarBean,
//			 Model model){
//	  	model.addAttribute("productos", service.findByNombre(buscarBean.getBusqueda()));
//	  
//	  return "tienda";
//	  }

//	@PostMapping("/mixedSearch")
//	  public String searchProductoV2(@ModelAttribute("buscarForm") BuscarBean buscarBean,
//			 Model model){
//	  	model.addAttribute("productos", service.findByNombre(buscarBean.getBusqueda()));
//	  
//	  return "tienda";
//	  }
	
}
