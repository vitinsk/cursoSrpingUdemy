package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Categoria;
import com.example.demo.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id){
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
