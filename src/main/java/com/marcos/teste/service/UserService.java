package com.marcos.teste.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.marcos.teste.security.UserSS;

public class UserService {
	
	//Método que retorna o usuário logado
	public static UserSS authenticated() {
		try {
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
