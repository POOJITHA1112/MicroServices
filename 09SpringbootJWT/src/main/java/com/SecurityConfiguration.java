package com;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.JwtAuthenticationEntryPoint;
import com.jwt.JwtRequestFilter;

@Configuration
public class SecurityConfiguration {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf((csrf)->csrf.disable());
		http.authorizeHttpRequests((authorizeHttpRequests)->{
			
			authorizeHttpRequests.antMatchers("/signin","/signup","/role").permitAll();
			authorizeHttpRequests.antMatchers("/hello").authenticated();
			authorizeHttpRequests.antMatchers("/security").authenticated();
			

 
		});
//		http.formLogin(Customizer.withDefaults());
		
		http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
		.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder);
	}
	
	 @Bean
	 public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		 return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	 }
	
}
