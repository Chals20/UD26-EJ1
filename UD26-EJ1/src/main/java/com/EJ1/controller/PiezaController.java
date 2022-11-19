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

import com.EJ1.dto.Pieza;
import com.EJ1.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImpl PiezaServiceImpl;
	
	//listar todos las piezas
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return PiezaServiceImpl.listarPiezas();
	}
	
	//guardar una Pieza
	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza Pieza) {//los datos llegan desde el body del request
		return PiezaServiceImpl.guardarPieza(Pieza);
	}
	
	//mostrar una pieza según ID
	@GetMapping("/piezas/{id}") 
	public Pieza PiezaXID(@PathVariable(name="id") int id){ // 
		Pieza Pieza_xid = new Pieza();
		
		Pieza_xid=PiezaServiceImpl.PiezaXID(id);//buscamos la pieza segun la ID y asignamos los datos a la instancia
		
		System.out.println("Pieza XID: "+Pieza_xid);
		
		return Pieza_xid;//devuelvemos la pieza
	}
	
	//actualizar pieza con Id indicado
	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")int id,@RequestBody Pieza Pieza) {
		
		Pieza Pieza_seleccionado= new Pieza();
		Pieza Pieza_actualizado= new Pieza();
		
		Pieza_seleccionado= PiezaServiceImpl.PiezaXID(id);
		
		Pieza_seleccionado.setNombre(Pieza.getNombre());
		Pieza_seleccionado.setSuministra(Pieza.getSuministra());
		
		Pieza_actualizado = PiezaServiceImpl.actualizarPieza(Pieza_seleccionado);
		
		System.out.println("El Pieza actualizado es: "+ Pieza_actualizado);
		
		return Pieza_actualizado;
	}
	
	//eliminar pieza con ID indicado
	@DeleteMapping("/piezas/{id}")
	public void eleiminarPieza(@PathVariable(name="id")int id) {
		PiezaServiceImpl.eliminarPieza(id);
	}
}
