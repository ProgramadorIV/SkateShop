package com.salesianostriana.dam.skateshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.skateshop.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}
