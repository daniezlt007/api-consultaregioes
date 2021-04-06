package com.deadsystem.apievoluum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.deadsystem.apievoluum.dto.CidadeDto;
import com.deadsystem.apievoluum.model.Municipio;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CidadeService implements CidadeServiceImplement {

	@Autowired
	private WebClient webClient;
	
	@Override
	public List<CidadeDto> listarCidadesFormatado(){
		Flux<Municipio> bodyToFlux = this.webClient.method(HttpMethod.GET).uri("/municipios").retrieve().bodyToFlux(Municipio.class);
		Mono<List<Municipio>> monoCidades = bodyToFlux.collectList();
		List<Municipio> cidades = monoCidades.block();
		return retornaCidades(cidades);
	}
	
	@Override
	public Integer retornarCidadePeloNome(String nome){
		try {
			Mono<Municipio> monoCidade = this.webClient.method(HttpMethod.GET).uri("/municipios/{nome}", nome).retrieve().bodyToMono(Municipio.class);
			Municipio cidade = monoCidade.block();
			if(cidade == null) {
				return 0;
			}
			return cidade.getId();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
		
	}

	private List<CidadeDto> retornaCidades(List<Municipio> lista){
		List<CidadeDto> cidades = new ArrayList<>();
		if(lista.size() > 0){
			for (Municipio municipio : lista) {
				CidadeDto cidade = new CidadeDto(municipio);
				cidades.add(cidade);
			}
		}
		return cidades;
	}
	
	
	
}
