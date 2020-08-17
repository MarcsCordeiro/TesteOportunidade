package com.marcos.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcos.teste.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
