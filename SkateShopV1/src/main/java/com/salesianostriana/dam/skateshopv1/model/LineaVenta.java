package com.salesianostriana.dam.skateshopv1.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @Entity
public class LineaVenta {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int cantidad;
	private double precio;
	
	@OneToOne
	private Producto producto;
	
	@ManyToOne
	private Venta venta;
	
	
	public void incluirEnVenta(Venta venta) {
		
		this.venta = venta;
		venta.getLineasVenta().add(this);
	}
	
	public void quitarDeVenta(Venta venta) {
		
		venta.getLineasVenta().remove(this);
		this.venta = null;
	}
	
}
