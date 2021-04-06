package com.deadsystem.apievoluum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deadsystem.apievoluum.dto.CidadeDto;
import com.deadsystem.apievoluum.service.CidadeService;
import com.deadsystem.apievoluum.util.GeradorCsv;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CacheConfig(cacheNames = {"cidades"})
public class RestApiController {
	
	@Autowired
	private CidadeService cidadeService;
	
	public RestApiController(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de cidades"),
		    @ApiResponse(code = 204, message = "Não encontrado"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
		})
	@GetMapping("/cidades")
	@ResponseBody
	public ResponseEntity<?> listarMunicipiosFormatados(){
		List<CidadeDto> cidades = this.cidadeService.listarCidadesFormatado();
		return !cidades.isEmpty() ? ResponseEntity.ok(cidades) : ResponseEntity.noContent().build();
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna o id da cidade"),
		    @ApiResponse(code = 204, message = "Não encontrado"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
		})
	@GetMapping("/cidades/{nome}")
	@ResponseBody
	@Cacheable
	public ResponseEntity<?> retornarCidadePeloNome(@PathVariable("nome") String nome){
		Integer idCidade = this.cidadeService.retornarCidadePeloNome(nome); 
		return idCidade > 0 ? ResponseEntity.ok(idCidade) : ResponseEntity.noContent().build();
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Gera arquivo CSV"),
		    @ApiResponse(code = 500, message = "Problema ao gerar o arquivo."),
		})
	@GetMapping("/cidades/exportcsv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
       List<CidadeDto> listaEstados = this.cidadeService.listarCidadesFormatado();
       GeradorCsv.gerarCsvDownload(response, listaEstados);
    }
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
}
