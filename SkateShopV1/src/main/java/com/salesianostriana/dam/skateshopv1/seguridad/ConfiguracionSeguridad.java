package com.salesianostriana.dam.skateshopv1.seguridad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Esta clase 
 * @author Usuario
 *
 */
@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private RepositorioUsuario usuarios;

	/**
	 * 
	 */
	@Override
	public void configure(AuthenticationManagerBuilder autenticacion) throws Exception {
		// TODO Auto-generated method stub
		autenticacion.userDetailsService(userDetailsService());
	}
	
	/**
	 * 
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
			.antMatchers("/user/**").hasRole("ADMIN")
			.anyRequest().permitAll()
			.and().exceptionHandling().accessDeniedPage("/error")
			.and().formLogin().loginPage("/logIn")
			.loginProcessingUrl("/login").failureUrl("/loginError").permitAll()
			.and().logout()
			.logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
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
							.withUsername(u.getNombreUsuario())
							.password("{noop}" + u.getClave())
							.roles(u.getRole())
							.build();
					
				}).forEach(detailsManager :: createUser);
		
		
		return detailsManager;
	}
}
