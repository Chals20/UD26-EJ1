package com.EJ1.service;

import java.util.List;

import com.EJ1.dto.Usuario;

public interface IUsuarioService {
	 
	public List<Usuario> listarUsuarios();
	
	public Usuario buscarUsuario(String username);
	
	public Usuario guardarUsuario(Usuario usuario);
}
