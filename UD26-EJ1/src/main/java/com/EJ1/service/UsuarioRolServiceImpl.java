package com.EJ1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EJ1.dto.Usuario;
import com.EJ1.dto.UsuarioRol;
import com.EJ1.dao.*;

@Service
public class UsuarioRolServiceImpl {

	@Autowired
	IUsuarioRolDAO iUsuarioRolDAO;
	
	public UsuarioRol guardaUsuarioRol(UsuarioRol usuarioRol) {
		return iUsuarioRolDAO.save(usuarioRol);
	}
	
	public List<UsuarioRol> listaUsuarioRols (){
		return iUsuarioRolDAO.findAll();
	}
	
	public List<UsuarioRol> buscarRolesUsuario(Usuario usuario){
		return iUsuarioRolDAO.findByUsuario(usuario);
	}
}
