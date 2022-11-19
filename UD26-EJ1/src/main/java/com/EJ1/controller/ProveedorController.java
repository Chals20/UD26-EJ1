package com.EJ1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EJ1.dto.Proveedor;
import com.EJ1.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl ProveedorServiceImpl;
	
	//listar todos los proveedores
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedors(){
		return ProveedorServiceImpl.listarProveedors();
	}
	
	//guardar un proveedor
	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor Proveedor) {
		return ProveedorServiceImpl.guardarProveedor(Proveedor);
	}
	
	//mostrar un proveedor según ID
	@GetMapping("/proveedores/{id}") 
	public Proveedor ProveedorXID(@PathVariable(name="id") String id){ 
		Proveedor Proveedor_xid = new Proveedor();
		
		Proveedor_xid=ProveedorServiceImpl.findById(id);
		
		System.out.println("Proveedor XID: "+Proveedor_xid);
		
		return Proveedor_xid;
	}
	
	//actualizar  datos de un proveedor según ID
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")String id,@RequestBody Proveedor Proveedor) {
		
		Proveedor Proveedor_seleccionado= new Proveedor();
		Proveedor Proveedor_actualizado= new Proveedor();
		
		Proveedor_seleccionado= ProveedorServiceImpl.findById(id);
		
		Proveedor_seleccionado.setNombre(Proveedor.getNombre());
		Proveedor_seleccionado.setSuministra(Proveedor.getSuministra());
		
		Proveedor_actualizado = ProveedorServiceImpl.actualizarProveedor(Proveedor_seleccionado);
		
		System.out.println("El Proveedor actualizado es: "+ Proveedor_actualizado);
		
		return Proveedor_actualizado;
	}
	
	//eliminar el Proveedor segun ID 
	@DeleteMapping("/proveedores/{id}")
	public void eleiminarProveedor(@PathVariable(name="id")int id) {
		ProveedorServiceImpl.eliminarProveedor(id);
	}
}
