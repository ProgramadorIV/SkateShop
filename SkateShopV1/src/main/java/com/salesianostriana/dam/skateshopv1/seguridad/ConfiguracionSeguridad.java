package com.salesianostriana.dam.skateshopv1.seguridad;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private RepositorioUsuario usuarios;

	
	@Override
	public void configure(AuthenticationManagerBuilder autenticacion) throws Exception {
		// TODO Auto-generated method stub
		autenticacion.userDetailsService(userDetailsService());
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.headers().frameOptions().disable().and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
			.antMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll().and().exceptionHandling()
			.accessDeniedPage("/error").and().formLogin()
			.defaultSuccessUrl("/").loginPage("/logIn")
			.loginProcessingUrl("/logIn").failureUrl("/logInError").permitAll()
			.and().logout()
			.logoutUrl("/logOut").logoutSuccessUrl("/").permitAll();
		
	
	}
	
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		
		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
		
		usuarios.getUsuarios()
				.stream()
				.map(u -> {
					return User
							.withUsername(u.getUsername())
							.password("{noop}" + u.getPassword())
							.roles(u.getRole())
							.build();
					
				}).forEach(detailsManager :: createUser);
		
		
		return detailsManager;
	}
}
