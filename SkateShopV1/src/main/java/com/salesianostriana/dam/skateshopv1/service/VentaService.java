package com.salesianostriana.dam.skateshopv1.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.skateshopv1.model.Venta;
import com.salesianostriana.dam.skateshopv1.repository.VentaRepository;
import com.salesianostriana.dam.skateshopv1.service.base.ServicioBaseImpl;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VentaService extends ServicioBaseImpl<Venta, Long, VentaRepository>{
	

}
