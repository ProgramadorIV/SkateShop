package com.salesianostriana.dam.skateshopv1.seguridad;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuario {
	
	private List<Usuario> usuarios;
	
	public List <Usuario> getUsuarios(){
		
		return Collections.unmodifiableList(usuarios);
	}
	
	public Optional <Usuario> findUsuarioByNombreUsuario(String nombreUsuario){
		
		return usuarios.stream()
				.filter(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
				.findFirst();
	}
	
	@PostConstruct
	public void iniciar() {
		
		usuarios = List.of(
				Usuario.builder()
				.nombreUsuario("admin")
				.clave("admin")
				.role("ADMIN")
				.nombre("Antonio")
				.apellidos("Jiménez Infante")
				.build()
				
				,
				
				Usuario.builder()
				.nombreUsuario("user")
				.clave("1234")
				.role("USER")
				.nombre("Clara Isabel")
				.apellidos("Infante de la Torre")
				.build()
				);
	}

}
