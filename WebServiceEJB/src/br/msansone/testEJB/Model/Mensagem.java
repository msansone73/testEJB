package br.msansone.testEJB.Model;


import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Stateless
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String conteudo;
    private String usuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario responsavel;
    
    
    
    public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Mensagem() {
	}
    
    public Mensagem(String conteudo) {
		this.conteudo = conteudo;
	}
    
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo =conteudo;
	}
	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", conteudo=" + conteudo + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	
}