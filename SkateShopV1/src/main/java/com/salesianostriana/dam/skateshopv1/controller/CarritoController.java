package com.salesianostriana.dam.skateshopv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.skateshopv1.service.CarritoService;

@Controller
public class CarritoController {

	@Autowired
	CarritoService carritoService;
	
	@GetMapping("/tienda/meterEnCarrito/{id}")
	public String meterEnCarritoDesdeTienda(@PathVariable("id") long id) {
	
		carritoService.meterProductoEnCarrito(id);
		return "redirect:/tienda";
	}
	
	@GetMapping("/meterEnCarrito/{id}")
	public String meterEnCarrito(@PathVariable("id") long id) {
		
		carritoService.meterProductoEnCarrito(id);
		return "redirect:/carrito";
	}
	
	@GetMapping("/carrito")
	public String mostrarCarrito(Model model) {
		model.addAttribute("carrito", carritoService.getCarrito());
		model.addAttribute("precioFinal", carritoService.calcularTotalCarrito());
		return "carrito";
	}
	
	@GetMapping("/quitarDeCarrito/{id}")
	public String quitarDeCarrito(@PathVariable ("id") long id) {
		
		carritoService.quitarProducto(id);
		return "redirect:/carrito";
	}
	
	
	@GetMapping("/quitarUnidad/{id}")
	public String quitarUnidad(@PathVariable ("id") long id) {
		
		carritoService.quitarUnidadProducto(id);
		return "redirect:/carrito";
	}
	
	@GetMapping("/limpiarCarrito")
	public String limpiarCarrito() {
		
		carritoService.limpiarCarrito();
		return "redirect:/carrito";
	}
	
	@GetMapping("/user/comprarCarrito")
	public String comprarCarrito() {
		
		carritoService.finalizarCarrito();
		return "redirect:/";
	}
}
