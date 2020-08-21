package com.marcos.teste.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import com.marcos.teste.service.DBservice;

	

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBservice dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	public String estrategia;
	
	@Bean
	public boolean instanciarBanco() {
		
		if(!"create".equals(estrategia)) {
			return false;
		}
		
		dbService.instanciarTesteBanco();
	
		
		return true;
	}
}
