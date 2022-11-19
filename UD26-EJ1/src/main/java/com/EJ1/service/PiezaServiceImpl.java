package com.EJ1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EJ1.dao.PiezaDAO;
import com.EJ1.dto.Pieza;

@Service
public class PiezaServiceImpl implements IPiezaService{

	@Autowired
	PiezaDAO iPiezaDAO;

	@Override
	public List<Pieza> listarPiezas() {

		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza Pieza) {

		return iPiezaDAO.save(Pieza); // guardo pieza
	}

	@Override
	public Pieza PiezaXID(int id) {

		return iPiezaDAO.findById(id).get();
	}

	@Override
	public Pieza actualizarPieza(Pieza Pieza) {

		return iPiezaDAO.save(Pieza);
	}

	@Override
	public void eliminarPieza(int id) {
		
		iPiezaDAO.deleteById(id);

	}
}
