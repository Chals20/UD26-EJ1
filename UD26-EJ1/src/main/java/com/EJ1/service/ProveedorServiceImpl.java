package com.EJ1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EJ1.dao.ProveedorDAO;
import com.EJ1.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	ProveedorDAO iProveedorDAO;
	
	@Override
	public List<Proveedor> listarProveedors() {

		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor Proveedor) {

			return iProveedorDAO.save(Proveedor); //guardo el nuevo Proveedor	
	}

	public Proveedor findById(String id) {

		return iProveedorDAO.findById(id);
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor Proveedor) {

		return iProveedorDAO.save(Proveedor);
	}

	@Override
	public void eliminarProveedor(int id) {
		iProveedorDAO.deleteById(id);
		
	}
	
}
