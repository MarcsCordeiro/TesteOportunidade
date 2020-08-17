package com.marcos.teste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.teste.model.Marca;
import com.marcos.teste.repositories.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository mare;
	
	public Marca find(Integer id) {
		
		Optional<Marca> obj = mare.findById(id);
		return obj.orElse(null);
	}

}
