package com.deadsystem.apievoluum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegiaoImediata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	@JsonProperty("regiao-intermediaria")
	private RegiaoIntermediaria regiaoIntermediaria;
	
	public RegiaoImediata() {

	}

	public RegiaoImediata(Integer id, String nome, RegiaoIntermediaria regiaoIntermediaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.regiaoIntermediaria = regiaoIntermediaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RegiaoIntermediaria getRegiaoIntermediaria() {
		return regiaoIntermediaria;
	}

	public void setRegiaoIntermediaria(RegiaoIntermediaria regiaoIntermediaria) {
		this.regiaoIntermediaria = regiaoIntermediaria;
	}
	
}
