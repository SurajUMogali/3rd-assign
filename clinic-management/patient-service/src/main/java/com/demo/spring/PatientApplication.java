package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication


public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

	@Bean
	public OpenAPI openApiDoc() {
		return new OpenAPI().info(new Info().description("Mock project on Patient in Clinic-Management")
				.license(new License().name("Free for All")).title("Mock Project Document").version("1.0.0-BETA"));
	}

}
