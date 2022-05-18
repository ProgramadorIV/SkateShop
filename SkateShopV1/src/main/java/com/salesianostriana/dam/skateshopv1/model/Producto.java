package com.salesianostriana.dam.skateshopv1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @Entity
public class Producto {
	
	@Id @GeneratedValue
	private long idProducto;
	private String marca;
	private String nombre;
	private double precio;
	private int cantidad;
	private String tipo;
	private String imagen;
	

}
