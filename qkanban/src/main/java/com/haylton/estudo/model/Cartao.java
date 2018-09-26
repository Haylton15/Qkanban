package com.haylton.estudo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Data;

@Data
@Entity
public class Cartao {
	@Id
	@SequenceGenerator(name="seq_cartao", sequenceName="seq_cartao", allocationSize=1)
	@GeneratedValue(generator="seq_cartao")
	private Integer id;
	
	private String titulo;
	
	private String descricao;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)   
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate dataCriacao;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)   
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate dataEntrega;
	
	private boolean concluido;
	@ManyToMany(mappedBy= "cartoes")
	private List<Lista> listas = new ArrayList<>();
	
	public Cartao(Integer id, String titulo, String descricao, LocalDate dataCriacao, LocalDate dataEntrega,
			boolean concluido, List<Lista> listas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataEntrega = dataEntrega;
		this.concluido = concluido;
		this.listas = listas;
	}

	public Cartao() {
		super();
	}
	
	
	
	
}
