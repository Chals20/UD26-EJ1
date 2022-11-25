package com.EJ1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EJ1.dto.*;

public interface IRolDAO extends JpaRepository<Rol, Long> {

	public Rol findByName(String name);
	
}