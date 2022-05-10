package com.salesianostriana.dam.skateshop.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class LineaVenta {

	@Id @GeneratedValue
	private long idLineaVenta;
	private int cantidad;
	private double precio;
	
}
