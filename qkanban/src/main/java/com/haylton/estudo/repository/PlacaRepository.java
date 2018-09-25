package com.haylton.estudo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haylton.estudo.model.Placa;

public interface PlacaRepository extends JpaRepository<Placa, Integer> {
	List<Placa> findByNomeIgnoreCase(String nome);
}
