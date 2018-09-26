package com.haylton.estudo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	private String responsavel;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)   
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate dataCriacao; 
	
	@JsonDeserialize(using = LocalDateDeserializer.class)   
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate dataEntrega;
	
	private boolean concluido;
	@ManyToMany(fetch = FetchType.LAZY,
 
                    mappedBy= "cartoes")
	private List<Lista> listas = new ArrayList<>();
	
	
}
