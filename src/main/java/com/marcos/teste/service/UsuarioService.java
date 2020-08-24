package com.marcos.teste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marcos.teste.dto.UsuarioDTO;
import com.marcos.teste.model.Usuario;
import com.marcos.teste.model.enuns.Perfil;
import com.marcos.teste.repositories.UsuarioRepository;
import com.marcos.teste.resources.exception.FieldMessage;
import com.marcos.teste.security.UserSS;
import com.marcos.teste.service.exceptions.AuthorizationException;
import com.marcos.teste.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository usre;
	
	public Usuario find(Integer id) {
		
		UserSS user = UserService.authenticated();
		if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
		throw new AuthorizationException("Acesso negado");
	}
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
		return new Usuario(objDTO.getId(),objDTO.getNome(),objDTO.getEmail(),pe.encode(objDTO.getSenha()));
	}
	
	
		

}
