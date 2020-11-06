package com.ldoc.lati.apirest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApirestApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ApirestApplication.class);

	public static void main(String[] args) {
		logger.info("Init the application...");
		SpringApplication.run(ApirestApplication.class, args);
	}

}
