package br.msansone.testEJB.dataAccess;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DataAccess<E> {
	
	public DataAccess() {
		super();
	}

	public List<E> lerDados(EntityManager em, String query){

		Query q = em.createQuery(query);
		List<E> lista =  q.getResultList();
		return lista;
		
	}
	
	public List<E> lerDados(EntityManager em, Query q){

		List<E> lista =  q.getResultList();
		return lista;
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarDados(EntityManager em, Object entidade) {

		em.persist(entidade);

	}
	

}
