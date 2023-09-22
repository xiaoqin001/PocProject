package com.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PocProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocProjectApplication.class, args);
	}

}



