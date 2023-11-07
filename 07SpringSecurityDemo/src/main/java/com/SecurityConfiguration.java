package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
//	 IN MEMORY AUTHENTICATION
	
//	@Bean
	//{noop} this is for no encrypted password
//	if we are not providing password encrypter and not using {noop} then login page redirects to the same page
//	public UserDetailsService userDetailsService() {
//		UserDetails user=User.builder().username("user").password("{noop}user").roles("USER").build();
//		UserDetails admin=User.builder().username("admin").password("{noop}admin").roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	
//	@Bean
//	 with Bcrypt password encoder
//	public UserDetailsService userDetailsService() {
//		UserDetails user=User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER").build();
//		UserDetails admin=User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	
	
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf((csrf) -> csrf.disable());
		httpSecurity.authorizeHttpRequests((authorizeHttpRequests)->{
			authorizeHttpRequests.antMatchers("/public","/signUp").permitAll();
			authorizeHttpRequests.antMatchers("/security").authenticated();
			authorizeHttpRequests.antMatchers("/admin").hasRole("ADMIN");
			authorizeHttpRequests.antMatchers("/user").hasRole("USER");
			
		});
		httpSecurity.formLogin(Customizer.withDefaults());
		return httpSecurity.build();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
	
	

}
