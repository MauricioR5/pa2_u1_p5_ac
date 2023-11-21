package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Materia;

@SpringBootApplication
public class Pa2U1P5AcApplication implements CommandLineRunner
{

	
	@Autowired
	private Materia materia;
	
	@Autowired
	private Materia materia1;
	
	@Autowired
	private Materia materia2;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		this.materia.setNombre("Avanzada II");
		System.out.println(this.materia);
		
		System.out.println(this.materia1);

		this.materia1.setNombre("Nuevo nombre");
		System.out.println(this.materia1);
		System.out.println(this.materia);
		
		
		this.materia2.setNombre("Nombre final");
		System.out.println(this.materia2);
		System.out.println(this.materia1);
		System.out.println(this.materia);



			
		}
}

