package com.EJ1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EJ1.dao.SuministraDAO;
import com.EJ1.dto.Suministra;

@Service
public class SuministraServiceImpl implements ISuministraService{
	
	@Autowired
	SuministraDAO iSuministraDAO;

	@Override
	public List<Suministra> listarSuministras() {
		// TODO Auto-generated method stub
		return iSuministraDAO.findAll();
	}

	@Override
	public Suministra guardarSuministra(Suministra Suministra) {
		// TODO Auto-generated method stub
			return iSuministraDAO.save(Suministra); //guardo el nuevo Suministra	
	}

	@Override
	public Suministra SuministraXID(int id) {
		// TODO Auto-generated method stub
		return iSuministraDAO.findById(id).get();
	}

	@Override
	public Suministra actualizarSuministra(Suministra Suministra) {
		// TODO Auto-generated method stub
		return iSuministraDAO.save(Suministra);
	}

	@Override
	public void eliminarSuministra(int id) {
		iSuministraDAO.deleteById(id);
		
	}

}
