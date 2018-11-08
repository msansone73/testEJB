package br.msansone.testEJB.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DataAccess<E> {
	
	public List<E> lerDados(EntityManager em, String query){

		Query q = em.createQuery(query);
		List<E> lista =  q.getResultList();
		em.close();
		return lista;
		
	}
	
	public List<E> lerDados(EntityManager em, Query q){

		List<E> lista =  q.getResultList();
		em.close();
		return lista;
		
	}
	
	public void gravarDados(EntityManager em, Object entidade) {

		em.persist(entidade);
		em.close();

	}
	

}
