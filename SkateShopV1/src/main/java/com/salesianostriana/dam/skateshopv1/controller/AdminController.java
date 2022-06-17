package com.salesianostriana.dam.skateshopv1.controller;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.skateshopv1.model.Busqueda;
import com.salesianostriana.dam.skateshopv1.model.Producto;
import com.salesianostriana.dam.skateshopv1.service.LineaVentaService;
import com.salesianostriana.dam.skateshopv1.service.ProductoService;
import com.salesianostriana.dam.skateshopv1.service.VentaService;

@Controller
public class AdminController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private LineaVentaService lineaVentaService;
	

	@GetMapping("/admin")
	public String indiceAdmin(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		
		model.addAttribute("usuario", userDetails.getUsername());
		return "index";
	}
	

	@GetMapping("/admin/gestion")
	public String gestion(Model model) {
		
		model.addAttribute("productos", productoService.findAll());
		
		model.addAttribute("buscarForm", new Busqueda());
		return "gestion";
	}
	
	
	@PostMapping("/admin/search")
	  public String searchProductoAdmin(@ModelAttribute("buscarForm") Busqueda buscarBean,
			 Model model){
	  	model.addAttribute("productos", productoService.findByNombre(buscarBean.getBusqueda()));
	  
	  return "gestion";
	  }
	
	//METODOS PARA GESTION DE VENTAS
	
	@GetMapping("/admin/ventas")
	public String ventas(Model model) {
		
		model.addAttribute("ventas", ventaService.findAll(Sort.by(Direction.ASC, "fecha")));
		return "gestionVentas";
	}
	
	@GetMapping("/admin/ventas/filtroDesc")
	public String filtroDescendente(Model model) {
		
		model.addAttribute("ventas", ventaService.findAll(Sort.by(Direction.DESC, "fecha", "nombreUsuario")));
		return "gestionVentas";
	}
	
//	@GetMapping("/admin/ventas")
//	public String gestionVentas( @RequestParam("") , Model model) {
//		
//		model.addAttribute("ventas", ventaService.findAll());
//		
//		ventaService.findAll(Sort.by(Direction.ASC, "fecha"));
//		
//		
//		model.addAttribute("buscarForm", new BuscarBean());
//		return "gestionVentas";
//		
//	}
	
	//METODOS PARA AÑADIR PRODUCTOS
	@GetMapping("/admin/nuevoProducto")
	public String mostrarForm(Model model) {
		
		model.addAttribute("producto", new Producto());
		return"nuevoProducto";
	}
	
	@PostMapping("/admin/nuevoProducto/submit")
	public String procesarForm(@ModelAttribute("producto") Producto p) {
		
		productoService.save(p);
		return "redirect:/admin/gestion";
	}
	
	//METODOS PARA EDITAR PRODUCTOS
	
	@GetMapping("/admin/editarProducto/{id}")
	public String editarProducto(@PathVariable("id") long id, Model model) {

		Producto p = productoService.findById(id);
		if(p!=null) {
			model.addAttribute("producto", productoService.findById(id));
			return "nuevoProducto";
		}
		return "redirect:/admin/gestion";
	}
	
	@PostMapping("/admin/editarProducto/submit")
	public String procesarEdicion(@ModelAttribute("producto") Producto p) {
				
		productoService.edit(p);
		return "redirect:/admin/gestion";
	}
	
	//METODO PARA BORRAR PRODUCTOS
	
	@GetMapping("/admin/borrarProducto/{id}")
	public String borrarProducto(@PathVariable("id") long id) {
		
		Producto p = productoService.findById(id);
		
		if(p!=null) {
			
			if(lineaVentaService.esProductoBorrable(p)) 
				return "redirect:/admin/gestion/?error=true";
			
			else
				productoService.deleteById(id);
		}
		
		
		return "redirect:/admin/gestion";
	}
	
	
}
