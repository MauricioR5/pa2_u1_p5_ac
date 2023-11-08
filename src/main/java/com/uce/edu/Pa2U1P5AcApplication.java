package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P5AcApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundo");
		System.out.println("Soy Mauricio Cacuango");
		System.out.println("Primer programa en spring");
	}

	
}

