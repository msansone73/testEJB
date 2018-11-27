package br.msansone.testEJB.DAO;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.Model.Proprietario;
import br.msansone.testEJB.dataAccess.DataAccess;

@Stateless
public class ProprietarioDAO {

	public ProprietarioDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "emTeste")
	protected EntityManager em;

	@EJB
	DataAccess<Mensagem> dataAccess;

	@EJB
	Proprietario proprietario;

	private Long getSequenceProprietario() {

		Query q = em.createNativeQuery("SELECT seqproprietario.NEXTVAL FROM DUAL");
		return ((BigDecimal) q.getSingleResult()).longValueExact();

	}

	private Long getSequenceContato() {

		Query q = em.createNativeQuery("SELECT seqcontato.NEXTVAL FROM DUAL");
		return ((BigDecimal) q.getSingleResult()).longValueExact();

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Proprietario salvar(Proprietario proprietario) {

		if (proprietario.getId() == null) {
			Long idProprietario = getSequenceProprietario();
			proprietario.setId(idProprietario);
			proprietario.getContato().setId(idProprietario);
			em.persist(proprietario.getContato());
			em.persist(proprietario);
		} else {
			em.merge(proprietario.getContato());
			em.merge(proprietario);
		}
		return proprietario;
	}

}
