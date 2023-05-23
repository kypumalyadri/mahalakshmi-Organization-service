package com.organisation.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//@ComponentScan(basePackages = { "com.gf.organisationservice" })//
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = { "com.gf.organisationservice" })//
/*@ComponentScan(basePackages = {"com.organisation.OrganisationServiceApplication"})*/
@OpenAPIDefinition
@SpringBootApplication
//@ComponentScan("com.gf.organisationservice")//
public class OrganisationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationServiceApplication.class, args);
	}

}
