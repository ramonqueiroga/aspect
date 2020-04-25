package com.example.aspect.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.boot.jdbc.DataSourceBuilder.create;

@Configuration
public class AppConfiguration {

    @Autowired
    private TesteInterceptor testeInterceptor;

    @Bean
    public DataSource dataSource() {
        return create()
                .username("postgres")
                .password("postgres")
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/aspectdb")
                .build();

    }

    @Bean(name = "restTemplateDefault")
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(this.testeInterceptor));
        return restTemplate;
    }

}
