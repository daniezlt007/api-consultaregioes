package com.deadsystem.apievoluum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mesorregiao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	@JsonProperty("UF")
	private UF uf;
	
	public Mesorregiao() {

	}

	public Mesorregiao(Integer id, String nome, UF uf) {
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