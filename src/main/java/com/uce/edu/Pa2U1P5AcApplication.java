package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;

@SpringBootApplication
public class Pa2U1P5AcApplication implements CommandLineRunner
{

	@Autowired
	public Estudiante estudiante;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.estudiante.setNombre("Mauricio");
		this.estudiante.setApellido("Cacuango");
		this.estudiante.setCedula("1723524664");
		this.estudiante.setSalario(new BigDecimal(100));
		System.out.println(estudiante);
	}

	
}

