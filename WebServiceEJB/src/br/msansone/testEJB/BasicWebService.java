package br.msansone.testEJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.Model.Resultado;
import br.msansone.testEJB.core.MathFin;

@Stateless
@WebService
public class BasicWebService {

	public BasicWebService() {
	}

	@WebMethod
	public String criarMensagem(@WebParam(name = "nome") String nome) {
		return "Ola " + nome + " seja bem vinda a critical! 0.24 " + System.currentTimeMillis();
	}

	@WebMethod
	public Resultado calculaJuros(@WebParam(name = "valInicial") Double valor, @WebParam(name = "juros") Double juros,
			@WebParam(name = "anos") Integer anos) {

		Resultado resultado = MathFin.calculaJuros(valor, juros, anos);

		return resultado;
	}

	@WebMethod
	public String gravarMensagem(@WebParam(name = "mensagem") String mensagem) {

		DataAccess.gravarMensagem(mensagem);
		return "A mensagem: " + mensagem + " foi salva com sucesso.";
	}

	@WebMethod
	public String consultaMensagem(@WebParam(name = "id") Long id) {

		String mensagem = DataAccess.lerMensagem(id);
		if (mensagem.length() == 0) {
			return "Mensagem n�o encontrada.";
		}

		return "A mensagem de id= " + id + " � " + mensagem + " ." + System.currentTimeMillis();
	}

	@WebMethod
	public List<Mensagem> consultaTodasMensagens() {

		return DataAccess.lerTodasMensagens();

	}
}