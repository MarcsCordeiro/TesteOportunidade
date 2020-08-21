package com.marcos.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcos.teste.model.Marca;
import com.marcos.teste.model.Patrimonio;
import com.marcos.teste.model.Usuario;
import com.marcos.teste.repositories.MarcaRepository;
import com.marcos.teste.repositories.PatrimonioRepository;
import com.marcos.teste.repositories.UsuarioRepository;

@SpringBootApplication
public class SucessoApplication implements CommandLineRunner{
	
	

	public static void main(String[] args) {
		SpringApplication.run(SucessoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
	}

}
