package com.salesianostriana.dam.skateshopv1.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.skateshopv1.model.LineaVenta;
import com.salesianostriana.dam.skateshopv1.model.Producto;
import com.salesianostriana.dam.skateshopv1.repository.LineaVentaRepository;
import com.salesianostriana.dam.skateshopv1.service.base.ServicioBaseImpl;

@Service
public class LineaVentaService extends ServicioBaseImpl<LineaVenta, Long, LineaVentaRepository>{

	public boolean esProductoBorrable(Producto p) {
		
		return repositorio.countByProducto(p)>0;
	}
}
