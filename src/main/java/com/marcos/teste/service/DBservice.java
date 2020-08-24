package com.marcos.teste.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marcos.teste.model.Marca;
import com.marcos.teste.model.Patrimonio;
import com.marcos.teste.model.Usuario;
import com.marcos.teste.model.enuns.Perfil;
import com.marcos.teste.repositories.MarcaRepository;
import com.marcos.teste.repositories.PatrimonioRepository;
import com.marcos.teste.repositories.UsuarioRepository;

@Service
public class DBservice {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private PatrimonioRepository patrimonioRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public boolean instanciarTesteBanco() {
		
		Marca ma1 = new Marca(null, "Cordeiro");
		Marca ma2 = new Marca(null, "BoaMoveis");
		
		marcaRepository.saveAll(Arrays.asList(ma1, ma2));
		
		Patrimonio pa1 = new Patrimonio(null, "Cadeira", "Sala de Jantar", 25, ma1);
		Patrimonio pa2 = new Patrimonio(null, "Mesa", "Sala de Reuniao", 35, ma2);
		
		patrimonioRepository.saveAll(Arrays.asList(pa1,pa2));
		
		
		Usuario us1 = new Usuario(null, "Marcos", "marcos@marcos.com",pe.encode("455mama"));
		us1.addPerfil(Perfil.USUARIO);
		Usuario us2 = new Usuario(null, "Dani", "dani@daniele.com", pe.encode("6262dd"));
		
		
		usuarioRepository.saveAll(Arrays.asList(us1,us2));
		
		return true;
		
	}

}
