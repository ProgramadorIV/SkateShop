package com.salesianostriana.dam.skateshopv1.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.skateshopv1.model.LineaVenta;
import com.salesianostriana.dam.skateshopv1.model.Producto;
import com.salesianostriana.dam.skateshopv1.model.Venta;
import com.salesianostriana.dam.skateshopv1.seguridad.RepositorioUsuario;

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
	RepositorioUsuario repositorioUsuario;
	
	private Map<Producto, Integer> productosEnCarrito = new HashMap<>();
	
	private static double descuentoVentaMayorQue100 = 10;
	private static double descuentoVentaMayorQue300 = 20;
	
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
		
		for(Producto p : productosEnCarrito.keySet()) {
			
			if(comprobarStock(p, productosEnCarrito.get(p)))
				total += p.getPrecio() * productosEnCarrito.get(p);
		}
		if(total>100)
			return total - total*descuentoVentaMayorQue100/100;
		else if(total>500)
			return total - total*descuentoVentaMayorQue300/100;
		
		return total;
	}
	
	public Map<Producto, Integer> getCarrito(){
		
		return Collections.unmodifiableMap(productosEnCarrito);
	}
	
	public void limpiarCarrito() {
		
		productosEnCarrito.clear();
	}
	
	public void modificarStock(Producto p, int unidades) {
		
		p.setCantidad(p.getCantidad()-unidades);
		
	}
	
	public boolean comprobarStock(Producto p, int unidades) {
	
		if((p.getCantidad()-unidades) >= 0)
			return true;
		else
			return false;
	}
	
	public List<Producto> avisarStockInsuficiente(){
		
		List<Producto> lista = new ArrayList<>();
		
		for (Producto p : productosEnCarrito.keySet()) {
			
			if(!comprobarStock(p, productosEnCarrito.get(p)))
				lista.add(p);
		}
		
		
		return lista;
	}
	
	public void finalizarCarrito() {
		
		LineaVenta lineaVenta;
		Venta venta;
		double totalAux=0;
		
		if(!productosEnCarrito.isEmpty()) {
			
			venta = Venta.builder()
					.fecha(LocalDate.now())
					.nombreUsuario(SecurityContextHolder.getContext().getAuthentication().getName())
					.build();
			
			ventaService.save(venta);
					
			for(Producto p : productosEnCarrito.keySet()) {
				
				Integer i = productosEnCarrito.get(p);
				
				if(comprobarStock(p, i)) {
					
					modificarStock(p, i);
					productoService.edit(p);
					
					lineaVenta = LineaVenta.builder()
						.cantidad(i)
						.precio(p.getPrecio()*i)
						.producto(p)
						.build();
					
					lineaVenta.incluirEnVenta(venta);
					
					lineaVentaService.save(lineaVenta);
					totalAux+= p.getPrecio()*i;
				}
				
			}
			
			//En el caso de que introduzcan más cantidades de las que disponemos o alguien las haya comprado antes.
			
			if(totalAux>0) {
				
				if(totalAux>100)
					venta.setImporte(totalAux - totalAux*descuentoVentaMayorQue100/100);
				else if(totalAux>500)
					venta.setImporte(totalAux - totalAux*descuentoVentaMayorQue300/100);
				else
					venta.setImporte(totalAux);
				
				ventaService.edit(venta);
			}
			
			else {
				ventaService.delete(venta);
			}			
			
			limpiarCarrito();
		}
	}
}
