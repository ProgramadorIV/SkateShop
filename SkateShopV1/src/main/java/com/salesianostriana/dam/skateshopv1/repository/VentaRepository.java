package com.salesianostriana.dam.skateshopv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.skateshopv1.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}
