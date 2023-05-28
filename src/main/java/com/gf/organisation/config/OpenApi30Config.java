package com.gf.organisation.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi30Config {

    @Bean
    public GroupedOpenApi api() {
        String[] paths = {"/**"}; // Specify the paths to include in the documentation
        String[] packagesToScan = {"com.gf.organisation.controller"}; 

        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch(paths)
                .packagesToScan(packagesToScan)
                .build();
    }
}

