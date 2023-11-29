package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5AcApplication implements CommandLineRunner {

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	/* DI por constructor
	@Autowired
	public Pa2U1P5AcApplication(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
		
	}DI por metodo
	@Autowired
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService= iTransferenciaService;
	}*/
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;

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

		this.iTransferenciaService.realizar("1234", "4321", new BigDecimal(20));		
		
		this.iTransferenciaService.realizar("1234", "4321",new BigDecimal(30));
		this.iTransferenciaService.realizar("4321", "1234",new BigDecimal(30));
		
		List<Transferencia> lista = this.iTransferenciaService.buscarTodos();
		int indice=0;
		for(Transferencia trans : lista) {
			indice++;
			System.out.println(indice + ":"+ trans);
			
			
		}

		CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
		System.out.println(ctaOrigen1);
		CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("4321");
		System.out.println(ctaDestino1);
		
		//Deposito
		
		CuentaBancaria cuentaD = new CuentaBancaria();
		cuentaD.setCedulaPropietario("123123123");
		cuentaD.setNumero("55555");
		cuentaD.setSaldo(new BigDecimal(50));
		
		this.iCuentaBancariaService.guardar(cuentaD);
		this.iTransferenciaService.depositar("55555", new BigDecimal(100));
		
		CuentaBancaria ctaDepositada = this.iCuentaBancariaService.buscar("55555");
		System.out.println(ctaDepositada);

	}
}
