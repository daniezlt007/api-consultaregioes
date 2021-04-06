package com.deadsystem.apievoluum.model;

import java.io.Serializable;

public class Microrregiao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private Mesorregiao mesorregiao;
	
	public Microrregiao() {
		
	}
	
	public Microrregiao(Integer id, String nome, Mesorregiao mesorregiao) {
		super();
		this.id = id;
		this.nome = nome;
		this.mesorregiao = mesorregiao;
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
	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}
	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
	}
	
	
	
}

