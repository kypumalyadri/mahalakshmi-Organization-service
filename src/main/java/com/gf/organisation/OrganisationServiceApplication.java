package com.gf.organisation;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gf.organisation.entity.Organisation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
//@ComponentScan(basePackages = { "com.gf.organisationservice" })//
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = { "com.gf.organisationservice" })//
/*@ComponentScan(basePackages = {"com.organisation.OrganisationServiceApplication"})*/
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


