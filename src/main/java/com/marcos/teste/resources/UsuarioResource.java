package com.marcos.teste.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcos.teste.dto.UsuarioDTO;
import com.marcos.teste.model.Usuario;
import com.marcos.teste.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usse;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Usuario obj = usse.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)	
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO objDTO){
		Usuario obj = usse.usuariDTO(objDTO);
		obj = usse.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable Integer id){
		obj = usse.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> listar = usse.findAll();   //Cria lista PatrimonioDTO para receber a lista de Patrimonio
		List<UsuarioDTO> listaDTO = listar.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
}
