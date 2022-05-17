package com.salesianostriana.dam.skateshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.skateshop.repository.ProductoRepository;
import com.salesianostriana.dam.skateshop.model.Producto;


@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	public List <Producto> findAllProductos(){
		
		return repository.findAll();
	}
	
	public List <Producto> findByMarca(String marca){
		
		return repository.findByMarcaContainsIgnoreCase(marca);
	}
	
	public List<Producto> findByTipo (String tipo){
		
		return repository.findByTipoContainsIgnoreCase(tipo);
	}
	
	public List<Producto> findByNombre(String nombre){
		
		return repository.findByNombreContainsIgnoreCase(nombre);
	}
	
	public Producto addProducto(Producto p) {
		
		return repository.save(p);
		
	}
	
	public Producto editProducto (Producto p) {
		
		return repository.save(p);
	}
	
	public void deleteProducto(Producto p) {
		
		repository.delete(p);
	}
}
