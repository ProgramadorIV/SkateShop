package com.salesianostriana.dam.skateshopv1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @Entity
public class LineaVenta {

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Producto producto;
	
	private int cantidad;
	private double precio;
	private double descuento;
	
	@ManyToOne
	private Venta venta;
	
}
