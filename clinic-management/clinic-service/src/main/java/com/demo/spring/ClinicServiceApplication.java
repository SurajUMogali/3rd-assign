package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPI30;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@OpenAPI30
public class ClinicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicServiceApplication.class, args);

	}
	 @Bean
	 OpenAPI openApiDoc() {
	       return new OpenAPI().info(new Info().description("Mock project on Clinic Management")
	               .license(new License().name("Free for All")).title("Mock Project Document").version("1.0.0-BETA"));
	    }
	 
	 @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplateBuilder().build();
	    }
	 
}