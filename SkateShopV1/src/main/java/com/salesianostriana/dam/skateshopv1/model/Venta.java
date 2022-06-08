package com.salesianostriana.dam.skateshopv1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @Entity
public class Venta {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	private LocalDate fecha;
	private double importe;
	
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="venta")
	private List <LineaVenta> lineasVenta = new ArrayList<>();
}
