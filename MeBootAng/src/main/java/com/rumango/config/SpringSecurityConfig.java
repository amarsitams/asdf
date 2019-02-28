package com.rumango.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.rumango.controller.UserController;

//This is Security Configuation for Login and password encryting
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	 private static final Logger logger=LoggerFactory.getLogger(UserController.class);


	
	public SpringSecurityConfig()
	{
		logger.info("Created\t"+this.getClass().getSimpleName());
		System.out.println("Created\t"+this.getClass().getSimpleName());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/**","/").permitAll()
        .anyRequest()
        .permitAll()
        .and()
        .formLogin();
	}

}
