package com.deadsystem.apievoluum.model;

import java.io.Serializable;

public class UF implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String sigla;
	private String nome;
	private Regiao regiao;

	public UF() {
		
	}

	public UF(Integer id, String sigla, String nome, Regiao regiao) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.regiao = regiao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
}
