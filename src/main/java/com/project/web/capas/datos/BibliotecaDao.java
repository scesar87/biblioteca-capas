package com.project.web.capas.datos;

import org.springframework.data.repository.CrudRepository;

public interface BibliotecaDao extends CrudRepository<Libro, Long>{

	public Libro findByTitulo(String titulo);
}
