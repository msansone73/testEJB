package br.msansone.testEJB;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.Model.Resultado;
import br.msansone.testEJB.core.Comunica;
import br.msansone.testEJB.core.IMath;
import br.msansone.testEJB.service.MessageService;

@Stateless
@WebService
public class BasicWebService {
	
	@EJB
	MessageService messageServiceInj;
	
	@EJB
	IMath mathFin;
	
	@EJB
	Comunica comunica;
	
	

	public BasicWebService() {
		super();
	}

	@WebMethod
	public String criarMensagem(@WebParam(name = "nome") String nome) {
		return comunica.format(nome);
	}

	@WebMethod
	public Resultado calculaJuros(@WebParam(name = "valInicial") Double valor, @WebParam(name = "juros") Double juros,
			@WebParam(name = "anos") Integer anos) {

		Resultado resultado = mathFin.calculaJuros(valor, juros, anos);

		return resultado;
	}

	@WebMethod
	public void gravarMensagem(@WebParam(name = "mensagem") String mensagem) {
	
		messageServiceInj.gravarMensage(new Mensagem(mensagem));
	}

	@WebMethod
	public String consultaMensagem(@WebParam(name = "id") Long id) {

		return  messageServiceInj.retornarMensage(id).getConteudo();
		
	}

	@WebMethod
	public List<Mensagem> consultaTodasMensagens() {
		
		if (messageServiceInj==null) 
		{
			System.out.println("messageServiceInj==null");
		}
		
		return  messageServiceInj.listarTodas();

	}
}
