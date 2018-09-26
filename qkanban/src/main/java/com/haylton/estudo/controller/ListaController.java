package com.haylton.estudo.controller;

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

import com.haylton.estudo.model.Lista;
import com.haylton.estudo.service.ListaService;

@RestController
@RequestMapping("/listas")
public class ListaController {
	
	@Autowired
	private ListaService service;
	
	@GetMapping("/")
	public List<Lista> buscaPorTodos(){
		return service.buscaPorTodos();
	}
	
	@GetMapping("/lista/{id}")
	public Lista buscaPorId(@PathVariable("id") Integer id) {
		return service.buscaPorId(id);
	}
	
	@GetMapping("/lista/{nome}")
	public List<Lista> buscaPorNome(@PathVariable("nome") String nome){
		return service.buscarPorNome(nome);
	}
	
	@PostMapping("/lista/salvar")
	public Lista salvar(@RequestBody Lista lista) {
		return service.salvar(lista);
	}
	
	@PutMapping("/lista/editar")
	public Lista editar(@RequestBody Lista lista) {
		return service.salvar(lista);
	}
	
	@DeleteMapping("/lista/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		service.excluir(id);
	}
	
}
