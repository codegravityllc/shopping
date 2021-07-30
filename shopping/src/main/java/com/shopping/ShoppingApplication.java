package com.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages= {"com.servlet"})
public class ShoppingApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}
//8080
}
