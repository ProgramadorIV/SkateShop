package com.salesianostriana.dam.skateshopv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.salesianostriana.dam.skateshopv1.service.LineaVentaService;
import com.salesianostriana.dam.skateshopv1.service.ProductoService;
import com.salesianostriana.dam.skateshopv1.service.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	LineaVentaService lineaVentaService;
	
	@Autowired
	VentaService ventaService;
}
