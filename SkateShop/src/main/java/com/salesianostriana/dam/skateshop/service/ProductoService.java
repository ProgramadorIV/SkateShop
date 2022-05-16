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
}
