package br.msansone.testEJB.Model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;



@Entity
@Stateless
public class Usuario {

	@Id
	private Long id;
	private String nome;
	private String senha;
	private String email;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="usuario_grupo",
    joinColumns=@JoinColumn(name="idUsuario"),
    inverseJoinColumns=@JoinColumn(name="idGrupo"))
	private List<Grupo> grupos;
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
}
