package com.marcos.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.teste.dto.PatrimonioDTO;
import com.marcos.teste.model.Marca;
import com.marcos.teste.model.Patrimonio;
import com.marcos.teste.repositories.PatrimonioRepository;
import com.marcos.teste.service.exceptions.ObjectNotFoundException;

@Service
public class PatrimonioService {
	
	@Autowired
	private PatrimonioRepository pare;
	
	public Patrimonio find(Integer id) {
		
		Optional<Patrimonio> obj = pare.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Patrimonio.class.getName())); 
	}
	
	
	public Patrimonio insert(Patrimonio obj) {
		obj.setId(null); //
		return pare.save(obj);
	}
	
	public Patrimonio update(Patrimonio obj) {
		return pare.save(obj);
	}
	
	public List<Patrimonio> findAll(){
		return pare.findAll();
	}
	
	//Método para PatrimonioResource para findAll
	public Patrimonio patriDTO(PatrimonioDTO objDTO) {
		return new Patrimonio(objDTO.getId(),objDTO.getNome(),objDTO.getDescricao(),objDTO.getTombo(), null);
	}

}
