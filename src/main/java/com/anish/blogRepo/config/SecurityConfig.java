package com.anish.blogRepo.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.anish.blogRepo.service.impl.CustomUseruserDetailsService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf((csrf -> csrf.disable()))
                .authorizeHttpRequests()
                .requestMatchers("/api/users/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin(withDefaults())
                .build();
		
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails adminUser = User.withUsername("Anish")
//				.password(encoder.encode("password"))
//				.roles("ADMIN")
//				.build();
//		
//		UserDetails normalUser = User.withUsername("siya")
//				.password(encoder.encode("password"))
//				.roles("NORMAL")
//				.build();
		
		return new CustomUseruserDetailsService() ;
	}
	 
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
}
