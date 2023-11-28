package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.Numeracion;

@Repository
public class NumeracionRepositoryImpl implements INumeracionRepository {

	private static List<Integer> base = new ArrayList();
	@Override
	public Numeracion seleccionar(Integer valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Integer valor) {
		base.add(1);

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
	public Integer contar(Integer valor) {
		for(Integer num:base) {
			if(num.equals(valor)) {
			
				return num;
		}
			
	
			
				
			}return null;
	}

}
