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
	
	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private PatrimonioRepository patrimonioRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(SucessoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Marca ma1 = new Marca(null, "Cordeiro");
		Marca ma2 = new Marca(null, "BoaMoveis");
		
		marcaRepository.saveAll(Arrays.asList(ma1, ma2));
		
		Patrimonio pa1 = new Patrimonio(null, "Cadeira", "Sala de Jantar", 25, ma1);
		Patrimonio pa2 = new Patrimonio(null, "Mesa", "Sala de Reuniao", 35, ma2);
		
		patrimonioRepository.saveAll(Arrays.asList(pa1,pa2));
		
		
		Usuario us1 = new Usuario(null, "Marcos", "marcos@marcos.com", "455mama");
		
		usuarioRepository.saveAll(Arrays.asList(us1));
		
	}

}
