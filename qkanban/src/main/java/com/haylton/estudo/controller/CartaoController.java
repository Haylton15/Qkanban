package com.haylton.estudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haylton.estudo.model.Cartao;
import com.haylton.estudo.model.Lista;
import com.haylton.estudo.service.CartaoService;
import com.haylton.estudo.service.ListaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cartoes")
public class CartaoController {
	
	
	@Autowired
	private CartaoService service;
	
	@Autowired
	private ListaService listaService;
	
	@GetMapping("/")
	public List<Cartao> buscarPorTosdos(){
		return service.buscaPorTodos();
	}
	
	@GetMapping("/cartao/{id}")
	public Cartao buscarPorId(@PathVariable("id") Integer id) {
		return service.buscaPorId(id);
	}
	
	@PostMapping("/cartao/salvar")
	public Cartao salvar(@RequestBody Cartao cartao) {
		return service.salvar(cartao);
	}
	
	@PutMapping("/cartao/editar")
	public Cartao editar(@RequestBody Cartao cartao,@RequestBody Lista lista) {
		cartao.getListas().add(listaService.buscaPorId(lista.getId())); 
		return service.salvar(cartao);
	}
	
	@DeleteMapping("/cartao/deletar/{id}")
	public void apagar(@PathVariable("id") Integer id) {
		service.excluir(id);
	}
}
