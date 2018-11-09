package br.msansone.testEJB.core;

import javax.ejb.Stateless;

@Stateless
public class Comunica {
	
	public Comunica() {
	}

	public String format(String nome) {
		return "Ola " + nome + " seja bem vinda a critical! 2.11 " + System.currentTimeMillis();
	}

}
