package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pedido;
import com.example.demo.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
