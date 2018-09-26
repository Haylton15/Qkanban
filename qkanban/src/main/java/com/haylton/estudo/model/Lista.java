package com.haylton.estudo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@Data
@Entity
public class Lista {
	@Id
	@SequenceGenerator(name="seq_lista", sequenceName="seq_lista", allocationSize=1)
	@GeneratedValue(generator="seq_lista")
	private Integer id;
	private String nome;
	@JoinColumn 
	@ManyToOne
	private Placa placa;
	
	@ManyToMany(
			cascade=
					CascadeType.ALL
	)
	@JoinTable(name="lista_cartao",
		joinColumns = @JoinColumn(name="lista_id"),
		inverseJoinColumns = @JoinColumn(name="carta_id")
			)
	private List<Cartao> cartoes = new ArrayList<>();
	
}
