package com.organisation.service.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;





@Configuration
@OpenAPIDefinition(info = @Info(title = "organisation service",version = "v1"))

@SecurityScheme(
name = "bererAuth",
type = SecuritySchemeType.HTTP,

bearerFormat = "JWT",

scheme = "bearer"


)

public class OpenApi30Config {

}
