package com.salesianostriana.dam.skateshopv1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @Entity
public class LineaVenta {

	@Id @GeneratedValue
	private long idLineaVenta;
	private int cantidad;
	private double precio;
	
}
