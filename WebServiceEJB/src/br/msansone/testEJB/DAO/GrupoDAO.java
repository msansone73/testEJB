package br.msansone.testEJB.DAO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.msansone.testEJB.Model.Grupo;
import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.dataAccess.DataAccess;

@Stateless
public class GrupoDAO {

	public GrupoDAO() {
		super();
	}


	@PersistenceContext(unitName="emTeste")
	protected EntityManager em;
	
	@EJB
	DataAccess<Grupo> dataAccess;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Grupo salvar(Grupo grupo){
		return (Grupo) dataAccess.gravarEntidade(em, grupo);
	}
	
	public Grupo LerGrupoPorNome(String nome) {
		
		Query q = em.createQuery("select g from Grupo g where g.nome=:nome")
				.setParameter("nome", nome);	
		List<Grupo> grupos = dataAccess.lerDados(em, q);		
		
		return grupos.size()==0?null:grupos.get(0);

	}
	
	public List<Grupo> LerGruposPorNome(String nome) {
		Query q = em.createQuery("select t from Grupo t where t.nome=:nome")
				.setParameter("nome", nome);	
		List<Grupo> grupos = dataAccess.lerDados(em, q);	
		
		return grupos;

	}
	
}
