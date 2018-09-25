package com.haylton.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haylton.estudo.model.Placa;
import com.haylton.estudo.repository.PlacaRepository;

@Service
public class PlacaService {
	
	@Autowired
	private PlacaRepository repository;
	
	public Placa salvar(Placa p) {
		return repository.save(p);
	}
	
	public List<Placa> buscarPorNome(String nome){
		return repository.findByNomeIgnoreCase(nome);
	}
	
	public Placa buscaPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Placa> buscaPorTodos(){
		return repository.findAll();
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
	
	
}
