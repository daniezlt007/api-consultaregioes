package com.deadsystem.apievoluum;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.deadsystem.apievoluum.dto.CidadeDto;
import com.deadsystem.apievoluum.model.Mesorregiao;
import com.deadsystem.apievoluum.model.Microrregiao;
import com.deadsystem.apievoluum.model.Municipio;
import com.deadsystem.apievoluum.model.Regiao;
import com.deadsystem.apievoluum.model.RegiaoImediata;
import com.deadsystem.apievoluum.model.RegiaoIntermediaria;
import com.deadsystem.apievoluum.model.UF;
import com.deadsystem.apievoluum.service.CidadeService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApiTesteevoluumApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	public CidadeService cidadeService;

	@Test
	public void helloWorld() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello World"));
	}
	
	

	
	@Test
	public void testeHelloWorld() throws Exception {
		Regiao regiao = new Regiao(4, "S", "Sul");
		UF uf = new UF(42, "SC", "Santa Catarina", regiao);
		Mesorregiao mesorregiao = new Mesorregiao(4204, "Vale do Itajaí", uf);
		Microrregiao microrregiao = new Microrregiao(42012, "Blumenau", mesorregiao);
		RegiaoIntermediaria regiaoIntermediaria = new RegiaoIntermediaria(4207, "Blumenau", uf);
		RegiaoImediata regiaoImediata = new RegiaoImediata(420019, "Blumenau", regiaoIntermediaria);
		Municipio municipio = new Municipio(4202404, "Blumenau", microrregiao, regiaoImediata);
		CidadeDto cidadeDto = new CidadeDto(municipio);
		List<CidadeDto> dto = Arrays.asList(cidadeDto);
		
		com.fasterxml.jackson.databind.ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String mockJson = ow.writeValueAsString(dto);

		Assert.assertNotNull(dto);
	}
	
	@Test
	public void testeEntity() {
		Regiao regiao = new Regiao(4, "S", "Sul");
		UF uf = new UF(42, "SC", "Santa Catarina", regiao);
		Mesorregiao mesorregiao = new Mesorregiao(4204, "Vale do Itajaí", uf);
		Microrregiao microrregiao = new Microrregiao(42012, "Blumenau", mesorregiao);
		RegiaoIntermediaria regiaoIntermediaria = new RegiaoIntermediaria(4207, "Blumenau", uf);
		RegiaoImediata regiaoImediata = new RegiaoImediata(420019, "Blumenau", regiaoIntermediaria);
		Municipio municipio = new Municipio(4202404, "Blumenau", microrregiao, regiaoImediata);
		CidadeDto cidadeDto = new CidadeDto(municipio);
		List<CidadeDto> dto = Arrays.asList(cidadeDto);
	}
	
	@Test
	public void testeRetornaObjeto() {
		Integer id = this.cidadeService.retornarCidadePeloNome("Blumenau");
		assertNotNull(id);
	}
	
	

}
