package com.marcos.teste.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.marcos.teste.model.Usuario;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String nome;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String email;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String senha;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		senha = obj.getSenha();
	}
	
	

	public UsuarioDTO(Integer id,  String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
