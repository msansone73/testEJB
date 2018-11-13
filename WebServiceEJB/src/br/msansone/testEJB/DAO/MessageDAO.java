package br.msansone.testEJB.DAO;

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
public class MessageDAO {

	
	public MessageDAO() {
		super();
	}
	
	@PersistenceContext(unitName="emTeste") 
	protected EntityManager em;
	
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
		System.out.println("inicio em");
		System.out.println(em.toString());
		System.out.println("fim em");
		dataAccess.gravarDados(em,mensagem);
	}
}
