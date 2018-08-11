package com.example.aspect.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static org.springframework.boot.jdbc.DataSourceBuilder.create;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource() {
        return create()
                .username("postgres")
                .password("postgres")
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/aspectdb")
                .build();

    }

}
