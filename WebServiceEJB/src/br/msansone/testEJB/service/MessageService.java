package br.msansone.testEJB.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.dataAccess.DataAccess;

@Stateless
public class MessageService {

	
	public MessageService() {
		super();
	}

	@EJB
	@PersistenceContext(unitName="em")
	private EntityManager em;
	
	@EJB
	DataAccess<Mensagem> dataAccess;
	
	public List<Mensagem> listarTodas(){
		return dataAccess.lerDados(em, "select t from Mensagem t ");	
	}
	
	public Mensagem retornarMensage(Long id){
		Query q = em.createQuery("select t from Mensagem t where t.id=:id").setParameter("id", id);	
		List<Mensagem> mensagens = dataAccess.lerDados(em, q);		
		return mensagens.size()==0?null:mensagens.get(0);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarMensage(Mensagem mensagem){			
		dataAccess.gravarDados(em,mensagem);
	}
}
