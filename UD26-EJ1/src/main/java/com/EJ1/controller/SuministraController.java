package com.EJ1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EJ1.dto.Suministra;
import com.EJ1.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl SuministraServiceImpl;

	// listar todos los suministros
	@GetMapping("/suministros")
	public List<Suministra> listarSuministras() {
		return SuministraServiceImpl.listarSuministras();
	}

	// guardar un suministro
	@PostMapping("/suministros")
	public Suministra salvarSuministra(@RequestBody Suministra Suministra) {
		return SuministraServiceImpl.guardarSuministra(Suministra);
	}

	// mostrar un suministro según ID
	@GetMapping("/suministros/{id}")
	public Suministra SuministraXID(@PathVariable(name = "id") int id) { 
		
		Suministra Suministra_xid = new Suministra();
		System.out.println(id);
		Suministra_xid = SuministraServiceImpl.SuministraXID(id);

		System.out.println("Suministra XID: " + Suministra_xid);

		return Suministra_xid;
	}

	// actualizar los datos de un suministro según ID
	@PutMapping("/suministros/{id}")
	public Suministra actualizarSuministra(@PathVariable(name = "id") int id, @RequestBody Suministra Suministra) {

		Suministra Suministra_seleccionado = new Suministra();
		Suministra Suministra_actualizado = new Suministra();

		Suministra_seleccionado = SuministraServiceImpl.SuministraXID(id);

		Suministra_seleccionado.setPrecio(Suministra.getPrecio());
		Suministra_seleccionado.setPieza(Suministra.getPieza());
		Suministra_seleccionado.setProveedor(Suministra.getProveedor());

		Suministra_actualizado = SuministraServiceImpl.actualizarSuministra(Suministra_seleccionado);

		System.out.println("El suministro actualizado es: " + Suministra_actualizado);

		return Suministra_actualizado;
	}

	// eliminar suministro indicado por ID
	@DeleteMapping("/suministros/{id}")
	public void eleiminarSuministra(@PathVariable(name = "id") int id) {
		SuministraServiceImpl.eliminarSuministra(id);
	}
}
