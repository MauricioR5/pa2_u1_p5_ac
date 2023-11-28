package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;
	
	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		this.iTransferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		this.iTransferenciaRepository.eliminar(numero);
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {

		// Consultar lo que hace el método comparteTo
				// 1. Buscar Cta Origen
				CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.seleccionar(numeroOrigen);
				// 2. Consultar saldo
				BigDecimal saldoOrigen = ctaOrigen.getSaldo();
				// 3. Validar el saldo
				if (saldoOrigen.compareTo(monto) >= 0) {
					// 4. Restar monto
					BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
					// 5. Actualizar Cta Origen
					ctaOrigen.setSaldo(nuevoSaldoOrigen);
					this.iCuentaBancariaRepository.actualizar(ctaOrigen);

					// 6. Buscar Cta Destino
					CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.seleccionar(numeroDestino);
					// 7. Consultar Saldo
					BigDecimal saldoDestino = ctaDestino.getSaldo();
					// 8. Sumar monto
					BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
					// 9. Actualizar Cta Destino
					ctaDestino.setSaldo(nuevoSaldoDestino);
					this.iCuentaBancariaRepository.actualizar(ctaDestino);
					// 10. Crear la transfer
					Transferencia transferencia = new Transferencia();
					transferencia.setCuentaOrigen(ctaOrigen);
					transferencia.setCuentaDestino(ctaDestino);
					transferencia.setFecha(LocalDateTime.now());
					transferencia.setMonto(monto);
					transferencia.setNumero("123123123");// Deber: El numero debe sumar de 1 en 1

					this.iTransferenciaRepository.insertar(transferencia);
					System.out.println("Transferencia Realizada con éxito c:");

				} else {
					System.out.println("Saldo no disponible");
				}
	}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionarTodos();
	}

	@Override
	public void depositar(String numeroCuenta, BigDecimal monto) {
		CuentaBancaria cuenta = this.iCuentaBancariaRepository.seleccionar(numeroCuenta);
		BigDecimal saldo = cuenta.getSaldo();
		BigDecimal nuevoSaldo = saldo.add((monto.multiply(new BigDecimal(0.9))));
		cuenta.setSaldo(nuevoSaldo);
		this.iCuentaBancariaRepository.actualizar(cuenta);
		}

}
