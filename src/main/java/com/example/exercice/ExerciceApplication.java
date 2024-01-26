package com.example.exercice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * La classe principale pour l'application Exercice.
 * 
 * Cette classe démarre l'application Spring Boot.
 */
@SpringBootApplication
public class ExerciceApplication {

	/**
	 * Le point d'entrée principal de l'application.
	 *
	 * @param args Les arguments de ligne de commande passés à l'application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ExerciceApplication.class, args);
	}

}
