package com.marcos.teste.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import com.marcos.teste.service.DBservice;

	

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBservice dbService;
	
	@Bean
	public boolean instanciarBanco() {
		
		dbService.instanciarTesteBanco();
	
		
		return true;
	}
}
