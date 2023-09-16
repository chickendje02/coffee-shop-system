package com.trungnguyen.coffeeshopservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeShopServiceApplication {

	public static void main(String[] args) {
		System.setProperty("liquibase.secureParsing", "false");
		SpringApplication.run(CoffeeShopServiceApplication.class, args);
	}

}
