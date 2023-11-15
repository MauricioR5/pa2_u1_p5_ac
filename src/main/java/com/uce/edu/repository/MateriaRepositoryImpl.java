package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;

@Repository //Delegar al framework
public class MateriaRepositoryImpl implements IMateriaRepository{

	@Override
	public Materia seleccionar(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(String codigo) {
		// TODO Auto-generated method stub
		
	}

}
