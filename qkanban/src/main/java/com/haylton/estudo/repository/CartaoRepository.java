package com.haylton.estudo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haylton.estudo.model.Cartao;


public interface CartaoRepository extends JpaRepository<Cartao, Integer>{
	List<Cartao>findByTituloContainingIgnoreCase(String titulo);
}
