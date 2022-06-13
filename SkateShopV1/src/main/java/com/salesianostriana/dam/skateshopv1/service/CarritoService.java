package com.salesianostriana.dam.skateshopv1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.skateshopv1.model.LineaVenta;
import com.salesianostriana.dam.skateshopv1.model.Producto;
import com.salesianostriana.dam.skateshopv1.model.Venta;
import com.salesianostriana.dam.skateshopv1.repository.LineaVentaRepository;
import com.salesianostriana.dam.skateshopv1.repository.ProductoRepository;
import com.salesianostriana.dam.skateshopv1.repository.VentaRepository;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	LineaVentaService lineaVentaService;
	
	@Autowired
	VentaService ventaService;
	
	@Autowired 
	ProductoRepository productoRepository;
	
	private Map<Producto, Integer> productosEnCarrito = new HashMap<>();
	
	public void meterProductoEnCarritoCheckOut(Producto p) {
		
		Integer i = productosEnCarrito.putIfAbsent(p, 1);
		if(i!=null)
			productosEnCarrito.replace(p, i+1);
		
	}
	
	public void meterProductoEnCarrito(long id) {
		
		Producto p = productoService.findById(id);
		
		if(p!=null)
			meterProductoEnCarritoCheckOut(p);
		
	}
	
	public void quitarUnidadProductoCheckOut(Producto p) {
		
		if(productosEnCarrito.get(p)==1)
			productosEnCarrito.remove(p);
		else
			productosEnCarrito.replace(p, productosEnCarrito.get(p)-1);
			
	}
	
	public void quitarUnidadProducto(Long id) {
		
		Producto p = productoService.findById(id);
		
		if(p!=null)
			quitarUnidadProductoCheckOut(p);
			
	}
	
	public void quitarProducto(long id) {
		
		Producto p = productoService.findById(id);
		
		if(p!=null) {
			productosEnCarrito.remove(p);
		}
	}
	
	public double calcularTotalCarrito() {
		
		double total = 0;
		
		for(Producto p : productosEnCarrito.keySet())			
			total += p.getPrecio() * productosEnCarrito.get(p);
		
		return total;
	}
	
	public Map<Producto, Integer> getCarrito(){
		
		return Collections.unmodifiableMap(productosEnCarrito);
	}
	
	public void limpiarCarrito() {
		
		productosEnCarrito.clear();
	}
	
	public void finalizarCarrito() {
		
		
		java.util.List<LineaVenta> lineaVenta = new ArrayList<>();
		Venta venta;
		
		for(Map.Entry<Producto, Integer> miCarro : productosEnCarrito.entrySet()) {
			
				
		}
		
		
		productoRepository.flush();
		limpiarCarrito();
	}
}
