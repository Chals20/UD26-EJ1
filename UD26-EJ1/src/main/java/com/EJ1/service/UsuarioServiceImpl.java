package com.EJ1.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.EJ1.dto.Rol;
import com.EJ1.dto.Usuario;
import com.EJ1.dto.UsuarioRol;
import com.EJ1.dao.*;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {
	
	@Autowired
	IUsuarioDAO userDAO;
	@Autowired
	UsuarioRolServiceImpl userService;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = userDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<>(); //Creamos colección que lista roles
		
		List<UsuarioRol> rolesUsuario = userService.buscarRolesUsuario(usuario);//Buscamos los roles
		rolesUsuario.forEach(rolUsuario -> {

			Rol rol = rolUsuario.getRol();
			
			roles.add(new SimpleGrantedAuthority("ROLE_" + rol.getName()));//agregamos nuevo rol
		});
		
		return new User(usuario.getUsername(), usuario.getPassword(), roles);
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		
		return userDAO.findAll();
	}

	@Override
	public Usuario buscarUsuario(String username) {
		
		return userDAO.findByUsername(username);
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {

		return userDAO.save(usuario);
	}
	

}
