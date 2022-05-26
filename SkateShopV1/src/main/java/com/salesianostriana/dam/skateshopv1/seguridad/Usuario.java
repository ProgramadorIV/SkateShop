package com.salesianostriana.dam.skateshopv1.seguridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

	private String nombreUsuario;
	private String clave;
	private String role;
	private String nombre, apellidos;
}
