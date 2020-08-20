package com.marcos.teste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.marcos.teste.model.Usuario;
import com.marcos.teste.repositories.UsuarioRepository;
import com.marcos.teste.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usre;
	
	public Usuario find(Integer id) {
		
		Optional<Usuario> obj = usre.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}
