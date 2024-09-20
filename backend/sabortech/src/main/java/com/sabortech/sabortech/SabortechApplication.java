package com.sabortech.sabortech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class SabortechApplication {

	public static void main(String[] args) {
		// Cargar las variables de entorno desde el archivo .env en la carpeta raíz del
		// proyecto
		Dotenv dotenv = Dotenv.configure()
				.directory(System.getProperty("user.dir"))
				.load();
		System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("SPRING_DATASOURCE_URL"));
		System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("SPRING_DATASOURCE_USERNAME"));
		System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("SPRING_DATASOURCE_PASSWORD"));

		SpringApplication.run(SabortechApplication.class, args);
	}
}