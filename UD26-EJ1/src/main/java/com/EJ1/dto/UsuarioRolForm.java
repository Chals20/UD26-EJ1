package com.EJ1.dto;

public class UsuarioRolForm {

	private String username;
	private String rol;

	public UsuarioRolForm(String username, String rol) {
			this.username = username;
			this.rol = rol;
		}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRolName() {
		return rol;
	}

	public void setRolName(String rol) {
		this.rol = rol;
	}
}
