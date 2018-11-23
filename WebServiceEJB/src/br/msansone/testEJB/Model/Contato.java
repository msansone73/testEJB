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
	private String celPessoal;
	private String celTrabalho;
	
	
	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
	public Contato(String foneResidencial, String foneComercial, String emailPessoal, String emailTrabalho,
			String celPessoal, String celTrabalho) {
		super();
		this.foneResidencial = foneResidencial;
		this.foneComercial = foneComercial;
		this.emailPessoal = emailPessoal;
		this.emailTrabalho = emailTrabalho;
		this.celPessoal = celPessoal;
		this.celTrabalho = celTrabalho;
	}






	public String getFoneResidencial() {
		return foneResidencial;
	}

	public void setFoneResidencial(String foneResidencial) {
		this.foneResidencial = foneResidencial;
	}

	public String getCelPessoal() {
		return celPessoal;
	}

	public void setCelPessoal(String celPessoal) {
		this.celPessoal = celPessoal;
	}

	public String getCelTrabalho() {
		return celTrabalho;
	}

	public void setCelTrabalho(String celTrabalho) {
		this.celTrabalho = celTrabalho;
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
