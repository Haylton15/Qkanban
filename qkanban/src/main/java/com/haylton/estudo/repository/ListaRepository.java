package com.haylton.estudo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haylton.estudo.model.Lista;


public interface ListaRepository extends JpaRepository<Lista, Integer>{
	List<Lista> findByNomeIgnoreCase(String nome);
}
