package com.salesianostriana.dam.skateshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.salesianostriana.dam.skateshop.service.ProductoService;


@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	private String [] hola = {"1","2","3"};
	
	@GetMapping("/tienda")
	public String productList(Model model) {
			
//			model.addAttribute("productos", service.findAllProductos());
			model.addAttribute("productos", hola);
	
			return "tienda";
		}

}
