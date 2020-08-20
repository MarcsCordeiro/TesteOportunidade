package com.marcos.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.teste.model.Marca;
import com.marcos.teste.repositories.MarcaRepository;
import com.marcos.teste.service.exceptions.ObjectNotFoundException;


@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository mare;
	
	public Marca find(Integer id) {
		
		Optional<Marca> obj = mare.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Marca.class.getName()));
	}
	
	
	public Marca insert(Marca obj) {
		obj.setMarcaId(null); //
		return mare.save(obj);
	}
	
	public Marca update(Marca obj) {
		find(obj.getMarcaId()); //Verifica se dado está na lista, se não está lança a exeção
		return mare.save(obj);
	}
	
	public List<Marca> findAll(){
		return mare.findAll();
	}

}
