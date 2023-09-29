package com.trungnguyen.coffeeshop.configuration;

import org.junit.ClassRule;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@TestConfiguration
public class DatabaseTestConfiguration {

    @ClassRule
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("coffee_shop_system_management")
            .withInitScript("test-scripts.sql")
            .withUsername("postgres")
            .withPassword("test12345");

    @Bean
    public DataSource dataSource(){
        postgreSQLContainer.start();
        System.out.println("url " + postgreSQLContainer.getJdbcUrl());
        return DataSourceBuilder.create()
                .driverClassName(postgreSQLContainer.getDriverClassName())
                .url(postgreSQLContainer.getJdbcUrl())
                .username(postgreSQLContainer.getUsername())
                .password(postgreSQLContainer.getPassword())
                .build();
    }
}
