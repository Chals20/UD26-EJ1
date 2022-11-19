package com.EJ1.service;

import java.util.List;

import com.EJ1.dto.Suministra;

public interface ISuministraService {

	//Métodos del CRUD
	public List<Suministra> listarSuministras(); //Listar All
	
	public Suministra guardarSuministra(Suministra Suministra); //Guarda un Suministra CREATE
	
	public Suministra SuministraXID(int id); //Leer datos de un Suministra READ
	
	public Suministra actualizarSuministra(Suministra Suministra); //Actualiza datos del Suministra UPDATE
	
	public void eliminarSuministra(int id);//Elimina el Suministra DELETE
	
}
