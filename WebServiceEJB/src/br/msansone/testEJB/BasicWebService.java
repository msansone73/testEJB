package br.msansone.testEJB;


import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import br.msansone.testEJB.Model.Contato;
import br.msansone.testEJB.Model.Grupo;
import br.msansone.testEJB.Model.Mensagem;
import br.msansone.testEJB.Model.Proprietario;
import br.msansone.testEJB.Model.Resultado;
import br.msansone.testEJB.Model.Usuario;
import br.msansone.testEJB.core.Comunica;
import br.msansone.testEJB.core.IMath;
import br.msansone.testEJB.service.MessageService;
import br.msansone.testEJB.service.ProprietarioService;
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

	@EJB
	ProprietarioService proprietarioService;

	
	
	public BasicWebService() {
		super();
	}

	@WebMethod
	public Grupo inserirGrupo(@WebParam(name="nome") String nome,
			@WebParam(name="descricao") String descricao) {
		return usuarioService.salvar(new Grupo(nome, descricao));
	}
	
	@WebMethod
	public Proprietario inserirProprietario(@WebParam(name="nome") String nome,
			@WebParam(name="CPF") String cpf,
			@WebParam(name="foneResidencial") String foneResidencial,
			@WebParam(name="foneComercial") String foneComercial,
			@WebParam(name="emailPessoal") String emailPessoal,
			@WebParam(name="emailTrabalho") String emailTrabalho,
			@WebParam(name="celPessoal") String celPessoal,
			@WebParam(name="celTrabalho") String celTrabalho) {
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome(nome);
		proprietario.setCPF(cpf);
		proprietario.setContato(new Contato(foneResidencial, foneComercial, emailPessoal, emailTrabalho, celPessoal, celTrabalho));
		
		return proprietarioService.salvar(proprietario);
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
	public List<Usuario> listarUsuarioPorGrupo(
			@WebParam(name="idGrupo") Integer idGrupo){

		return usuarioService.listarUsuarioPorGrupo(idGrupo);
	}

	@WebMethod
	public Usuario criarUsuario(
			@WebParam(name = "nome") String nome,
			@WebParam(name = "email") String email,
			@WebParam(name = "senha") String senha) {

			
		Usuario usuario= new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);		

		usuario= usuarioService.salvarUsuario(usuario);

		return usuario;
		
	}
	
	

	
}
