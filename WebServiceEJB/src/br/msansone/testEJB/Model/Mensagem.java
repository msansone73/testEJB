package br.msansone.testEJB.Model;


import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Stateless
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String conteudo;
    
    
    
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

	
	
}