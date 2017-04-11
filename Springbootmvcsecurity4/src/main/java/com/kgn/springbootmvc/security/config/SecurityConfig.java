package com.kgn.springbootmvc.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{	

	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/user").hasRole("USER")
		.and()
		.formLogin();
		

	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("kgn").password("test").roles("USER")
		.and()
		.withUser("naga").password("test").roles("ADMIN");
		
	}

}
