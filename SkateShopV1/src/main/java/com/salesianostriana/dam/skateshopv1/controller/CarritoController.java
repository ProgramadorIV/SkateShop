package com.salesianostriana.dam.skateshopv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.skateshopv1.model.BuscarBean;
import com.salesianostriana.dam.skateshopv1.service.CarritoService;
import com.salesianostriana.dam.skateshopv1.service.ProductoService;

@Controller
public class CarritoController {

	@Autowired
	CarritoService carritoService;
	
	@Autowired
	ProductoService productoService;
	
	
	@GetMapping("/meterEnCarrito/{id}")
	public String meterEnCarrito(@PathVariable("id") long id) {
		
		carritoService.meterProductoEnCarrito(id);
		return "redirect:/tienda";
	}
	
	@GetMapping("/tienda")
	public String mostrarCarrito(Model model) {
		
		model.addAttribute("productos", productoService.findAll());
		model.addAttribute("buscarForm", new BuscarBean());
		model.addAttribute("carrito", carritoService.getCarrito());
		model.addAttribute("precioFinal", carritoService.calcularTotalCarrito());
		return "tienda";
	}
	
	@GetMapping("/quitarDeCarrito/{id}")
	public String quitarDeCarrito(@PathVariable ("id") long id) {
		
		carritoService.quitarProducto(id);
		return "redirect:/tienda";
	}
	
	
	@GetMapping("/quitarUnidad/{id}")
	public String quitarUnidad(@PathVariable ("id") long id) {
		
		carritoService.quitarUnidadProducto(id);
		return "redirect:/tienda";
	}
	
	@GetMapping("/limpiarCarrito")
	public String limpiarCarrito() {
		
		carritoService.limpiarCarrito();
		return "redirect:/tienda";
	}
}
