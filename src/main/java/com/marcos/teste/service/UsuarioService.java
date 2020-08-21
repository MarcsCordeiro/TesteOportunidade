package com.marcos.teste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidatorContext;

import org.apache.logging.log4j.message.FormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.teste.dto.UsuarioDTO;
import com.marcos.teste.model.Usuario;
import com.marcos.teste.repositories.UsuarioRepository;
import com.marcos.teste.service.exceptions.ObjectNotFoundException;

import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.implementation.bind.annotation.FieldValue;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usre;
	
	public Usuario find(Integer id) {
		
		Optional<Usuario> obj = usre.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null); //
		return usre.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		return usre.save(obj);
	}
	
	public List<Usuario> findAll(){
		return usre.findAll();
	}
	
	//Método para PatrimonioResource para findAll
	public Usuario usuariDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(),objDTO.getNome(),objDTO.getEmail(),objDTO.getSenha());
	}
	
	
		

}
