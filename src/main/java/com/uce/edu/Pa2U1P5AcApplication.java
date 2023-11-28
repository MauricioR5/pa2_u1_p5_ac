package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.INumeracionRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Numeracion;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.INumeracionService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5AcApplication implements CommandLineRunner {
	@Autowired
	private ITransferenciaService iTransferenciaService;

	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	
	@Autowired
	private INumeracionService iNumeracionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		// 1. Crear las cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("17171717");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));

		this.iCuentaBancariaService.guardar(ctaOrigen);

		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("12121212");
		ctaDestino.setNumero("4321");
		ctaDestino.setSaldo(new BigDecimal(200));

		this.iCuentaBancariaService.guardar(ctaDestino);

		this.iTransferenciaService.realizar("1234", "4321", new BigDecimal(10));
		
	
		
			CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
			System.out.println(ctaOrigen1);
			Numeracion num1 = new Numeracion();
			num1.setValor(1);
			this.iNumeracionService.guardar(1);
			this.iNumeracionService.contar();
			
			CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("4321");
			System.out.println(ctaDestino1);
			//this.iNumeracionService.contar();
			
		
			
	}
}
