package com.project.web.capas.datos;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BibliotecaDao {

	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Libro> findAll(){
		return em.createQuery("from libros").getResultList();
	}
	
	@Transactional(readOnly = true)
	public Libro findOne(Long id) {
		return em.find(Libro.class, id);
	}
	
	@Transactional(readOnly = true)
	public List<Libro> findByTitle(String titulo) {
		return em.createQuery("select c from libros c", Libro.class).getResultList();
	}
	
	@Transactional
	public void save(Libro libro) {
		if(libro.getId()!=null && libro.getId()>0) {
			em.merge(libro);
		}else {
			em.persist(libro);
		}
	}
}
