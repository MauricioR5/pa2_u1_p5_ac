package com.uce.edu.transferencia.service;

import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.INumeracionRepository;
import com.uce.edu.transferencia.repository.modelo.Numeracion;
@Service
public class NumeracionServiceImpl implements INumeracionService {

	private INumeracionRepository iNumeracionRepository;
	

	@Override
	public Numeracion buscar(Integer valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Integer valor) {
		this.iNumeracionRepository.insertar(valor);
	}

	@Override
	public void actualizar(Numeracion numeracion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Integer valor) {
		// TODO Auto-generated method stub

	}


	@Override
	public Integer contar() {
		Numeracion num = new Numeracion();
		num.getValor();
		return this.iNumeracionRepository.contar(1);
	}


	
}
