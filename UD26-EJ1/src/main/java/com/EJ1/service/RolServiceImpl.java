package com.EJ1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EJ1.dto.Rol;
import com.EJ1.dao.*;

@Service
public class RolServiceImpl {

	@Autowired
	IRolDAO rolDAO;
	
	public Rol buscarRol(String name) {
		return rolDAO.findByName(name);
	}
	
	public Rol guardarRol(Rol rol) {
		return rolDAO.save(rol);
	}
	
	public Rol rolXID(Long id) {
		return rolDAO.findById(id).get();
	}
}
