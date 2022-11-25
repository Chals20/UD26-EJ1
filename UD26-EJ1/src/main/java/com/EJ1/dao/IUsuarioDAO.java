package com.EJ1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EJ1.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
	
}
