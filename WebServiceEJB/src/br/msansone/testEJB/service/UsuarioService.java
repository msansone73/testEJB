package br.msansone.testEJB.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.msansone.testEJB.DAO.GrupoDAO;
import br.msansone.testEJB.DAO.UsuarioDAO;
import br.msansone.testEJB.Model.Grupo;
import br.msansone.testEJB.Model.Usuario;
import jdk.nashorn.internal.runtime.ListAdapter;

@Stateless
public class UsuarioService {

	@EJB 
	UsuarioDAO usuarioDAO;
	
	@EJB
	GrupoDAO grupoDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Usuario salvarUsuario(Usuario usuario) {

		return usuarioDAO.gravarUsuario(usuario);
	}
	
	public List<Grupo> listarGruposPorNome(String nome){
		return (List<Grupo>) grupoDAO.LerGruposPorNome(nome);
	}
	
}