package com.deadsystem.apievoluum.service;

import java.util.List;

import com.deadsystem.apievoluum.dto.CidadeDto;
import com.deadsystem.apievoluum.model.Municipio;

public interface CidadeServiceImplement {
	
	public List<CidadeDto> listarCidadesFormatado();
	public Integer retornarCidadePeloNome(String nome);

}
