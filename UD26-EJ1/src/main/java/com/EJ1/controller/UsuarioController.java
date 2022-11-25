package com.EJ1.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EJ1.dto.Rol;
import com.EJ1.dto.Usuario;
import com.EJ1.dto.UsuarioRol;
import com.EJ1.service.RolServiceImpl;
import com.EJ1.service.UsuarioRolServiceImpl;
import com.EJ1.service.UsuarioServiceImpl;
import com.EJ1.dto.UsuarioRolForm;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

	@Autowired
	RolServiceImpl rolService;
	
	@Autowired
	UsuarioRolServiceImpl userRolService;
	
	@Autowired
	UsuarioServiceImpl userService;
	
	private final BCryptPasswordEncoder contraCodificar;

	public UsuarioController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.contraCodificar = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	//listar roles de user
	@GetMapping("/usuarios/roles/{username}")
	public List<Rol> listarRolesUsuario(@PathVariable(name = "username") String username) {

		Usuario user = userService.buscarUsuario(username);

		List<UsuarioRol> rolUSer = userRolService.buscarRolesUsuario(user);
		
		List<Rol> roles = new ArrayList<>();
		
		rolUSer.forEach(rolUsuario -> {
			
			roles.add(rolUsuario.getRol());//añadimos rol a la lista
			
		});
		return roles;

	}
	//listar usuarios
	@GetMapping("/usuarios")
	public List<Usuario> listasrUsuarios(){
		return userService.listarUsuarios();
	}
	
	//Usuario por username
	@GetMapping("/usuarios/{username}")
	public Usuario buscarUsuario(@PathVariable(name="username")String username) {
		return userService.buscarUsuario(username);
	}
	
	//Guardar usuario
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		usuario.setPassword(contraCodificar.encode(usuario.getPassword()));//se codifica la contraseña
		return userService.guardarUsuario(usuario);
	}
	
	//añadir rol a usuario
	@PostMapping("/usuarios/rol")
	public UsuarioRol agregarRolUsuario(@RequestBody UsuarioRolForm rolForm) {
		System.out.println(rolForm.getUsername());
		
		Usuario user = userService.buscarUsuario(rolForm.getUsername());
		
		Rol rol = rolService.buscarRol(rolForm.getRolName());
		
		UsuarioRol userRol = new UsuarioRol(null,user, rol);
		
		return userRolService.guardaUsuarioRol(userRol);
	}
	
}



