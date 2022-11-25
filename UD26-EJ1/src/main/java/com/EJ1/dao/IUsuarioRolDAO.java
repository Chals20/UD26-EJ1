package com.EJ1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EJ1.dto.*;

public interface IUsuarioRolDAO extends JpaRepository<UsuarioRol, Long>{

	public List<UsuarioRol> findByUsuario(Usuario usuario);
	
}
