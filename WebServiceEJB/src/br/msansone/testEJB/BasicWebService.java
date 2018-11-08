package br.msansone.testEJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.Model.Resultado;
import br.msansone.testEJB.core.MathFin;
import br.msansone.testEJB.service.MessageService;

@Stateless
@WebService
public class BasicWebService {

	public BasicWebService() {
	}

	@WebMethod
	public String criarMensagem(@WebParam(name = "nome") String nome) {
		return "Ola " + nome + " seja bem vinda a critical! 1.21 " + System.currentTimeMillis();
	}

	@WebMethod
	public Resultado calculaJuros(@WebParam(name = "valInicial") Double valor, @WebParam(name = "juros") Double juros,
			@WebParam(name = "anos") Integer anos) {

		Resultado resultado = MathFin.calculaJuros(valor, juros, anos);

		return resultado;
	}

	@WebMethod
	public void gravarMensagem(@WebParam(name = "mensagem") String mensagem) {
	
		MessageService messageService = new MessageService();
		messageService.gravarMensage(new Mensagem(mensagem));
	}

	@WebMethod
	public String consultaMensagem(@WebParam(name = "id") Long id) {

		MessageService messageService = new MessageService();
		return  messageService.retornarMensage(id).getConteudo();
		
	}

	@WebMethod
	public List<Mensagem> consultaTodasMensagens() {
		

		MessageService messageService = new MessageService();
		return  messageService.listarTodas();

	}
}
