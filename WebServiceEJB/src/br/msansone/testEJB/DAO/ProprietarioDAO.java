package br.msansone.testEJB.DAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.Model.Proprietario;
import br.msansone.testEJB.dataAccess.DataAccess;

@Stateless
public class ProprietarioDAO {

	
	
	public ProprietarioDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName="emTeste") 
	protected EntityManager em;
	
	@EJB
	DataAccess<Mensagem> dataAccess;
	
	@EJB
	Proprietario proprietario;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Proprietario salvar(Proprietario proprietario) {
		
		if (proprietario.getId()==null) {
			em.persist(proprietario);
		}else {
			em.merge(proprietario);
		}
		return proprietario;
	}
	
}
