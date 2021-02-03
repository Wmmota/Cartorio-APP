package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
public class Cartorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank(message = "O Nome do cartório é obrigatório")
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = "Logradouro é obrigatório")
	@Column(name = "Logradouro")
	private String logradouro;
	
	
	@Column(name = "CEP")
	private String CEP;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getCEP() {
		return CEP;
	}


	public void setCEP(String CEP) {
		this.CEP = CEP;
	}


	
	

}
