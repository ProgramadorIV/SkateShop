package com.salesianostriana.dam.skateshop.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Venta {

	@Id @GeneratedValue
	private long idVenta;
	private LocalDate fecha;
	private double importe;
}