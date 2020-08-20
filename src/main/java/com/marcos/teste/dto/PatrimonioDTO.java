package com.marcos.teste.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.marcos.teste.model.Patrimonio;

public class PatrimonioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nome;
	private String descricao;
	private Integer tombo;
	
	public PatrimonioDTO() {
		
	}
	
	//Convertendo para poder usar em PatrimonioResource
	public PatrimonioDTO(Patrimonio obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
		tombo = obj.getTombo();
		
	}

	public PatrimonioDTO(Integer id, String nome, String descricao, Integer tombo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tombo = tombo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTombo() {
		return tombo;
	}

	public void setTombo(Integer tombo) {
		this.tombo = tombo;
	}
	
	

}
