package com.salesianostriana.dam.skateshopv1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.skateshopv1.repository.ProductoRepository;
import com.salesianostriana.dam.skateshopv1.service.base.ServicioBaseImpl;
import com.salesianostriana.dam.skateshopv1.model.Producto;


@Service
public class ProductoService extends ServicioBaseImpl<Producto, Long, ProductoRepository>{

	@Autowired
	private ProductoRepository repository;
	
	public List <Producto> findByMarca(String marca){
		
		return repository.findByMarcaContainsIgnoreCase(marca);
	}
	
	public List<Producto> findByTipo (String tipo){
		
		return repository.findByTipoContainsIgnoreCase(tipo);
	}
	
	public List<Producto> findByNombre(String nombre){
		
		return repository.findByNombreContainsIgnoreCase(nombre);
	}
	
	public List <Producto> findByFiltros(String nombre, String tipo, String marca){
		
		return repository.findByNombreLikeAndTipoLikeAndMarcaLike(nombre, tipo, marca);
	}
	
}
