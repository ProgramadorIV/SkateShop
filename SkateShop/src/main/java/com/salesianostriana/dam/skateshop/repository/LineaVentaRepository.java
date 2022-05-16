package com.salesianostriana.dam.skateshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.skateshop.model.LineaVenta;

@Repository
public interface LineaVentaRepository extends JpaRepository<LineaVenta, Long>{

}
