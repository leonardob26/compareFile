package com.infosys.file.compareFile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.infosys.controller"})
public class CompareFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompareFileApplication.class, args);
	}
}
