package com.haylton.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haylton.estudo.model.Cartao;
import com.haylton.estudo.repository.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository repository;
	
	public List<Cartao> buscaPorTodos(){
		return repository.findAll();
	}
	
	public Cartao buscaPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public Cartao salvar(Cartao cartao) {
		return repository.save(cartao);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
	
}
