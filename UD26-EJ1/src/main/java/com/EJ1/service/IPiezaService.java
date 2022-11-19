package com.EJ1.service;

import java.util.List;

import com.EJ1.dto.Pieza;

public interface IPiezaService {
	
	// Métodos del CRUD
	public List<Pieza> listarPiezas(); // Listar All

	public Pieza guardarPieza(Pieza Pieza); // Guarda un Pieza CREATE

	public Pieza PiezaXID(int id); // Leer datos de un Pieza READ

	public Pieza actualizarPieza(Pieza Pieza); // Actualiza datos del Pieza UPDATE

	public void eliminarPieza(int id);// Elimina el Pieza DELETE

}
