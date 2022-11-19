package com.EJ1.service;

import java.util.List;

import com.EJ1.dto.Proveedor;

public interface IProveedorService {

	//Métodos del CRUD
	public List<Proveedor> listarProveedors(); //Listar All
	
	public Proveedor guardarProveedor(Proveedor Proveedor); //Guarda un Proveedor CREATE
	
	//public Proveedor ProveedorXID(String id); //Leer datos de un Proveedor READ
	
	public Proveedor findById(String id);//buscar proveedor por id
	
	public Proveedor actualizarProveedor(Proveedor Proveedor); //Actualiza datos del Proveedor UPDATE
	
	public void eliminarProveedor(int id);//Elimina el Proveedor DELETE
	
}