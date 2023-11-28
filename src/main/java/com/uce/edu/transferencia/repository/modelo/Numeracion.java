package com.uce.edu.transferencia.repository.modelo;

import org.springframework.stereotype.Component;

@Component
public class Numeracion {

	private Integer valor;

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Numeracion [valor=" + valor + "]";
	}
	
}
