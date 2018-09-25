package com.haylton.estudo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Placa {
	@Id
	@SequenceGenerator(name="seq_placa", sequenceName="seq_placa", allocationSize=1)
	@GeneratedValue(generator="seq_placa")
	private Integer id;
	private String nome;

}
