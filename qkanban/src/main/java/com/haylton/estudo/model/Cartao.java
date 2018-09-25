package com.haylton.estudo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Cartao {
	@Id
	@SequenceGenerator(name="seq_cartao", sequenceName="seq_cartao", allocationSize=1)
	@GeneratedValue(generator="seq_cartao")
	private Integer id;
	@ManyToMany(mappedBy= "cartoes")
	private List<Lista> listas = new ArrayList<>();
}
