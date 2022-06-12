package com.salesianostriana.dam.skateshopv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.skateshopv1.service.CarritoService;

@Controller
public class CarritoController {

	@Autowired
	CarritoService carritoService;
	
	@GetMapping("/meterEnCarrito/{id}")
	public String meterEnCarrito(@PathVariable("id") long id) {
		
		carritoService.meterProductoEnCarrito(id);
		return "redirect:/tienda";
	}
	
	@GetMapping("/carrito")
	public String meterCarritoEnVista(Model model) {
		
		model.addAttribute("carrito", carritoService.getCarrito());
		model.addAttribute("precioFinal", carritoService.calcularTotalCarrito());
		return "redirect:/tienda";
	}
	
	@GetMapping("/quitarDeCarrito/{id}")
	public String quitarDeCarrito(@PathVariable ("id") long id) {
		
		carritoService.quitarProductoDeCarrito(id);
		return "redirect/tienda";
	}
	
	@GetMapping("/limpiarCarrito")
	public String limpiarCarrito() {
		
		carritoService.limpiarCarrito();
		return "redirect/tienda";
	}
}
