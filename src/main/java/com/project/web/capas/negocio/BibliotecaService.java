package com.project.web.capas.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.web.capas.datos.BibliotecaDao;
import com.project.web.capas.datos.Libro;

@Service
public class BibliotecaService {
	
	@Autowired
	private BibliotecaDao dao;
	
	public List<Libro> listarLibros(){
		return dao.findAll();
	}
	
	public String solicitarLibro(Libro libro) {
		String message;
		
		if(libro.getCantidad()<=0) {
			message = "Libro no disponible";
		}else {
			libro.setCantidad(libro.getCantidad() - 1);
			dao.save(libro);
			message="Libro disponible";
		}
		return message;
	}
	
	public void devolverLibro(Libro libro) {
		libro.setCantidad(libro.getCantidad() + 1);
		dao.save(libro);
	}
}
