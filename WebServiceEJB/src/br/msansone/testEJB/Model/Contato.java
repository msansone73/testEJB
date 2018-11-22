package br.msansone.testEJB.Model;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Stateless
public class Contato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String foneResidencial;
	private String foneComercial;
	private String emailPessoal;
	private String emailTrabalho;
	
	
	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Contato(String foneResidencial, String foneComercial, String emailPessoal, String emailTrabalho) {
		super();
		this.foneResidencial = foneResidencial;
		this.foneComercial = foneComercial;
		this.emailPessoal = emailPessoal;
		this.emailTrabalho = emailTrabalho;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getfoneResidencial() {
		return foneResidencial;
	}
	public void setfoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}
	public String getFoneComercial() {
		return foneComercial;
	}
	public void setFoneComercial(String foneComercial) {
		this.foneComercial = foneComercial;
	}
	public String getEmailPessoal() {
		return emailPessoal;
	}
	public void setEmailPessoal(String emailPessoal) {
		this.emailPessoal = emailPessoal;
	}
	public String getEmailTrabalho() {
		return emailTrabalho;
	}
	public void setEmailTrabalho(String emailTrabalho) {
		this.emailTrabalho = emailTrabalho;
	}
	
	
	
}
