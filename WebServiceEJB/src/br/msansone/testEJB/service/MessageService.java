package br.msansone.testEJB.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.msansone.testEJB.DAO.MessageDAO;
import br.msansone.testEJB.Model.Mensagem;

@Stateless
public class MessageService {

	@EJB
	MessageDAO messageDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void gravarMensage(Mensagem mensagem) {
		messageDAO.gravarMensage(mensagem);
	}

	public List<Mensagem> listarTodas() {
		return messageDAO.listarTodas();
	}

	public Mensagem retornarMensage(Long id) {
		return messageDAO.retornarMensage(id);
	}
	
	
	

}
