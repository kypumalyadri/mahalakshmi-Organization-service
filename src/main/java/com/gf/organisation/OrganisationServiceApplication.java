package com.gf.organisation;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableJpaRepositories
@OpenAPIDefinition(
		  info = @Info(
		    title = "Organisation API",
		    version = "1.0.0",
		    description = "API for managing organisations"
		  )
		)
@SpringBootApplication
@ComponentScan("com.gf.organisation")
public class OrganisationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationServiceApplication.class, args);
	}


}


