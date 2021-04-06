package com.deadsystem.apiregioes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.deadsystem.apievoluum.util.Util;

@SpringBootApplication
@EnableCaching
public class ApiRegioesApplication {
	
	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl(Util.BASE_URL).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiRegioesApplication.class, args);
	}

}
