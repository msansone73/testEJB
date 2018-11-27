package br.msansone.testEJB.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.msansone.testEJB.DAO.ProprietarioDAO;
import br.msansone.testEJB.DAO.UsuarioDAO;
import br.msansone.testEJB.Model.Proprietario;
import br.msansone.testEJB.Model.Usuario;

@Stateless
public class ProprietarioService {

@EJB
ProprietarioDAO proprietarioDAO;

@EJB
UsuarioDAO usuarioDAO;

public Proprietario salvar(Proprietario proprietario) {

	Usuario usuario= usuarioDAO.lerUsuarioByEmail("msansone@gmail.com");
	proprietario.setUsuario(usuario);
	proprietarioDAO.salvar(proprietario);
	return proprietario;
}
	
}
