package com.uce.edu.transferencia.service;

import com.uce.edu.transferencia.repository.modelo.Numeracion;

public interface INumeracionService {
	
	public Numeracion buscar(Integer valor);

	public void guardar(Integer valor);

	public void actualizar(Numeracion numeracion);

	public void eliminar(Integer valor);
	
	public Integer contar();
}
