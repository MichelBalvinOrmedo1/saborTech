package com.sabortech.sabortech;

import java.security.Key;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication
public class SabortechApplication {

	public static void main(String[] args) {
		// Cargar las variables de entorno desde el archivo .env en la carpeta raíz del
		// proyecto
		Dotenv dotenv = Dotenv.configure()
				.directory(System.getProperty("user.dir"))
				.load();
		System.setProperty("SPRING_DATASOURCE_URL",
				dotenv.get("SPRING_DATASOURCE_URL"));
		System.setProperty("SPRING_DATASOURCE_USERNAME",
				dotenv.get("SPRING_DATASOURCE_USERNAME"));
		System.setProperty("SPRING_DATASOURCE_PASSWORD",
				dotenv.get("SPRING_DATASOURCE_PASSWORD"));
		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET")); // Añadir esta línea

		SpringApplication.run(SabortechApplication.class, args);
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // o HS512, HS384
		String base64Key = Encoders.BASE64.encode(key.getEncoded());
		System.out.println(base64Key);

	}
}