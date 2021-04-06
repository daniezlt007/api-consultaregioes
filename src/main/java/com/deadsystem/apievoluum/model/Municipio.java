package com.deadsystem.apievoluum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Municipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	@JsonProperty("microrregiao")
	private Microrregiao microrregiao;
	@JsonProperty("regiao-imediata")
	private RegiaoImediata regiaoImediata;
	
	public Municipio() {

	}

	public Municipio(Integer id, String nome, Microrregiao microrregiao, RegiaoImediata regiaoImediata) {
		super();
		this.id = id;
		this.nome = nome;
		this.microrregiao = microrregiao;
		this.regiaoImediata = regiaoImediata;
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

	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
	}

	public RegiaoImediata getRegiaoImediata() {
		return regiaoImediata;
	}

	public void setRegiaoImediata(RegiaoImediata regiaoImediata) {
		this.regiaoImediata = regiaoImediata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((microrregiao == null) ? 0 : microrregiao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (microrregiao == null) {
			if (other.microrregiao != null)
				return false;
		} else if (!microrregiao.equals(other.microrregiao))
			return false;
		return true;
	}
	
}
