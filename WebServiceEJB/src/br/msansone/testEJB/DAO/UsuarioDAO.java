package br.msansone.testEJB.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.msansone.testEJB.Model.Grupo;
import br.msansone.testEJB.Model.Usuario;
import br.msansone.testEJB.dataAccess.DataAccess;

@Stateless
public class UsuarioDAO {

	public UsuarioDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PersistenceContext(unitName="emTeste")
	protected EntityManager em;
	
	@EJB
	DataAccess<Usuario> dataAccess;
	
	@EJB
	GrupoDAO grupoDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Usuario gravarUsuario(Usuario usuario) {
		
		usuario = this.atualizaStatusGrupo(usuario);
		return (Usuario) dataAccess.gravarEntidade(em, usuario);
	}
	
	private Usuario atualizaStatusGrupo(Usuario usuario) {
		
		List<Grupo> gruponovo = new ArrayList<>();
		if (usuario.getGrupos().size()!=0) {			
			for ( Grupo g : usuario.getGrupos()) {			
				if (grupoDAO.LerGrupoPorNome(g.getNome())!=null) {
					gruponovo.add(grupoDAO.LerGrupoPorNome(g.getNome()));
				} else {
					gruponovo.add(g);
				}
			}
		}
		usuario.setGrupos(gruponovo);
		return usuario;
	}
	
}
