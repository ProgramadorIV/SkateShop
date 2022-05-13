package com.salesianostriana.dam.skateshop.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Producto {
	
	@Id @GeneratedValue
	private long idProducto;
	private String marca;
	private String nombre;
	private double precio;
	private int cantidad;
	private String tipo;
	private double descuento;
	private String imagen;
	

}
