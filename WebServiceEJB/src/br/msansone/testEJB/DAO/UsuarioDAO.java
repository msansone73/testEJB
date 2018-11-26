package br.msansone.testEJB.DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.msansone.testEJB.Model.Grupo;
import br.msansone.testEJB.Model.Usuario;
import br.msansone.testEJB.dataAccess.DataAccess;
import br.msansone.testEJB.service.UsuarioService;

@Stateless
public class UsuarioDAO {

	public UsuarioDAO() {
	}

	@PersistenceContext(unitName = "emTeste")
	protected EntityManager em;

	@EJB
	DataAccess<Usuario> dataAccess;

	@EJB
	GrupoDAO grupoDAO;

	private Long getSequenceUsuario() {

		Query q = em.createNativeQuery("SELECT seqgrupo.NEXTVAL FROM DUAL");
		return  ((BigDecimal) q.getSingleResult()).longValueExact();
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Usuario gravarUsuario(Usuario usuario) {

		if (usuario.getId()==null) {
			usuario.setId(getSequenceUsuario());
		}
		
		usuario = this.atualizaStatusGrupo(usuario);
		return (Usuario) dataAccess.gravarEntidade(em, usuario);
	}

	public List<Usuario> listarUsuarioPorGrupo(Integer idGrupo) {
		Grupo grupo = new Grupo();
		grupo.setId(new Long(idGrupo));
		
		Query q = (Query) em.createQuery("select u from Usuario u join u.grupos g where g=:grupo")
			.setParameter("grupo", grupo);
		return dataAccess.lerDados(em, q);
	}

	private Usuario atualizaStatusGrupo(Usuario usuario) {

		List<Grupo> gruponovo = new ArrayList<>();
		if (usuario.getGrupos().size() != 0) {
			for (Grupo g : usuario.getGrupos()) {
				if (grupoDAO.LerGrupoPorNome(g.getNome()) != null) {
					gruponovo.add(grupoDAO.LerGrupoPorNome(g.getNome()));
				} else {
					gruponovo.add(g);
				}
			}
		}
		usuario.setGrupos(gruponovo);
		return usuario;
	}

	public Usuario ler(Long id) {
		Usuario usuario= new Usuario();
		usuario.setId(new Long(1));
		Query q = (Query) em.createQuery("select u from Usuario u where u=:usuario")
				.setParameter("usuario", usuario);
		List<Usuario> usuarios = dataAccess.lerDados(em, q);
		return usuarios.size()==0?null:usuarios.get(0);
	}

}
