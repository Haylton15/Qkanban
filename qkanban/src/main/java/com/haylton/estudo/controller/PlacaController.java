package com.haylton.estudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haylton.estudo.model.Placa;
import com.haylton.estudo.service.PlacaService;

@RestController
@RequestMapping("/placas")
@CrossOrigin("*")
public class PlacaController {

	@Autowired
	private PlacaService placaService;
	
	@GetMapping("/")
	public List<Placa> buscaPorTodos(){
		return placaService.buscaPorTodos();
	}
	
	@PostMapping("/salvar")
	public Placa salvar(@RequestBody Placa placa) {
		return placaService.salvar(placa);
	}
	
	@PutMapping("/editar")
	public Placa editar(@RequestBody Placa placa) {
		return placaService.salvar(placa);
	}
	
	@DeleteMapping("/deletar/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		placaService.excluir(id);
	}
	
	@GetMapping("/placa/{id}")
	public Placa buscaPorId(@PathVariable("id") Integer id) {
		return placaService.buscaPorId(id);
	}
}
