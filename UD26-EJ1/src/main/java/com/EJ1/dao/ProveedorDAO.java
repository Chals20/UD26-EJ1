package com.EJ1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EJ1.dto.Proveedor;

public interface ProveedorDAO extends JpaRepository<Proveedor, Integer>{

	public Proveedor findById(String id);
}
