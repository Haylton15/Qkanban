package com.haylton.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haylton.estudo.model.Lista;
import com.haylton.estudo.repository.ListaRepository;

@Service
public class ListaService {
	
	@Autowired
	private ListaRepository repository;
	
	public List<Lista> buscaPorTodos(){
		return repository.findAll();
	}
	
	public Lista buscaPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Lista> buscarPorNome(String nome){
		return repository.findByNomeIgnoreCase(nome);
	}
	
	public Lista salvar(Lista lista) {
		return repository.save(lista);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
