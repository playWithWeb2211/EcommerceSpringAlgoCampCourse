package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceSpringApplication {

	public static void main(String[] args) {

		/**
		 * The Dotenv.configure().load() method loads environment variables from several locations in this order of precedence:
		 * Loading Locations (in order):
		 * System environment variables (highest priority)
		 * .env file in the current working directory (project root)
		 * Default values (if specified in code)
		 */
		Dotenv dotenv = Dotenv.configure().load();

		dotenv.entries().forEach(entry -> {
//			System.out.println("Setting system property: " + entry.getKey() + " = " + entry.getValue());
			System.setProperty(entry.getKey(), entry.getValue());
		}); // Set system properties from environment variables and set them

		SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
