package com.salesianostriana.dam.skateshopv1.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @Entity
public class Venta {

	@Id @GeneratedValue
	private long idVenta;
	private LocalDate fecha;
	private double importe;
}
