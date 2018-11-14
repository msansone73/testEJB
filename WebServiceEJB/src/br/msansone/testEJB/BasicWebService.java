package br.msansone.testEJB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

import br.msansone.testEJB.Model.Grupo;
import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.Model.Resultado;
import br.msansone.testEJB.Model.Usuario;
import br.msansone.testEJB.core.Comunica;
import br.msansone.testEJB.core.IMath;
import br.msansone.testEJB.service.MessageService;
import br.msansone.testEJB.service.UsuarioService;

@Stateless
@WebService
public class BasicWebService {
	

	@EJB
	MessageService messageService;
	
	@EJB
	IMath mathFin;
	
	@EJB
	Comunica comunica;
	
	@EJB
	UsuarioService usuarioService;

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
	
		Mensagem mensagem2 = new Mensagem();
		mensagem2.setConteudo(mensagem);
		mensagem2.setUsuario("msansone");
		mensagem2.setData(Calendar.getInstance());
		messageService.gravarMensage(mensagem2);
	}

	@WebMethod
	public String consultaMensagem(@WebParam(name = "id") Long id) {

		return  messageService.retornarMensage(id).getConteudo();
		
	}

	@WebMethod
	public List<Mensagem> consultaTodasMensagens() {
			
		return  messageService.listarTodas();

	}
	
	@WebMethod
	public List<Grupo> listarGruposPorNome(
			@WebParam(name="nome") String nome){

		return usuarioService.listarGruposPorNome(nome);
	}

	@WebMethod
	public Usuario criarUsuario(
			@WebParam(name = "nome") String nome,
			@WebParam(name = "email") String email,
			@WebParam(name = "senha") String senha) {

		Grupo grupoU = new Grupo();
		grupoU.setNome("Usuario");
		grupoU.setDescricao("Grupo de usuarios.");
		
		Grupo grupoA = new Grupo();
		grupoA.setNome("Admin");
		grupoA.setDescricao("Grupo de adminstadores.");
		
		Usuario usuario= new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		if (usuario.getEmail().contains("@gmail.com")) {
			usuario.setGrupos(Arrays.asList(grupoU, grupoA));	
		}else {
			usuario.setGrupos(Arrays.asList(grupoU));
		}
		

		usuario= usuarioService.salvarUsuario(usuario);

		return usuario;
		
	}
	
	

	
}
