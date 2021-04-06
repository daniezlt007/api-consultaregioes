package com.deadsystem.apievoluum.dto;

import java.io.Serializable;

import com.deadsystem.apievoluum.model.Municipio;

import io.swagger.annotations.ApiModelProperty;

public class CidadeDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "Código do Estado")
	private Integer idEstado;
	private String siglaEstado;
	private String regiaoNome;
	private String nomeCidade;
	private String nomeMesorregiao;
	private String nomeFormatado;
	
	public CidadeDto() {
		
	}
	
	public CidadeDto(Municipio municipio) {
		this.idEstado = municipio.getMicrorregiao().getMesorregiao().getUF().getId();
		this.siglaEstado = municipio.getMicrorregiao().getMesorregiao().getUF().getSigla();
		this.regiaoNome = municipio.getMicrorregiao().getNome();
		this.nomeCidade = municipio.getNome();
		this.nomeMesorregiao = municipio.getMicrorregiao().getMesorregiao().getNome();
		this.nomeFormatado = municipio.getNome() + "/" + municipio.getMicrorregiao().getMesorregiao().getUF().getSigla();
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public String getRegiaoNome() {
		return regiaoNome;
	}

	public void setRegiaoNome(String regiaoNome) {
		this.regiaoNome = regiaoNome;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getNomeMesorregiao() {
		return nomeMesorregiao;
	}

	public void setNomeMesorregiao(String nomeMesorregiao) {
		this.nomeMesorregiao = nomeMesorregiao;
	}

	public String getNomeFormatado() {
		return nomeFormatado;
	}

	public void setNomeFormatado(String nomeFormatado) {
		this.nomeFormatado = nomeFormatado;
	}
	
}
