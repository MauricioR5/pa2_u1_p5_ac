package com.uce.edu.transferencia.repository;

import com.uce.edu.transferencia.repository.modelo.Numeracion;

public interface INumeracionRepository {

	public Numeracion seleccionar(Integer valor);

	public void insertar(Integer valor);

	public void actualizar(Numeracion numeracion);

	public void eliminar(Integer valor);

	public Integer contar(Integer valor);
}
