package com.salesianostriana.dam.skateshopv1.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

public interface ServicioBase<T, ID> {
		
		
		public List<T> findAll();
		
		public List<T> findAll(Sort s);
		
		public T findById(ID id);
		
		public T save(T a);
		
		public List<T> saveAll(List<T> list);
		
		public T edit(T a);
		
		public void delete(T a);
		
		public void deleteById(ID id);
		

}

