package com.project.web.capas.presentacion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.web.capas.datos.Libro;
import com.project.web.capas.negocio.BibliotecaService;

@Controller
public class IndexController {
	
	Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private BibliotecaService servicio;
	
	@GetMapping(value = "/index")
	public String index() {

		List<Libro> libros = servicio.listarLibros();
		
		for(Libro libro: libros) {
			log.info(libro.getTitulo());
		}
		
		Libro libro1 = servicio.buscarLibroPorTitulo("Dracula");
		
		log.info(libro1.toString());
		
		
		return "index";
	}
	
}
