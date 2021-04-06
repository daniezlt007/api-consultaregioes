package com.deadsystem.apievoluum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegiaoIntermediaria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	@JsonProperty("UF")
	private UF uf;
	
	public RegiaoIntermediaria() {
		super();
	}

	public RegiaoIntermediaria(Integer id, String nome, UF uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
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

	public UF getUF() {
		return uf;
	}

	public void setUF(UF uf) {
		this.uf = uf;
	}
		

}
