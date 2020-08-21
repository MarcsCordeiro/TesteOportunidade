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

import com.marcos.teste.dto.PatrimonioDTO;
import com.marcos.teste.model.Patrimonio;
import com.marcos.teste.service.PatrimonioService;

@RestController
@RequestMapping(value = "/patrimonios")
public class PatrimonioResource {

	@Autowired
	private PatrimonioService pase;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Patrimonio obj = pase.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)	
	public ResponseEntity<Void> insert(@Valid @RequestBody PatrimonioDTO objDTO){
		Patrimonio obj = pase.patriDTO(objDTO);
		obj = pase.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Patrimonio obj, @PathVariable Integer id){
		obj = pase.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<PatrimonioDTO>> findAll() {
		List<Patrimonio> listar = pase.findAll();
		//Cria lista PatrimonioDTO para receber a lista de Patrimonio
		List<PatrimonioDTO> listaDTO = listar.stream().map(obj -> new PatrimonioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
}
