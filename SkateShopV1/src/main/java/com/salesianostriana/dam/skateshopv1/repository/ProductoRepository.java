package com.salesianostriana.dam.skateshopv1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.salesianostriana.dam.skateshopv1.model.*;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

	List<Producto> findByMarcaContainsIgnoreCase (String marca);
	
	List<Producto> findByTipoContainsIgnoreCase (String tipo);
	
	List<Producto> findByNombreContainsIgnoreCase (String nombre);
}
