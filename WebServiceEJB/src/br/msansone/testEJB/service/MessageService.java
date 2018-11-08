package br.msansone.testEJB.service;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.TransactionManager;

import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.dataAccess.DataAccess;

public class MessageService {

	private static final String PERSISTENCE_UNIT_NAME = "test";
	private static EntityManagerFactory factory;
	EntityManager em=null;
	
	public MessageService() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}
	
	public List<Mensagem> listarTodas(){
		DataAccess<Mensagem> dataAccess = new DataAccess<>();
		return dataAccess.lerDados(em, "select t from Mensagem t ");	
	}
	
	public Mensagem retornarMensage(Long id){
		DataAccess<Mensagem> dataAccess = new DataAccess<>();
		Query q = em.createQuery("select t from Mensagem t where t.id=:id").setParameter("id", id);	
		List<Mensagem> mensagens = dataAccess.lerDados(em, q);		
		return mensagens.size()==0?null:mensagens.get(0);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarMensage(Mensagem mensagem){	
		
		DataAccess<Mensagem> dataAccess = new DataAccess<>();
		dataAccess.gravarDados(em,mensagem);
	}
}
